package com.EMS.test.zhaojia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;


public class House {

    public static void main(String[] args) throws ParseException {

        String bigImg = "D:/模板/房屋竣工证明.jpg";
        String build = "重庆市";
        String word = "洋房";
        String mark = "E319";
        String name = "张三";
        String address = "重庆市沙坪坝区汉渝路";
        String project = "新建私人住房";
        String construction = "钢筋混凝土";
        String layer = "5";
        String area = "100平方米";
        String housing = "EMS";
        String year = "2018";
        String month = "3";
        String day = "19";
        String outPath = "D:/模板/房屋竣工证明1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, build,word, mark,name,address,project,construction,layer,area ,housing,year,month,day,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath,String build,
    		String word,String mark,String name,String address, String project,
    		String construction,String layer,String area,String housing,
            String year,String month,String day,String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //最后一个参数用来设置字体的大小
        if (name != null) {
            Font f = new Font("楷体", Font.BOLD, 18);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//水印图片色彩以及透明度
            g.setColor(color);
            g.setFont(f);
            int buildX = 369;
            int buildY = 100;
            int wordX = 475;
            int wordY = 100;
            int markX = 524;
            int markY = 100;
            int nameX = 190;
            int nameY = 182;
            int addressX = 330 ;
            int addressY = 182;
            int projectX = 150 ;
            int projectY = 223;
            int constructionX = 325;
            int constructionY = 223;
            int layerX = 480;
            int layerY = 225;
            int areaX = 150;
            int areaY = 270;
            int housingX = 400;
            int housingY =395;
            int yearX = 410;
            int yearY = 435;
            int monthX = 495;
            int monthY = 435;
            int dayX = 535;
            int dayY = 435;
            g.drawString(build, buildX,buildY);
            g.drawString(word, wordX, wordY);
            g.drawString(mark, markX, markY);
            g.drawString(name, nameX, nameY);
            g.drawString(address, addressX, addressY);
            g.drawString(project, projectX, projectY);
            g.drawString(construction, constructionX, constructionY);
            g.drawString(layer, layerX, layerY);
            g.drawString(area, areaX, areaY);
            g.drawString(housing, housingX, housingY);
            g.drawString(year, yearX,yearY);
            g.drawString(month, monthX, monthY);
            g.drawString(day, dayX, dayY);
           
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