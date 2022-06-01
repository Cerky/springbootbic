package com.example.springbootbic.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName: RandomValidateCodeUtil
 * @Description: 图形验证码
 * @Author: CZJ
 * @Date: 2022/2/18
 */
public class RandomValidateCodeUtil {

    private static final String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//随机产生数字与字母组合的字符串

    private static final int WIDTH = 132;// 图片宽
    private static final int HEIGHT = 40;// 图片高
    private static final int LINE_SIZE = 50;// 干扰线数量
    private static final int STRING_NUM = 4;// 随机产生字符数量

    /**
     * 获得字体
     */
    private static Font getFont() {
        return new Font("Fixedsys", Font.BOLD, 24);
    }

    /**
     * 获得颜色
     */
    private static Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        int r = fc + localRandom.nextInt(bc - fc - 16);
        int g = fc + localRandom.nextInt(bc - fc - 14);
        int b = fc + localRandom.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成随机图片
     */
    public static String getRandomCode(HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession();

        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);

        // 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, WIDTH, HEIGHT);//图片大小
        g.setFont(new Font("Times New Roman", Font.PLAIN, 24));//字体大小
        g.setColor(getRandColor(110, 133));//字体颜色

        // 绘制干扰线
        for (int i = 0; i <= LINE_SIZE; i++) {
            drawLine(g);
        }

        // 绘制随机字符
        String randomString = "";

        for (int i = 1; i <= STRING_NUM; i++) {
            randomString = drawString(g, randomString, i);
        }

        //将生成的随机字符串保存到session中
//        session.removeAttribute(RANDOMCODEKEY);
//        session.setAttribute(RANDOMCODEKEY, randomString);
        g.dispose();
        ImageIO.write(image, "JPEG", response.getOutputStream());
        return randomString;
    }

    /**
     * 绘制字符串
     */
    private static String drawString(Graphics g, String randomString, int i) {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        g.setFont(getFont());
        g.setColor(new Color(localRandom.nextInt(101), localRandom.nextInt(111), localRandom.nextInt(121)));
        String rand = getRandomString(localRandom.nextInt(randString.length()));
        randomString += rand;
        g.translate(localRandom.nextInt(3), localRandom.nextInt(3));
        g.drawString(rand, 22 * i, 26);
        return randomString;
    }

    /**
     * 绘制干扰线
     */
    private static void drawLine(Graphics g) {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        int x = localRandom.nextInt(WIDTH);
        int y = localRandom.nextInt(HEIGHT);
        int xl = localRandom.nextInt(18);
        int yl = localRandom.nextInt(22);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 获取随机的字符
     */
    public static String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }

}
