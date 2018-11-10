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

public class Licence {
	public static void main(String[] args) throws ParseException {

        String bigImg = "D:/模板/规划许可证.jpg";
        String office = "柳州市住房和城乡建设局";
        String date = "2018年3月20日";
        String unit = "EMS房地产开发有限公司";
        String project = "柳州市南亚名邸";
        String location = "广西科技大学南侧";
        String scale = "9000㎡";
        String accessory = "EMS《建筑工程设计方案核定通知书》";
        String outPath = "D:/模板/规划许可证1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg,office,date,unit,project,location,scale,accessory,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath, String office,String date,String unit,
    String project,String location,String scale,String accessory,String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //最后一个参数用来设置字体的大小
        if (office != null) {
            Font f = new Font("楷体", Font.BOLD, 12);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//水印图片色彩以及透明度
            g.setColor(color);
            g.setFont(f);
            
            int officeX = 150;
            int officeY = 330;
            int dateX = 180;
            int dateY = 358;
            int unitX = 405;
            int unitY = 65;
            int projectX = 425;
            int projectY = 87;
            int locationX = 415 ;
            int locationY = 110;
            int scaleX = 450;
            int scaleY = 132;
            int accessoryX = 340 ;
            int accessoryY = 185;
     
            g.drawString(office, officeX,officeY);
            g.drawString(date, dateX, dateY);
            g.drawString(unit, unitX, unitY);
            g.drawString(project, projectX, projectY);
            g.drawString(location, locationX,locationY);
            g.drawString(scale, scaleX, scaleY);
            g.drawString(accessory, accessoryX, accessoryY);  
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
