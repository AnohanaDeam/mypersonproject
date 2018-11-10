package com.EMS.test;

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

/**
 * 身份证生成
 * @author JTXY
 *
 */
public class ImageTest {

    public static void main(String[] args) throws ParseException {

        String bigImg = "D:/1.jpg";
        String smallImg = "D:/kelan.png";
        String name = "江户川 柯南";
        String sex = "男";
        String nation = "大和民族";
        String year = "1997";
        String month = "10";
        String day = "01";
        String address = "日本东京米花町第2段21号";
        String id_no = "233333333333333333";
        String waterMarkContent="东京警视厅";  //水印内容
        String waterMarkContent1="2010.10.01-2020.09.30";  //水印内容
          
        String outPath = "D:/he.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, smallImg, name,sex,nation,year,month,day,address,id_no,waterMarkContent,waterMarkContent1, outPath);
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
            , String smallImgPath, String name,String sex, 
    		String nation,String year,String month,String day,String address
    		,String id_no,String waterMarkContent,String waterMarkContent1,
    		String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //小图片的路径
        ImageIcon imgIcon = new ImageIcon(smallImgPath);
        //得到Image对象。
        Image img = imgIcon.getImage();
        int sx = 1530;
        int sy = 700;
        //将小图片绘到大图片上,5,300 .表示你的小图片在大图片上的位置。
        g.drawImage(img, sx, sy, null);
        //设置颜色。
        g.setColor(Color.WHITE);

        //最后一个参数用来设置字体的大小
        if (name != null) {
            Font f = new Font("黑体", Font.BOLD, 50);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//水印图片色彩以及透明度
            g.setColor(color);
            g.setFont(f);
            int nameX = 660;
            int nameY = 755;
            int sexX = 660 ;
            int sexY = 890;
            int nationX = 1080 ;
            int nationY = 890;
            int yearX = 720;
            int yearY = 1028;
            int monthX = 960;
            int monthY = 1028;
            int dayX = 1150;
            int dayY = 1028;
            int addressX = 660;
            int addressY = 1165;
            int id_noX = 940;
            int id_noY = 1525;        
            int x = 1036;  
            int y = 2805;  
            int p = 1060;
            int q = 2950;//表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
            g.drawString(name, nameX, nameY);
            g.drawString(sex, sexX, sexY);
            g.drawString(nation, nationX, nationY);
            g.drawString(year, yearX, yearY);
            g.drawString(month, monthX, monthY);
            g.drawString(day, dayX, dayY);
            g.drawString(address, addressX, addressY);
            g.drawString(id_no, id_noX, id_noY);
            g.drawString(waterMarkContent, x, y);
            g.drawString(waterMarkContent1, p, q);//画出水印
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