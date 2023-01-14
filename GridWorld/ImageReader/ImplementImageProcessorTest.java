import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.assertTrue;

public class ImplementImageProcessorTest {

    //先设置路径的前缀
    private final String filePath = "bmptest/";
    private final ImplementImageIO imgIO = new ImplementImageIO();
    private final ImplementImageProcessor imgProcessor = new ImplementImageProcessor();
    private final Image testee1 = imgIO.myRead(filePath + "1.bmp");
    private final Image testee2 = imgIO.myRead(filePath + "2.bmp");

    //比较两张位图的各项数据
    public boolean cmp(Image img1, Image img2) {
        //长或宽不等直接失败
        if ( (img1.getWidth(null) != img2.getWidth(null)) || (img1.getHeight(null) != img2.getHeight(null)) ){
            return false;
        }

        int w = img1.getWidth(null);
        int h = img1.getHeight(null);

        //获取传入的Image的信息,构建BufferedImage,并绘制图形
        BufferedImage buffer1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        Graphics2D painter = buffer1.createGraphics();
        painter.drawImage(img1, 0, 0, w, h, null);
        painter.dispose();
        //获取传入的Image的信息,构建BufferedImage,并绘制图形
        BufferedImage buffer2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        Graphics2D painter2 = buffer2.createGraphics();
        painter2.drawImage(img2, 0, 0, w, h, null);
        painter2.dispose();

        //逐个像素对比，如有不同则失败
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (buffer1.getRGB(i, j) != buffer2.getRGB(i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    // 第一张图调红测试
    @Test
    public void test1Red() {
        Image authentic = imgIO.myRead(filePath + "goal/1_red_goal.bmp");
        Image fake = imgProcessor.showChanelR(testee1);
        assertTrue(cmp(authentic, fake));
    }

    // 第一张图调绿测试
    @Test
    public void test1Green() {
        Image authentic = imgIO.myRead(filePath + "goal/1_green_goal.bmp");
        Image fake = imgProcessor.showChanelG(testee1);
        assertTrue(cmp(authentic, fake));
    }

    // 第一张图调蓝测试
    @Test
    public void test1Blue() {
        Image authentic = imgIO.myRead(filePath + "goal/1_blue_goal.bmp");
        Image fake = imgProcessor.showChanelB(testee1);
        assertTrue(cmp(authentic, fake));
    }

    // 第一张图调灰测试
    @Test
    public void testGray1() {
        Image authentic = imgIO.myRead(filePath + "goal/1_gray_goal.bmp");
        Image fake = imgProcessor.showGray(testee1);
        assertTrue(cmp(authentic, fake));
    }


    // 第二张图调红测试
    @Test
    public void test2Red() {
        Image authentic = imgIO.myRead(filePath + "goal/2_red_goal.bmp");
        Image fake = imgProcessor.showChanelR(testee2);
        assertTrue(cmp(authentic, fake));
    }

    // 第二张图调绿测试
    @Test
    public void test2Green() {
        Image authentic = imgIO.myRead(filePath + "goal/2_green_goal.bmp");
        Image fake = imgProcessor.showChanelG(testee2);

        assertTrue(cmp(authentic, fake));
    }

    // 第二张图调蓝测试
    @Test
    public void test2Blue() {
        Image authentic = imgIO.myRead(filePath + "goal/2_blue_goal.bmp");
        Image fake = imgProcessor.showChanelB(testee2);
        assertTrue(cmp(authentic, fake));
    }

    // 第二张图调灰测试
    @Test
    public void test2Gray() {
        Image authentic = imgIO.myRead(filePath + "goal/2_gray_goal.bmp");
        Image fake = imgProcessor.showGray(testee2);
        assertTrue(cmp(authentic, fake));
    }
}
