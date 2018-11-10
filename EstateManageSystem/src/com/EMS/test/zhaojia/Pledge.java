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

public class Pledge {
	public static void main(String[] args) throws ParseException {

        String bigImg = "D:/ģ��/��Ѻ��ͬ.jpg";
        String name1 = "����";
        String id1 = "123456789123456789";
        String phone1 = "15689563256";
        String name2 = "����";
        String id2 = "156895234569523546";
        String phone2 = "18865952365";
        String located = "������ɳƺ��������·";
        String area = "100";
        String title = "DM201811251";
        String evaluate = "120";
        String borrow = "100";
        String deadline = "5��";
        String rate = "0.1";
        String scope = "ΥԼ��500��Ԫ";
        String person1 = "����";
        String person2 = "����";
        String date = "2018��3��17��";
        String outPath = "D:/ģ��/��Ѻ��ͬ1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, name1,id1,phone1,name2,id2,phone2,located,
            		area,title,evaluate,borrow,deadline,rate,scope,person1,person2,date,outPath);
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
            ,String name1,String id1, String phone1,String name2,String id2,String phone2,String located,
            String area,String title,String evaluate,String borrow,String deadline,
            String rate,String scope,String person1,String person2,String date,String outPathWithFileName) throws IOException {
        //��ͼƬ��·��
        InputStream is = new FileInputStream(bigImgPath);
        //ͨ��JPEGͼ��������JPEG������������
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //���뵱ǰJPEG������������BufferedImage����
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //�õ����ʶ���
        Graphics g = buffImg.getGraphics();

        //���һ������������������Ĵ�С
        if (name1 != null) {
            Font f = new Font("����", Font.BOLD, 45);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//ˮӡͼƬɫ���Լ�͸����
            g.setColor(color);
            g.setFont(f);
            int name1X = 500;
            int name1Y = 375;
            int id1X = 985 ;
            int id1Y = 380;
            int phone1X = 920 ;
            int phone1Y = 460;
            int name2X = 555;
            int name2Y = 535;
            int id2X = 965;
            int id2Y = 540;
            int phone2X = 920;
            int phone2Y = 620;
            int locatedX = 250;
            int locatedY =850;
            int areaX = 1100;
            int areaY = 850;
            int titleX = 500;
            int titleY = 930;
            int evaluateX = 375;
            int evaluateY = 1015;
            int borrowX = 1025;
            int borrowY = 1015;
            int deadlineX = 500;
            int deadlineY = 1090;
            int rateX = 1000;
            int rateY = 1090;
            int scopeX = 450;
            int scopeY = 1170;
            int person1X = 750;
            int person1Y = 1735;
            int person2X = 750;
            int person2Y = 1825;
            int dateX = 1000;
            int dateY = 1895;
            g.drawString(name1, name1X, name1Y);
            g.drawString(id1, id1X, id1Y);
            g.drawString(phone1, phone1X, phone1Y);
            g.drawString(name2, name2X, name2Y);
            g.drawString(id2, id2X, id2Y);
            g.drawString(phone2, phone2X, phone2Y);
            g.drawString(located, locatedX, locatedY);
            g.drawString(area, areaX, areaY);
            g.drawString(title, titleX, titleY);
            g.drawString(evaluate, evaluateX, evaluateY);
            g.drawString(borrow, borrowX, borrowY);
            g.drawString(deadline, deadlineX, deadlineY);
            g.drawString(rate, rateX, rateY);
            g.drawString(scope, scopeX, scopeY);
            g.drawString(person1, person1X, person1Y);
            g.drawString(person2, person2X, person2Y);
            g.drawString(date, dateX, dateY);
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
