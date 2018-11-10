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

        String bigImg = "D:/ģ��/���ݿ���֤��.jpg";
        String build = "������";
        String word = "��";
        String mark = "E319";
        String name = "����";
        String address = "������ɳƺ��������·";
        String project = "�½�˽��ס��";
        String construction = "�ֽ������";
        String layer = "5";
        String area = "100ƽ����";
        String housing = "EMS";
        String year = "2018";
        String month = "3";
        String day = "19";
        String outPath = "D:/ģ��/���ݿ���֤��1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, build,word, mark,name,address,project,construction,layer,area ,housing,year,month,day,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath,String build,
    		String word,String mark,String name,String address, String project,
    		String construction,String layer,String area,String housing,
            String year,String month,String day,String outPathWithFileName) throws IOException {
        //��ͼƬ��·��
        InputStream is = new FileInputStream(bigImgPath);
        //ͨ��JPEGͼ��������JPEG������������
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //���뵱ǰJPEG������������BufferedImage����
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //�õ����ʶ���
        Graphics g = buffImg.getGraphics();

        //���һ������������������Ĵ�С
        if (name != null) {
            Font f = new Font("����", Font.BOLD, 18);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//ˮӡͼƬɫ���Լ�͸����
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
        //���������������ڱ����ڴ��е�ͼ�����ݡ�
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
    }

}