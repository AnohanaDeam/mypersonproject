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
 * ���ɽ����õ�ʹ��Ȩ֤��
 * @author JTXY
 *
 */
public class ProjectTest {
	 /**
     * @param srcImgPath ԴͼƬ·��
     * @param tarImgPath �����ͼƬ·��
     * @param waterMarkContent ˮӡ����
     * @param markContentColor ˮӡ��ɫ
     * @param font ˮӡ����
     */
    public void addWaterMark(String srcImgPath, String tarImgPath,String enterprise,String address,String number,String year,String month,String day,String year1,String month1,String day1, Color markContentColor,Font font) {

        try {
            // ��ȡԭͼƬ��Ϣ
            File srcImgFile = new File(srcImgPath);//�õ��ļ�
            Image srcImg = ImageIO.read(srcImgFile);//�ļ�ת��ΪͼƬ
            int srcImgWidth = srcImg.getWidth(null);//��ȡͼƬ�Ŀ�
            int srcImgHeight = srcImg.getHeight(null);//��ȡͼƬ�ĸ�
            // ��ˮӡ
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //����ͼƬ�ı�������ˮӡ��ɫ
            g.setFont(font);              //��������

            //����ˮӡ������
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
           //����ˮӡ
           g.dispose();  
            // ���ͼƬ  
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);  
            ImageIO.write(bufImg, "jpg", outImgStream);
            System.out.println("���ˮӡ���");  
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
        Font font = new Font("����", Font.BOLD, 50);                     //ˮӡ����
        String srcImgPath="D:/pro.jpg"; //ԴͼƬ��ַ
        String tarImgPath="D:/pro1.jpg"; //���洢�ĵ�ַ
        String enterprise = "�̹�԰";
        String address = "���ݽֶ���86��-13-5";
        String number = "123465789";
        String year = "1997";
        String month = "10";
        String day = "01";
        String year1 = "1997";
        String month1 = "10";
        String day1 = "01"; //ˮӡ����
        Color color=new Color(0,0,0,200); //ˮӡͼƬɫ���Լ�͸����
        new ProjectTest().addWaterMark(srcImgPath,tarImgPath,enterprise,address,number,year,month,day,year1,month1,day1,color,font);

    }
}
