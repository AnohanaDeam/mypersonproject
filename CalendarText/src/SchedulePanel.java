import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@SuppressWarnings("serial")
public class SchedulePanel extends JPanel implements MouseListener {

	/**
	 * Create the panel.
	 */
	NotePad notePad;
	Hashtable<String, String> hashtable;
	File file;
	JLabel data[]=new JLabel[3];
	JLabel date_1;
	CalendarBean calendarBean;
	Calendar nowday = Calendar.getInstance();
	int year,month,day;
	MainFrame mainFrame;
	boolean flag=true;
	
	
	
	public SchedulePanel(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		calendarBean =new CalendarBean();
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		date_1 = new JLabel("");
		date_1.setForeground(Color.WHITE);
		date_1.setOpaque(false);
		date_1.setFont(new Font("΢���ź�", Font.PLAIN, 27));
		
		add(date_1,BorderLayout.WEST);
		JLabel date_2 = new JLabel("+");
		date_2.setBackground(new Color(204, 204, 204));
		date_2.setOpaque(false);
		date_2.setForeground(Color.WHITE);
		date_2.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent arg0) {
				//date_2.setOpaque(true);
				date_2.setForeground(Color.LIGHT_GRAY);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		date_2.setForeground(Color.WHITE);
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		NotePad frame = new NotePad();//����һ���µ�JFrame����Ϊ�´��ڡ�
                frame.setBounds(// ���´�����Swing7����ʾ����50���ء�
                        new Rectangle(
                                (int) mainFrame.getBounds().getX() + 475,
                                (int) mainFrame.getBounds().getY() + 0, 
                                1280, 
                                (int) mainFrame.getBounds().getHeight()
                        )
                    );
                
                System.out.println(year+month+day);
                frame.setDate(year,month,day);
                frame.setVisible(true);
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		date_2.setForeground(Color.GRAY);
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		date_2.setForeground(Color.WHITE);
        	}
		});
		date_2.setFont(new Font("΢���ź�", Font.PLAIN, 45));
		add(date_2,BorderLayout.EAST);
		
		JPanel schedule_1=new JPanel();
		schedule_1.setBackground(Color.LIGHT_GRAY);
		schedule_1.setLayout(new GridLayout(4,0));
		schedule_1.setOpaque(false);
		
		for(int i=0;i<data.length;i++){
			data[i]=new JLabel("    ");
			data[i].setFont(new Font("΢���ź�", Font.PLAIN, 25));
			data[i].addMouseListener(this);
			data[i].setBackground(Color.LIGHT_GRAY);
			data[i].setOpaque(true);
			schedule_1.add(data[i]);
		}
		
		
		
		add(schedule_1,BorderLayout.SOUTH);
	}
	@SuppressWarnings("unchecked")
	private void cheakhash() {
		// TODO �Զ����ɵķ������
		
		try {
			String key=year+month+day+"";
			System.out.println(key);
			file =new File("hashTable.txt");
			FileInputStream inOne=new FileInputStream(file);   
			ObjectInputStream inTwo=new ObjectInputStream(inOne);
			hashtable=(Hashtable<String, String>)inTwo.readObject();
			
			inOne.close();   
			inTwo.close();
			
			System.out.println(hashtable.containsKey(key));
			if (hashtable.containsKey(key)) {
				String tital=hashtable.get(key);
				data[0].setText("�ռ�:"+tital);
				
			}else if (year>nowday.get(Calendar.YEAR)&&month>nowday.get(Calendar.MONTH)+1&&day>nowday.get(Calendar.DATE)) {
				data[0].setText("��Ҫдδ���ռ���?");
				flag=false;
			}else{
				data[0].setText(month+"��"+day+"��:"+"���ռ�");
				flag=false;
			}
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public void setCalendar(int year, int month, int date) {
		// TODO �Զ����ɵķ������
		this.year = year;
		this.month=month;
		this.day=date;
		System.out.println(""+this.year+"��"+this.month+"��"+this.day+"��");
		if (nowday.get(Calendar.YEAR)==year&&nowday.get(Calendar.MONTH)+1==month&&nowday.get(Calendar.DATE)==day) {
			date_1.setText("����");
		} else {
			date_1.setText(""+year+"��"+month+"��"+date+"��");
		}
		cheakhash();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		if (flag) {
			NotePad frame = new NotePad();//����һ���µ�JFrame����Ϊ�´��ڡ�
	        frame.setBounds(// ���´�����Swing7����ʾ����50���ء�
	                new Rectangle(
	                        (int) mainFrame.getBounds().getX() + 475,
	                        (int) mainFrame.getBounds().getY() + 0, 
	                        1280, 
	                        (int) mainFrame.getBounds().getHeight()
	                )
	            );
	        
	        System.out.println(year+month+day);
	        frame.setDate(year,month,day);
	        frame.setVisible(true);
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		try {
			for (int i = 0; i < data.length; i++) {
				if (data[i]!=null&&arg0.getSource()==data[i]) {
					data[i].setBackground(new Color(204, 204, 204));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		try {
			for (int i = 0; i < data.length; i++) {
				if (data[i]!=null&&arg0.getSource()==data[i]) {
					data[i].setBackground(Color.LIGHT_GRAY);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		try {
			for (int i = 0; i < data.length; i++) {
				if (data[i]!=null&&arg0.getSource()==data[i]) {
					data[i].setBackground(Color.WHITE);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		try {
			for (int i = 0; i < data.length; i++) {
				if (data[i]!=null&&arg0.getSource()==data[i]) {
					data[i].setBackground(new Color(204, 204, 204));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int getYear() {
		// TODO �Զ����ɵķ������
		return year;
	}
	public int getMonth() {
		// TODO �Զ����ɵķ������
		return month;
	}
	public int getdate() {
		// TODO �Զ����ɵķ������
		return day;
	}
	public Hashtable<String, String> getHashtable() {
		// TODO �Զ����ɵķ������
		return hashtable;
	}
	public File getFile() {
		// TODO �Զ����ɵķ������
		return file;
	}
}
