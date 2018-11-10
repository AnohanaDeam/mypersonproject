package com.EMS.test.zhaojia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Pledge {
	public static void main(String[] args) throws ParseException {

        String bigImg = "D:/模板/抵押合同.jpg";
        String name1 = "张三";
        String id1 = "123456789123456789";
        String phone1 = "15689563256";
        String name2 = "李四";
        String id2 = "156895234569523546";
        String phone2 = "18865952365";
        String located = "重庆市沙坪坝区汉渝路";
        String area = "100";
        String title = "DM201811251";
        String evaluate = "120";
        String borrow = "100";
        String deadline = "5年";
        String rate = "0.1";
        String scope = "违约金500万元";
        String person1 = "张三";
        String person2 = "李四";
        String date = "2018年3月17日";
        String outPath = "D:/模板/抵押合同1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, name1,id1,phone1,name2,id2,phone2,located,
            		area,title,evaluate,borrow,deadline,rate,scope,person1,person2,date,outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /***
     * 在一张大图张添加小图和文字
     * @param bigImgPath 大图的路径
     * @param smallImgPath 小图的路径
     * @param sx    小图在大图上x抽位置
     * @param sy    小图在大图上y抽位置
     * @param content   文字内容
     * @param cx    文字在大图上y抽位置
     * @param cy    文字在大图上y抽位置
     * @param outPathWithFileName 结果输出路径
     */
    public static void bigImgAddSmallImgAndText(String bigImgPath
            ,String name1,String id1, String phone1,String name2,String id2,String phone2,String located,
            String area,String title,String evaluate,String borrow,String deadline,
            String rate,String scope,String person1,String person2,String date,String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //最后一个参数用来设置字体的大小
        if (name1 != null) {
            Font f = new Font("楷体", Font.BOLD, 45);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//水印图片色彩以及透明度
            g.setColor(color);
            g.setFont(f);
            int name1X = 500;
            int name1Y = 375;
            int id1X = 985 ;
            int id1Y = 380;
            int phone1X = 920 ;
            int phone1Y = 460;
            int name2X = 555;
            int name2Y = 535;
            int id2X = 965;
            int id2Y = 540;
            int phone2X = 920;
            int phone2Y = 620;
            int locatedX = 250;
            int locatedY =850;
            int areaX = 1100;
            int areaY = 850;
            int titleX = 500;
            int titleY = 930;
            int evaluateX = 375;
            int evaluateY = 1015;
            int borrowX = 1025;
            int borrowY = 1015;
            int deadlineX = 500;
            int deadlineY = 1090;
            int rateX = 1000;
            int rateY = 1090;
            int scopeX = 450;
            int scopeY = 1170;
            int person1X = 750;
            int person1Y = 1735;
            int person2X = 750;
            int person2Y = 1825;
            int dateX = 1000;
            int dateY = 1895;
            g.drawString(name1, name1X, name1Y);
            g.drawString(id1, id1X, id1Y);
            g.drawString(phone1, phone1X, phone1Y);
            g.drawString(name2, name2X, name2Y);
            g.drawString(id2, id2X, id2Y);
            g.drawString(phone2, phone2X, phone2Y);
            g.drawString(located, locatedX, locatedY);
            g.drawString(area, areaX, areaY);
            g.drawString(title, titleX, titleY);
            g.drawString(evaluate, evaluateX, evaluateY);
            g.drawString(borrow, borrowX, borrowY);
            g.drawString(deadline, deadlineX, deadlineY);
            g.drawString(rate, rateX, rateY);
            g.drawString(scope, scopeX, scopeY);
            g.drawString(person1, person1X, person1Y);
            g.drawString(person2, person2X, person2Y);
            g.drawString(date, dateX, dateY);
            g.dispose();  
        }
        g.dispose();
        OutputStream os = new FileOutputStream(outPathWithFileName);
        //创键编码器，用于编码内存中的图象数据。
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
    }


}
