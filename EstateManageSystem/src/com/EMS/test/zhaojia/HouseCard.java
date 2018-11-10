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

public class HouseCard {
	public static void main(String[] args) throws ParseException {

        String bigImg = "D:/模板/房产证.jpg";
        String house = "株洲市";
        String character = "天元区";
        String mark = "E201803";
        String obligee = "张三";
        String owned = "单独所有";
        String located = "株洲市天元区天元建材112号";
        String date = "2018年3月20日";
        String nature = "";
        String use = "住房";
        String floors = "5";
        String construction = "混合";
        String inner = "140";
        String outer = "148";
        String other = "";
        String landno = "E2018";
        String method = "出让";
        String start = "2018.3.20";
        String stop = "2038.3.19";
        String outPath = "D:/模板/房产证1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg,house,character,mark,obligee,owned,located,date,nature,use,floors,construction,
            		inner,outer,other,landno,method,start,stop,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath,String house,String character,String mark,String obligee,
    		String owned,String located,String date,String nature,String use,String floors,String construction,String inner,
            String outer,String other,String landno,String method,String start,String stop,String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //最后一个参数用来设置字体的大小
        if (house != null) {
            Font f = new Font("楷体", Font.BOLD, 13);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//水印图片色彩以及透明度
            g.setColor(color);
            g.setFont(f);
           
            int houseX = 60;
            int houseY = 50;
            int characterX = 155;
            int characterY = 50;
            int markX = 220;
            int markY = 50;
            int obligeeX = 170;
            int obligeeY = 80;
            int ownedX = 160 ;
            int ownedY = 105;
            int locatedX = 110;
            int locatedY = 140;
            int dateX = 140 ;
            int dateY = 177;
            int natureX = 160;
            int natureY = 200;
            int useX = 160;
            int useY = 225;
            int floorsX = 75;
            int floorsY = 275;
            int constructionX = 110;
            int constructionY =275;
            int innerX = 160;
            int innerY = 275;
            int outerX = 220;
            int outerY = 275;
            int otherX = 250;
            int otherY = 275;
            int landnoX = 60;
            int landnoY = 385;
            int methodX = 140 ;
            int methodY = 385;
            int startX = 200 ;
            int startY = 380;
            int stopX = 200;
            int stopY = 395;
            /* ,house,character,mark,obligee,owned,located,date,nature,use,floors,construction,
    		inner,outer,other,landno,method,start,stop*/
            g.drawString(house, houseX,houseY);
            g.drawString(character, characterX, characterY);
            g.drawString(mark, markX, markY);
            g.drawString(obligee, obligeeX, obligeeY);
            g.drawString(owned, ownedX,ownedY);
            g.drawString(located, locatedX, locatedY);
            g.drawString(date, dateX, dateY);  
            g.drawString(nature, natureX, natureY);
            g.drawString(use, useX, useY);
            g.drawString(floors, floorsX, floorsY);
            g.drawString(construction, constructionX, constructionY);
            g.drawString(inner, innerX,innerY);
            g.drawString(outer, outerX,outerY);
            g.drawString(other, otherX, otherY);
            g.drawString(landno, landnoX, landnoY);
            g.drawString(method, methodX,methodY);
            g.drawString(start, startX, startY);
            g.drawString(stop, stopX, stopY);
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
