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

        String bigImg = "D:/ģ��/�滮���֤.jpg";
        String office = "������ס���ͳ��罨���";
        String date = "2018��3��20��";
        String unit = "EMS���ز��������޹�˾";
        String project = "������������ۡ";
        String location = "�����Ƽ���ѧ�ϲ�";
        String scale = "9000�O";
        String accessory = "EMS������������Ʒ����˶�֪ͨ�顷";
        String outPath = "D:/ģ��/�滮���֤1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg,office,date,unit,project,location,scale,accessory,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath, String office,String date,String unit,
    String project,String location,String scale,String accessory,String outPathWithFileName) throws IOException {
        //��ͼƬ��·��
        InputStream is = new FileInputStream(bigImgPath);
        //ͨ��JPEGͼ��������JPEG������������
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //���뵱ǰJPEG������������BufferedImage����
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //�õ����ʶ���
        Graphics g = buffImg.getGraphics();

        //���һ������������������Ĵ�С
        if (office != null) {
            Font f = new Font("����", Font.BOLD, 12);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//ˮӡͼƬɫ���Լ�͸����
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
        //���������������ڱ����ڴ��е�ͼ�����ݡ�
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
    }

}
