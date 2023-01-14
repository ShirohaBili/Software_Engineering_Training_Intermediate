import imagereader.IImageProcessor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

class ImplementImageProcessor implements IImageProcessor {

    //把图像变成灰色
    public Image showGray(Image img) {
        return alterTone(img, 4);
    }
    //把图像变成红色
    public Image showChanelR(Image img) {
        return alterTone(img, 1);
    }
    //把图像变成绿色
    public Image showChanelG(Image img) {
        return alterTone(img, 2);
    }
    //把图像变成蓝色
    public Image showChanelB(Image img) {
        return alterTone(img, 3);
    }

    //输出调整后的rgb值
    public int alteredRGB(int rgb, int type) {
        switch (type) {
            case 1:
                //红色调
                return (rgb & 0xffff0000);
            case 2:
                //绿色调
                return (rgb & 0xff00ff00);
            case 3:
                //蓝色调
                return (rgb & 0xff0000ff);
            default:
                //此外是灰色调
                int r, g, b, grey;
                r = rgb & 0x00ff0000;
                g = rgb & 0x0000ff00;
                b = rgb & 0x000000ff;
                grey = (int)((r >> 16) * 0.299 + (g  >> 8) * 0.587 + b * 0.114);
                return (rgb & 0xff000000) + (grey << 16) + (grey << 8) + grey;
        }
    }

    public Image alterTone(Image img, int type) {
        //获取传入的Image的信息
        BufferedImage newPicture = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        //绘制图像
        Graphics2D painter = newPicture.createGraphics();
        painter.drawImage(img, 0, 0, null);
        painter.dispose();
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        //逐个像素地更改颜色
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                int rgb = newPicture.getRGB(i, j);
                //获得调整后的rgb值
                rgb = alteredRGB(rgb, type);
                newPicture.setRGB(i, j, rgb);
            }
        }
        return newPicture;
    }
}

