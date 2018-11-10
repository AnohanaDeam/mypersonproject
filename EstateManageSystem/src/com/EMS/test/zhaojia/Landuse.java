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

public class Landuse {
	public static void main(String[] args) throws ParseException {

        String bigImg = "D:/模板/国有土地使用证.jpg";
        String c1 = "柳州市";
        String c2 = "2018";
        String c3 = "201803";
        String userperson = "EMS房产开发有限公司";
        String location = "柳州市城中区东环大道268号";
        String landno = "WY9-99-14";
        String viewno = "125-150-3";
        String use = "城镇住宅用地";
        String price = "土地等级为五级";
        String type = "出让";
        String stop = "2098年3月20日";
        String area = "45311㎡";
        String privatearea = "45311㎡";
        String subarea = "";
        String outPath = "D:/模板/国有土地使用证1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg,c1,c2,c3,userperson,location,landno,viewno,use,price,type,stop,area,privatearea,subarea,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath, String c1,String c2,String c3,String userperson,String location,String landno,
    		String viewno,String use,String price,String type,String stop,String area,String privatearea,String subarea,String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //最后一个参数用来设置字体的大小
        if (c1 != null) {
            Font f = new Font("楷体", Font.BOLD, 11);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//水印图片色彩以及透明度
            g.setColor(color);
            g.setFont(f);
            
            int c1X = 60;
            int c1Y = 60;
            int c2X = 132;
            int c2Y = 60;
            int c3X = 182;
            int c3Y = 60;
            int userpersonX = 170;
            int userpersonY = 83;
            int locationX = 155 ;
            int locationY = 110;
            int landnoX = 133;
            int landnoY = 142;
            int viewnoX = 280;
            int viewnoY = 142;
            int useX = 131 ;
            int useY = 172;
            int priceX = 278 ;
            int priceY = 172;
            int typeX = 155;
            int typeY = 200;
            int stopX = 277;
            int stopY = 200;
            int areaX = 143;
            int areaY = 242;
            int privateareaX = 290;
            int privateareaY = 229;
            int subareaX = 290 ;
            int subareaY = 260;
            
            g.drawString(c1, c1X,c1Y);
            g.drawString(c2, c2X, c2Y);
            g.drawString(c3, c3X, c3Y);
            g.drawString(userperson, userpersonX, userpersonY);
            g.drawString(location, locationX,locationY);
            g.drawString(landno, landnoX, landnoY);
            g.drawString(viewno, viewnoX, viewnoY);
            g.drawString(use, useX, useY);  
            g.drawString(price, priceX, priceY); 
            g.drawString(type, typeX, typeY);
            g.drawString(stop, stopX, stopY);
            g.drawString(area, areaX,areaY);
            g.drawString(privatearea, privateareaX, privateareaY);
            g.drawString(subarea, subareaX, subareaY);  
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
