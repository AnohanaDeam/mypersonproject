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

public class RegiaterForm {
	public static void main(String[] args) throws ParseException {

        String bigImg = System.getProperty("user.dir")+"/src/com/EMS/test/zhaojia/登记申请表.jpg";
        String number = "E2018";
        String date = "2018.03.20";
        String recipients = "李四";
        String right = "√";
        String type = "√";
        String register = "√";
        String obligee = "中国银行柳州支行";
        String kind1 = "营业执照";
        String id1 = "1256986555913 1-1-1";
        String address1 = "城中区学院路268号3-1";
        String postcode1 = "540000";
        String principal1 = "吴无";
        String phone1 = "13900056789";
        String agent1 = "张三";
        String phone2 = "13956985325";
        String agency1 = "/";
        String obligor = "李四";
        String kind2 = "身份证";
        String id2 = "510213197409114571";
        String address2 = "城中区学院路108号7-2";
        String postcode2 = "540000";
        String principal2 = "李四";
        String phone3 = "15315689523";
        String agent2 = "/";
        String phone4 = "/";
        String principal = "/";
        String located = "城中区学院路108号7-2";
        String element = "/";
        String etype = "房屋";
        String area = "100平方米";
        String use = "成套住宅";
        String bnumber = "DM2018";
        String stype = "/";
        String ctype = "/";
        String category = "/";
      
        String outPath =   System.getProperty("user.dir")+"/src/com/EMS/test/zhaojia/登记申请表1.jpg";
        try {
            bigImgAddSmallImgAndText(bigImg, number,date, recipients,right,type,register,obligee,kind1,id1,address1 ,postcode1,principal1,phone1,agent1,
            		phone2,agency1,obligor,kind2,id2,address2,postcode2,principal2,phone3,agent2,phone4,principal,located,element,
            		etype,area,use ,bnumber,stype,ctype,category,outPath);
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
    public static void bigImgAddSmallImgAndText(String bigImgPath,String number,String date,String recipients,String right,
    		String type,String register,String obligee,String kind1,String id1,String address1,String postcode1,String principal1,String phone1,
    		String agent1,String phone2,String agency1,String obligor,String kind2,String id2,String address2,String postcode2,
    		String principal2,String phone3 ,String agent2,String phone4,String principal,String located,String element,String etype,
    		String area,String use ,String bnumber,String stype,String ctype,String category,String outPathWithFileName) throws IOException {
        //主图片的路径
        InputStream is = new FileInputStream(bigImgPath);
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        //得到画笔对象
        Graphics g = buffImg.getGraphics();

        //最后一个参数用来设置字体的大小
        if (number != null) {
            Font f = new Font("楷体", Font.BOLD, 18);
            Color color=new Color(0,0,0,200);//new Color(0, 0, 255);//水印图片色彩以及透明度
            g.setColor(color);
            g.setFont(f);
            int numberX = 180;
            int numberY = 124;
            int dateX = 177;
            int dateY = 145;
            int recipientsX = 380;
            int recipientsY = 135;
            int rightX = 505;
            int rightY = 133;
            int typeX = 437 ;
            int typeY = 220;
            int registerX = 134 ;
            int registerY = 263;
            int obligeeX = 380 ;
            int obligeeY = 350;
            int kind1X = 310;
            int kind1Y = 385;
            int id1X = 485;
            int id1Y = 385;
            int address1X = 285;
            int address1Y = 420;
            int postcode1X = 570;
            int postcode1Y =420;
            int principal1X = 320;
            int principal1Y = 455;
            int phone1X = 510;
            int phone1Y = 455;
            int agent1X = 320;
            int agent1Y = 490;
            int phone2X = 510 ;
            int phone2Y = 490;
            int agency1X = 490 ;
            int agency1Y = 520;
            int obligorX = 470;
            int obligorY = 590;
            int kind2X = 310;
            int kind2Y = 620;
            int id2X = 490;
            int id2Y = 620;
            int address2X = 285;
            int address2Y =659;
            int postcode2X = 570;
            int postcode2Y = 659;
            int principal2X = 325;
            int principal2Y = 690;
            int phone3X = 510;
            int phone3Y = 693;
    		int agent2X = 340;
            int agent2Y = 720;
            int phone4X = 580;
            int phone4Y = 720;
            int principalX = 490;
            int principalY =755;
            int locatedX = 380;
            int locatedY = 793;
            int elementX = 340;
            int elementY = 830;
            int etypeX = 580;
            int etypeY = 827;
            int areaX = 300;
            int areaY =863;
            int useX = 580;
            int useY = 863;
            int bnumberX = 310;
            int bnumberY = 896;
            int stypeX = 580;
            int stypeY = 896;
            int ctypeX = 340;
            int ctypeY = 932;
            int categoryX = 580;
            int categoryY = 932;
            
            g.drawString(number, numberX,numberY);
            g.drawString(date, dateX, dateY);
            g.drawString(recipients, recipientsX, recipientsY);
            g.drawString(right, rightX, rightY);
            g.drawString(type, typeX, typeY);
            g.drawString(register, registerX, registerY);
            g.drawString(obligee, obligeeX, obligeeY);  
            g.drawString(kind1, kind1X, kind1Y);
            g.drawString(id1, id1X, id1Y);
            g.drawString(address1, address1X, address1Y);
            g.drawString(postcode1, postcode1X, postcode1Y);
            g.drawString(principal1, principal1X,principal1Y);
            g.drawString(phone1, phone1X,phone1Y);
            g.drawString(agent1, agent1X, agent1Y);
            g.drawString(phone2, phone2X, phone2Y);
            g.drawString(agency1, agency1X,agency1Y);
            g.drawString(obligor, obligorX, obligorY);
            g.drawString(kind2, kind2X, kind2Y);
            g.drawString(id2, id2X, id2Y);
            g.drawString(address2, address2X, address2Y);
            g.drawString(postcode2, postcode2X, postcode2Y);
            g.drawString(principal2, principal2X, principal2Y);
            g.drawString(phone3, phone3X,phone3Y);
            g.drawString(agent2, agent2X, agent2Y);
            g.drawString(phone4, phone4X, phone4Y);
            g.drawString(principal, principalX, principalY);
            g.drawString(located, locatedX,locatedY);
            g.drawString(element, elementX, elementY);
            g.drawString(etype, etypeX, etypeY);  
            g.drawString(area, areaX, areaY);
            g.drawString(use, useX, useY);
            g.drawString(bnumber, bnumberX, bnumberY);
            g.drawString(stype, stypeX,stypeY);
            g.drawString(ctype, ctypeX, ctypeY);
            g.drawString(category, categoryX, categoryY);
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
