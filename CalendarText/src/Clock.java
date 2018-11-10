import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.awt.geom.*;
@SuppressWarnings("serial")
public class Clock extends JPanel implements ActionListener {
   
	 protected static Ellipse2D face = new Ellipse2D.Float(3,3,94,94);
	 protected static GeneralPath tick = new GeneralPath();  //������java.awt.geom.*;
	 static{
		  tick.moveTo(100, 100);
		  tick.moveTo(49, 0);
		  tick.lineTo(51, 0);
		  tick.lineTo(51, 6);
		  tick.lineTo(49, 6);
		  tick.lineTo(49, 0);
	 }
	 protected static GeneralPath hourHand = new GeneralPath();  //������java.awt.geom.*;
	 static
	 {
		  hourHand.moveTo(50, 15);
		  hourHand.lineTo(53, 50);
		  hourHand.lineTo(50, 53);
		  hourHand.lineTo(47, 50);
		  hourHand.lineTo(50, 15);
	 }
	 
	 protected static GeneralPath minuteHand = new GeneralPath();  //������java.awt.geom.*;
	 static
	 {
		  minuteHand.moveTo(50, 2);
		  minuteHand.lineTo(53, 50);
		  minuteHand.lineTo(50, 58);
		  minuteHand.lineTo(47, 50);
		  minuteHand.lineTo(50, 2);
	 }
	 
	 protected static GeneralPath secondHand = new GeneralPath();  //������java.awt.geom.*;
	 static
	 {
		  secondHand.moveTo(49, 5);
		  secondHand.lineTo(51, 5);
		  secondHand.lineTo(51, 62);
		  secondHand.lineTo(49, 62);
		  secondHand.lineTo(49, 5);
	 }
	 
	 protected static Color faceColor = new Color(220,220,220);
	 protected static Color hourColor = Color.red.darker();
	 protected static Color minuteColor = new Color(220,0,220);
	 protected static Color secondColor = Color.blue.darker();
	 protected static Color pinColor = new Color(220,20,111);
	 
	 //�������������
	 protected static Ellipse2D pivot = new Ellipse2D.Float(47,47,6,6);
	 protected static Ellipse2D centerPin = new Ellipse2D.Float(49,49,2,2);
	 
	     //  �����������Ϊ���ĵ�����ת��
	  // AffineTransform ����ƽ��
	  // getRotateInstance(��ת����,��λ������)
	  // ����һ����λ����Χ����ת�����ת��
	 protected AffineTransform hourTransform =
			 AffineTransform.getRotateInstance(0,50,50);
	 protected AffineTransform minuteTransform =
			 AffineTransform.getRotateInstance(0,50,50);
	 protected AffineTransform secondTransform =
			 AffineTransform.getRotateInstance(0,50,50);
	 
	 protected Timer timer = new Timer(1000,this);
	 protected Calendar calender = Calendar.getInstance();
	 public Clock()
	 {
	//   ������ѡ�ߴ� Dimension(��, ��)
		 setPreferredSize(new Dimension(100,100));
	 }
	 public void addNotify()
	 {
		  super.addNotify();
		  timer.start();
	 }
	  // �����ʱ������һ��������ɾ��
	 public void removeNotify()
	 {
		 timer.stop();
		 super.removeNotify();
	 }
	    //  ��ʱ�������¼�
	 public void actionPerformed (ActionEvent event)
	 {
		 this.calender.setTime(new java.util.Date());
		 int hour = this.calender.get(Calendar.HOUR);
		 int minute = this.calender.get(Calendar.MINUTE);
		 int second = this.calender.get(Calendar.SECOND);
	        
		 hourTransform.setToRotation((((double)(hour-1.0+minute/60.0))*(Math.PI/6.0)),50,50);
		 minuteTransform.setToRotation(((double)(minute+second/60.0))*(Math.PI/30.0),50,50);
		 secondTransform.setToRotation(((double)second)*(Math.PI/30.0),50,50);
	    
		 repaint();
	 }
	 public void paint(Graphics g)
	 {
		 super.paint(g);
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		 GradientPaint pat1=new GradientPaint(0f,80f,Color.WHITE,100f,0f,Color.LIGHT_GRAY);
		 g2.setPaint(pat1);  
	  	g2.fill(face);
	  	g2.setPaint(Color.black);  //�������
	  	g2.draw(face);
	 
	  	g2.setPaint(hourColor);
	  	g2.fill(hourHand.createTransformedShape(hourTransform));
	  	g2.setPaint(minuteColor);
	  	g2.fill(minuteHand.createTransformedShape(minuteTransform));
	  	g2.setPaint(secondColor);
	  	g2.fill(secondHand.createTransformedShape(secondTransform));
	 
	  for (double p = 0.0; p < 12.0; p += 1.0) {
	            // This is probably terribly inefficient and should be
	            // done statically or in the constructor - draw the
	            // tick as a transformed shape that is rotated.
	
	   // Shape createTransformedShape(Shape pSrc)
	   // ������ָ������״ת���������״����
	            g2.fill(tick.createTransformedShape(
	    // ��ȡת������
	                AffineTransform.getRotateInstance((Math.PI / 6.0)  * p,
	                        50, 50)));
	        }
	
	
	  	g2.fill(pivot);
	  	g2.setPaint(pinColor);
	  	g2.fill(centerPin);
	 }
	 @SuppressWarnings("deprecation")
	public static void main(String[] args){
		 JFrame frame = new JFrame();
		 frame.setLocation(700,300);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().add(new Clock());
		 frame.pack();
		 frame.show();
	 }
	 
}