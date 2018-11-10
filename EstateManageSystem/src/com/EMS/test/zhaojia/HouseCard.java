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

        String bigImg = "D:/ģ��/����֤.jpg";
        String house = "������";
        String character = "��Ԫ��";
        String mark = "E201803";
        String obligee = "����";
        String owned = "��������";
        String located = "��������Ԫ����Ԫ����112��";
        String date = "2018��3��20��";
        String nature = "";
        String use = "ס��";
        String floors = "5";
        String construction = "���";
        String inner = "140";
        String outer = "148";
        String other = "";
        String landno = "E2018";
        String method = "����";
        String start = "2018.3.20";
        String stop = "2038.3.19";
        String outPath = "D:/ģ��/����֤1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg,house,character,mark,obligee,owned,located,date,nature,use,floors,construction,
            		inner,outer,other,landno,method,start,stop,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath,String house,String character,String mark,String obligee,
    		String owned,String located,String date,String nature,String use,String floors,String construction,String inner,
            String outer,String other,String landno,String method,String start,String stop,String outPathWithFileName) throws IOException {
        //��ͼƬ��·��
        InputStream is = new FileInputStream(bigImgPath);
        //ͨ��JPEGͼ��������JPEG������������
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //���뵱ǰJPEG������������BufferedImage����
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //�õ����ʶ���
        Graphics g = buffImg.getGraphics();

        //���һ������������������Ĵ�С
        if (house != null) {
            Font f = new Font("����", Font.BOLD, 13);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//ˮӡͼƬɫ���Լ�͸����
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
        //���������������ڱ����ڴ��е�ͼ�����ݡ�
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
    }


}
