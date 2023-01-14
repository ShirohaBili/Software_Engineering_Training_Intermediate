import imagereader.IImageIO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileInputStream;

public class ImplementImageIO implements IImageIO {

    //从字节数组中读取四个字节的数值
    public int byteToInt(byte[] b, int start)
    {
        //& 00ff是为了取得低八位
        int h1, h2, h3, h4;
        h1 = b[start + 3] & 0xff;
        h2 = b[start + 2] & 0xff;
        h3 = b[start + 1] & 0xff;
        h4 = b[start] & 0xff;
        //32位拼在一块
        return (h1 << 24 | h2 << 16 | h3 << 8 | h4);
    }

    public Image myRead(String filePath) {

        Image img = null;
        try {
            File file = new File(filePath);
            FileInputStream fInS = new FileInputStream(file);

            //位图头
            byte[] bitMapHeader = new byte[14];
            fInS.read(bitMapHeader, 0, 14);
            //位图信息
            byte[] bitMapInfo = new byte[40];
            fInS.read(bitMapInfo, 0, 40);

            // 像素位数
            int pixSize = (bitMapInfo[15] & 0xff) << 8 | (bitMapInfo[14] & 0xff);
            // 位图宽度、高度及图像大小
            int picWidth = byteToInt(bitMapInfo, 4);
            int picHeight = byteToInt(bitMapInfo, 8);
            int sizeOfImage = byteToInt(bitMapInfo, 20);

            if (pixSize == 24) {
                //读入位图像素数据
                byte[] rgbData = new byte[sizeOfImage];
                fInS.read(rgbData, 0, sizeOfImage);

                //pixels存着像素的处理过的rgb值
                int[] pixels = new int [picWidth * picHeight];
                //计算需要补零的位置
                int emptySpace = (sizeOfImage / picHeight) - 3 * picWidth;
                // 从下到上，从左到右存储图像
                int index = 0;
                for (int i = picHeight - 1; i >= 0; i--) {
                    for (int j = 0; j < picWidth; j++) {
                        //存入一个整数，以便接下来使用MemoryImageSource函数
                        pixels[i * picWidth + j] = 0xff << 24 | (rgbData[index + 2] & 0xff) << 16 |
                                (rgbData[index + 1] & 0xff) << 8 | (rgbData[index] & 0xff);
                        index = index +  3;
                    }
                    // 填补一行中的空白位置
                    index += emptySpace;
                }
                //创建图像
                img = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(picWidth, picHeight, pixels, 0, picWidth));
            } else {
                System.out.println("Expect a 24-bit Bitmap!");
            }
            fInS.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return img;
    }

    public Image myWrite(Image img, String filePath) {

        try {
            File imgFile = new File(filePath + "-BMP.bmp");
            //获取传入的Image的信息
            BufferedImage buffer = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            //绘制图像
            Graphics2D newPic = buffer.createGraphics();
            newPic.drawImage(img, 0, 0, null);
            newPic.dispose();
            //把处理完的图像保存为bmp格式图像
            ImageIO.write(buffer, "bmp", imgFile);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return img;
    }
}