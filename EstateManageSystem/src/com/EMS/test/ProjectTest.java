package com.EMS.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
/**
 * 生成建设用地使用权证明
 * @author JTXY
 *
 */
public class ProjectTest {
	 /**
     * @param srcImgPath 源图片路径
     * @param tarImgPath 保存的图片路径
     * @param waterMarkContent 水印内容
     * @param markContentColor 水印颜色
     * @param font 水印字体
     */
    public void addWaterMark(String srcImgPath, String tarImgPath,String enterprise,String address,String number,String year,String month,String day,String year1,String month1,String day1, Color markContentColor,Font font) {

        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);//得到文件
            Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            g.setFont(font);              //设置字体

            //设置水印的坐标
            int enterpriseX = 400;
            int enterpriseY = 880;
            
            int addressX = 700;
            int addressY = 1020;
            
            int numberX = 400;
            int numberY = 1150;
         
            int yearX = 340;
            int yearY = 1280;
            
            int monthX = 560;
            int monthY = 1280;
            
            int dayX = 740;
            int dayY = 1280;
            
            int year1X = 1450;
            int year1Y = 2070;
            
            int month1X = 1670;
            int month1Y = 2070;
            
            int day1X = 1820;
            int day1Y = 2070;
           
            g.drawString(enterprise, enterpriseX, enterpriseY);
            g.drawString(address, addressX, addressY);
            g.drawString(number, numberX, numberY);
            g.drawString(year, yearX, yearY);
            g.drawString(month, monthX, monthY);
            g.drawString(day, dayX, dayY);
            g.drawString(year1, year1X, year1Y);
            g.drawString(month1, month1X, month1Y);
            g.drawString(day1, day1X, day1Y);
           //画出水印
           g.dispose();  
            // 输出图片  
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);  
            ImageIO.write(bufImg, "jpg", outImgStream);
            System.out.println("添加水印完成");  
            outImgStream.flush();  
            outImgStream.close();  

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public int getWatermarkLengthEnterprise(String enterprise, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(enterprise.toCharArray(), 0, enterprise.length());  
    }
    public int getWatermarkLengthAddress(String address, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(address.toCharArray(), 0, address.length());  
    }
    
    public int getWatermarkLengthNumber(String number, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(number.toCharArray(), 0, number.length());  
    }
 
    public int getWatermarkLengthYear(String year, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(year.toCharArray(), 0, year.length());  
    }
    public int getWatermarkLengthMonth(String month, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(month.toCharArray(), 0, month.length());  
    }
    public int getWatermarkLengthDay(String day, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(day.toCharArray(), 0, day.length());  
    }
   
    public int getWatermarkLengthYear1(String year1, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(year1.toCharArray(), 0, year1.length());  
    }
    public int getWatermarkLengthMonth1(String month1, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(month1.toCharArray(), 0, month1.length());  
    }
    public int getWatermarkLengthDay1(String day1, Graphics2D g) {  
        return g.getFontMetrics(g.getFont()).charsWidth(day1.toCharArray(), 0, day1.length());  
    }
   
    public static void main(String[] args) {
        Font font = new Font("黑体", Font.BOLD, 50);                     //水印字体
        String srcImgPath="D:/pro.jpg"; //源图片地址
        String tarImgPath="D:/pro1.jpg"; //待存储的地址
        String enterprise = "碧桂园";
        String address = "漳州街二街86号-13-5";
        String number = "123465789";
        String year = "1997";
        String month = "10";
        String day = "01";
        String year1 = "1997";
        String month1 = "10";
        String day1 = "01"; //水印内容
        Color color=new Color(0,0,0,200); //水印图片色彩以及透明度
        new ProjectTest().addWaterMark(srcImgPath,tarImgPath,enterprise,address,number,year,month,day,year1,month1,day1,color,font);

    }
}
