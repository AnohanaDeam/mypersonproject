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

        String bigImg = "D:/ģ��/��������ʹ��֤.jpg";
        String c1 = "������";
        String c2 = "2018";
        String c3 = "201803";
        String userperson = "EMS�����������޹�˾";
        String location = "�����г������������268��";
        String landno = "WY9-99-14";
        String viewno = "125-150-3";
        String use = "����סլ�õ�";
        String price = "���صȼ�Ϊ�弶";
        String type = "����";
        String stop = "2098��3��20��";
        String area = "45311�O";
        String privatearea = "45311�O";
        String subarea = "";
        String outPath = "D:/ģ��/��������ʹ��֤1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg,c1,c2,c3,userperson,location,landno,viewno,use,price,type,stop,area,privatearea,subarea,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath, String c1,String c2,String c3,String userperson,String location,String landno,
    		String viewno,String use,String price,String type,String stop,String area,String privatearea,String subarea,String outPathWithFileName) throws IOException {
        //��ͼƬ��·��
        InputStream is = new FileInputStream(bigImgPath);
        //ͨ��JPEGͼ��������JPEG������������
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //���뵱ǰJPEG������������BufferedImage����
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //�õ����ʶ���
        Graphics g = buffImg.getGraphics();

        //���һ������������������Ĵ�С
        if (c1 != null) {
            Font f = new Font("����", Font.BOLD, 11);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//ˮӡͼƬɫ���Լ�͸����
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
        //���������������ڱ����ڴ��е�ͼ�����ݡ�
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
    }


}
