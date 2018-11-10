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
 * ���֤����
 * @author JTXY
 *
 */
public class ImageTest {

    public static void main(String[] args) throws ParseException {

        String bigImg = "D:/1.jpg";
        String smallImg = "D:/kelan.png";
        String name = "������ ����";
        String sex = "��";
        String nation = "�������";
        String year = "1997";
        String month = "10";
        String day = "01";
        String address = "�ձ������׻��2��21��";
        String id_no = "233333333333333333";
        String waterMarkContent="����������";  //ˮӡ����
        String waterMarkContent1="2010.10.01-2020.09.30";  //ˮӡ����
          
        String outPath = "D:/he.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, smallImg, name,sex,nation,year,month,day,address,id_no,waterMarkContent,waterMarkContent1, outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /***
     * ��һ�Ŵ�ͼ�����Сͼ������
     * @param bigImgPath ��ͼ��·��
     * @param smallImgPath Сͼ��·��
     * @param sx    Сͼ�ڴ�ͼ��x��λ��
     * @param sy    Сͼ�ڴ�ͼ��y��λ��
     * @param content   ��������
     * @param cx    �����ڴ�ͼ��y��λ��
     * @param cy    �����ڴ�ͼ��y��λ��
     * @param outPathWithFileName ������·��
     */
    public static void bigImgAddSmallImgAndText(String bigImgPath
            , String smallImgPath, String name,String sex, 
    		String nation,String year,String month,String day,String address
    		,String id_no,String waterMarkContent,String waterMarkContent1,
    		String outPathWithFileName) throws IOException {
        //��ͼƬ��·��
        InputStream is = new FileInputStream(bigImgPath);
        //ͨ��JPEGͼ��������JPEG������������
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //���뵱ǰJPEG������������BufferedImage����
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //�õ����ʶ���
        Graphics g = buffImg.getGraphics();

        //СͼƬ��·��
        ImageIcon imgIcon = new ImageIcon(smallImgPath);
        //�õ�Image����
        Image img = imgIcon.getImage();
        int sx = 1530;
        int sy = 700;
        //��СͼƬ�浽��ͼƬ��,5,300 .��ʾ���СͼƬ�ڴ�ͼƬ�ϵ�λ�á�
        g.drawImage(img, sx, sy, null);
        //������ɫ��
        g.setColor(Color.WHITE);

        //���һ������������������Ĵ�С
        if (name != null) {
            Font f = new Font("����", Font.BOLD, 50);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//ˮӡͼƬɫ���Լ�͸����
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
            int q = 2950;//��ʾ���������ͼƬ�ϵ�λ��(x,y) .��һ���������õ����ݡ�
            g.drawString(name, nameX, nameY);
            g.drawString(sex, sexX, sexY);
            g.drawString(nation, nationX, nationY);
            g.drawString(year, yearX, yearY);
            g.drawString(month, monthX, monthY);
            g.drawString(day, dayX, dayY);
            g.drawString(address, addressX, addressY);
            g.drawString(id_no, id_noX, id_noY);
            g.drawString(waterMarkContent, x, y);
            g.drawString(waterMarkContent1, p, q);//����ˮӡ
            g.dispose();  
        }
        g.dispose();
        OutputStream os = new FileOutputStream(outPathWithFileName);
        //���������������ڱ����ڴ��е�ͼ�����ݡ�
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
    }

}