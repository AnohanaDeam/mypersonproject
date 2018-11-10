import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterJob;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class NotePad extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	boolean flag_2=false;
	JTextArea text;                 
	JButton saveText,deleteText;   
	Hashtable<String, String> hashtable;                
	JLabel message;       
	SchedulePanel schedulePanel;
	FontFamilyNames fontFamilyNames;
	Font font;
	int fontSize=18;
	String fontName="微软雅黑";
	JComboBox<String> fontnameList;
	JComboBox<Integer>fontSizeList;
	int state=0,state_1=0,state_2=0;
	PrinterJob prt = PrinterJob.getPrinterJob();
	String path = "bg0.jpg";
	int p;
	
	int year,month,day;             
	File file=new File("hashTable.txt");  
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton btnB;
	private JButton btnNewButton;
	private JPanel fontPanel;
	private JButton btnA;
	private JButton button;

	private JButton btnBi;
	private JPanel panel_1;
	private Clock clock;
	private JPanel panel_2;
	private JLabel label_1;
	private JButton button_1;
	private JButton button_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotePad frame = new NotePad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param path 
	 * @param schedulePanel 
	 */
	public NotePad() {
		//setBackground(Color.WHITE);
		setVisible(false);
		setTitle("\u65E5\u8BB0");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\icon_document_alt.png"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener(){
			public void windowClosing(WindowEvent e) {
				dispose();
            }
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO 自动生成的方法存根			
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO 自动生成的方法存根			
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO 自动生成的方法存根			
			}
		});
		
		setBounds(100, 200, 600, 450);
		
		ImageIcon background = new ImageIcon(path);
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(background);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		text=new JTextArea(10,10);
		text.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());  
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		
		JPanel pSouth=new JPanel();          
		pSouth.setOpaque(false);
		pSouth.setBackground(Color.WHITE);
		getContentPane().add(pSouth,BorderLayout.SOUTH);   
		
		saveText=new JButton("\u4FDD\u5B58") ;
		pSouth.add(saveText);
		saveText.setBackground(Color.WHITE);
		saveText.setIcon(new ImageIcon("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\icon_floppy.png"));
		saveText.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		saveText.setFocusPainted(false);
		
		deleteText=new JButton("\u5220\u9664") ;
		pSouth.add(deleteText);
		deleteText.setBackground(Color.WHITE);
		deleteText.setIcon(new ImageIcon("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\icon_trash_alt.png"));
		deleteText.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		deleteText.setFocusPainted(false);
		deleteText.addActionListener(this);   
		
		saveText.addActionListener(this);   
		JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setOpaque(false);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("\u65E5\u8BB0\u6807\u9898:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setForeground(Color.CYAN);
		
		
		textField.setOpaque(false);
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		panel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("                                     ");
		panel.add(lblNewLabel_1, BorderLayout.EAST);
		
		fontPanel = new JPanel();
		fontPanel.setOpaque(false);
		fontPanel.setBackground(Color.WHITE);
		panel.add(fontPanel, BorderLayout.SOUTH);
		
		font=new Font("微软雅黑", Font.PLAIN, 20);
		fontFamilyNames=new FontFamilyNames();
		String[] name=fontFamilyNames.getFontName();
		fontnameList=new JComboBox<>();
		fontnameList.setOpaque(false);
		fontnameList.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				fontName=(String)fontnameList.getSelectedItem();
				font=new Font(fontName, Font.PLAIN, fontSize);
				text.setFont(font);
				text.repaint();
			}
		});
		fontnameList.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		fontnameList.setBackground(Color.WHITE);
		fontSizeList=new JComboBox<>();

		fontSizeList.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int m=(Integer)fontSizeList.getSelectedItem();
				fontSize=m;
				font=new Font(fontName, Font.PLAIN, m);
				text.setFont(font);
				text.repaint();
			}
		});
		fontSizeList.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		fontSizeList.setOpaque(false);
		fontSizeList.setBackground(Color.WHITE);
		fontnameList.addItem("字体");
		for (int i = 0; i < name.length; i++) {
			fontnameList.addItem(name[i]);
		}
		for (int i = 8; i < 72; i=i+2) {
			fontSizeList.addItem(i);
		}
		fontSizeList.setSelectedIndex(5);
		fontPanel.add(fontnameList);
		fontPanel.add(fontSizeList);
		
		btnB = new JButton("B");
		btnB.addActionListener(this);
		fontPanel.add(btnB);
		btnB.setBackground(Color.WHITE);
		btnB.setFont(new Font("微软雅黑", Font.BOLD, 24));
		btnB.setFocusPainted(false);
		
		btnNewButton = new JButton("I");
		fontPanel.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("微软雅黑", Font.ITALIC, 24));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(this);
		
		btnA = new JButton("A");
		btnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color c=JColorChooser.showDialog(text,"请选择文字颜色",Color.blue);
                text.setForeground(c);
			}
		});
		
		btnBi = new JButton("BI");
		btnBi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (state_2==0) {
					font=new Font(fontName, Font.BOLD+Font.ITALIC, fontSize);
					text.setFont(font);
					state_2=1;
					System.out.println(state_2);
				} else if (state_2==1) {
					font=new Font(fontName, Font.PLAIN, fontSize);
					text.setFont(font);
					state_2=0;
					System.out.println(state_2);
				}
			}
		});
		
		btnBi.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 24));
		btnBi.setFocusPainted(false);
		btnBi.setBackground(Color.WHITE);
		fontPanel.add(btnBi);
		
		btnA.setForeground(Color.RED);
		btnA.setFont(new Font("微软雅黑", Font.ITALIC, 24));
		btnA.setFocusPainted(false);
		btnA.setBackground(Color.WHITE);
		fontPanel.add(btnA);
		
		button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prt.printDialog(); 
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\print-512.png"));
		button.setFont(new Font("Adobe Gurmukhi", Font.ITALIC, 31));
		button.setFocusPainted(false);
		button.setBackground(Color.WHITE);
		fontPanel.add(button);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2, BorderLayout.NORTH);
		
		
		message=new JLabel(""+year+"年"+month+"月"+day+"日",SwingConstants.CENTER);
		panel_2.add(message);
		message.setBackground(null);
		message.setFont(new Font("微软雅黑", Font.BOLD, 33));   
		message.setForeground(Color.WHITE);
		
		clock = new Clock();
		panel_2.add(clock);
		clock.setOpaque(false);
		clock.setBackground(Color.WHITE);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\forward-32.png"));
		contentPane.add(label_1, BorderLayout.EAST);
		
		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p++;
				path="bg"+p+".jpg";
				System.out.println(path);
				ImageIcon background = new ImageIcon(path);
				label.setIcon(background);
				if (p>4) {
					p=0;
				}
			}
		});
		button_1.setOpaque(false);
		button_1.setIcon(new ImageIcon("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\back-32.png"));
		button_1.setFont(new Font("微软雅黑", Font.BOLD, 24));
		button_1.setFocusPainted(false);
		button_1.setBackground(Color.WHITE);
		contentPane.add(button_1, BorderLayout.WEST);
		
		button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (p<=1) {
					p=5;
				}
				p--;
				path="bg"+p+".jpg";
				System.out.println(path);
				ImageIcon background = new ImageIcon(path);
				label.setIcon(background);
				
			}
		});
		button_2.setOpaque(false);
		button_2.setIcon(new ImageIcon("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\forward-32.png"));
		button_2.setFont(new Font("微软雅黑", Font.BOLD, 24));
		button_2.setFocusPainted(false);
		button_2.setBackground(Color.WHITE);
		contentPane.add(button_2, BorderLayout.EAST);
		
		getTextStyle();
		setTextStyle();
	}


	public void Newdiray() {
		String key=year+month+day+"";
		hashtable = new Hashtable<String, String>();
		String mString=text.getText();
		String name=textField.getText();
		NewDelCopyFile newDelCopyFile=new NewDelCopyFile();
		newDelCopyFile.newFile(name+".txt", mString);//\\diary\\"+year+"_"+month+"_"+day+"
		hashtable.put(key, name);
		JOptionPane.showMessageDialog(this, 
				"保存成功", "提示", JOptionPane.INFORMATION_MESSAGE);
		file = new File("hashTable.txt");
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			ObjectOutputStream objectOut=new ObjectOutputStream(out);   
			objectOut.writeObject(hashtable);   
			objectOut.close();   
			out.close(); 
		} catch ( IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		
			/*FileInputStream inOne=new FileInputStream(file);   
			ObjectInputStream inTwo=new ObjectInputStream(inOne);*/
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getSource()==saveText){   
			Newdiray();
			//saveText(year,month,day);   
		}   
		else if(arg0.getSource()==deleteText){   
			deletediray();
			//deleteText(year,month,day);   
		}else if (arg0.getSource()==btnNewButton) {
			if (state==0) {
				font=new Font(fontName, Font.ITALIC, fontSize);
				text.setFont(font);
				state=1;
			} else if (state==1) {
				font=new Font(fontName, Font.PLAIN, fontSize);
				text.setFont(font);
				state=0;
			}
			
		}else if (arg0.getSource()==btnB) {
			if (state_1==0) {
				font=new Font(fontName, Font.BOLD, fontSize);
				text.setFont(font);
				state_1=1;
			} else if (state_1==1) {
				font=new Font(fontName, Font.PLAIN, fontSize);
				text.setFont(font);
				state_1=0;
			}
		}
	}
	@SuppressWarnings("unchecked")
	private void deletediray() {
		// TODO 自动生成的方法存根
		
		String key=year+month+day+"";
		
		String m="删除"+year+"年"+month+"月"+day+"日的日志吗?";   
		int ok=JOptionPane.showConfirmDialog(this,m,"提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);   
		if(ok==JOptionPane.YES_OPTION){
			try {
					FileInputStream inOne=new FileInputStream(file);   
					ObjectInputStream inTwo=new ObjectInputStream(inOne);
					hashtable=(Hashtable<String, String>)inTwo.readObject();  
					
					if (hashtable.containsKey(key)) {
						String tital=hashtable.get(key);
					
					inOne.close();   
					inTwo.close();   
					hashtable.remove(key);                                           
					FileOutputStream out=new FileOutputStream(file);   
					ObjectOutputStream objectOut=new ObjectOutputStream(out);   
					objectOut.writeObject(hashtable);   
					objectOut.close();   
					out.close();   
					
					File f = new File(tital+".txt");  // 输入要删除的文件位置
					if(f.exists()){
					    f.delete();
					    JOptionPane.showMessageDialog(this, 
								"删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				// TODO: handle exception
			}
		}
	}
		
	public void setDate(int year, int month, int day){   
		this.year=year;   
		this.month=month;
		this.day=day;   
		System.out.println(this.year+this.month+this.day);
		message.setText(""+year+"年"+month+"月"+day+"日");
		setNotePad();
		
	}   
	public int getYear(){   
		return year;   
	}    
	public int getMonth(){   
		return month;   
	}     
	public int getDay(){   
		return day;   
	}   
	public void setmessage(int year,int month,int day){   
		message.setText(""+year+"年"+month+"月"+day+"日");   
	}   
	@SuppressWarnings("unchecked")
	public void setNotePad(){
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
				textField.setText(tital);
				String file_1 =new String(tital+".txt");
				System.out.println(file_1);
				if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file_1));
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        text.append(lineTxt);
                    	System.out.println(lineTxt);
                        
                    }
                    read.close();
                    }
				}
			}catch (ClassNotFoundException | IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}   
	public void getTextStyle(){
		if (text.getFont() != null) {
			font=text.getFont();
		} else {
			font=new Font("微软雅黑", Font.PLAIN, 18);
		}
	}
	public void setTextStyle(){
		if (font==null) {
			text.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		} else {
			text.setFont(font); 
		}
	}   
	/*public void getText(int year,int month,int day){   
		String key=""+year+""+month+""+day;   
		try{   
			FileInputStream inOne=new FileInputStream(file);   
			ObjectInputStream inTwo=new ObjectInputStream(inOne);   
			table=(Hashtable)inTwo.readObject();            
			inOne.close();   
			inTwo.close();   
		}   
		catch(Exception ee)   {   
			
		}   
		if(table.containsKey(key)){   
			String mString=""+year+"年"+month+"月"+day+"日这一天有日志记载,想看吗?";   
			int ok=JOptionPane.showConfirmDialog(this,mString,"询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);   
			if(ok==JOptionPane.YES_OPTION){   
				text.setText((String)table.get(key));   
			}   
			else{   
				text.setText("");    
			}   
		}    
		else{   
			text.setText("无日记");   
		}    
	}   */

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自动生成的方法存根
		
	}

	/*public void saveText(int year,int month,int day){   
	     String mString=text.getText();   
	     String key=""+year+""+month+""+day;   
	           
	     String m=""+year+"年"+month+"月"+day+"saveText吗?";   
	     int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);   
	     if(ok==JOptionPane.YES_OPTION){   
	    	 try{   
	    		 NewDelCopyFile newDelCopyFile=new NewDelCopyFile();
	    		 newDelCopyFile.newFile("\\diary\\"+year+"_"+month+"_"+day, mString);
	    		 FileInputStream   inOne=new FileInputStream(file);   
	    		 ObjectInputStream inTwo=new ObjectInputStream(inOne);   
	    		 table=(Hashtable)inTwo.readObject();   
	    		 inOne.close();   
	    		 inTwo.close();   
	    		 table.put(key,mString);                                     
	    		 FileOutputStream out=new FileOutputStream(file);   
	    		 ObjectOutputStream objectOut=new ObjectOutputStream(out);   
	    		 objectOut.writeObject(table);   
	    		 objectOut.close();   
	    		 out.close();   
	    	 }   
	    	 catch(Exception ee){   
	    		 
	    	 }   
	     }   
	}   */
	/*@SuppressWarnings("rawtypes")
	public void deleteText(int year,int month,int day){   
		String key=""+year+""+month+""+day;   
		if(table.containsKey(key)){     
			String m="删除"+year+"年"+month+"月"+day+"日的日志吗?";   
			int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);   
			if(ok==JOptionPane.YES_OPTION){    
				try{   
					FileInputStream   inOne=new FileInputStream(file);   
					ObjectInputStream inTwo=new ObjectInputStream(inOne);   
					table=(Hashtable)inTwo.readObject();   
					inOne.close();   
					inTwo.close();   
					table.remove(key);                                           
					FileOutputStream out=new FileOutputStream(file);   
					ObjectOutputStream objectOut=new ObjectOutputStream(out);   
					objectOut.writeObject(table);   
					objectOut.close();   
					out.close();   
					text.setText(null);   
				}   
				catch(Exception ee){
					
				}   
			}   
		}   
		else{
			String m=""+year+"年"+month+"月"+day+"无日志记录";   
			JOptionPane.showMessageDialog(this,m,"提示",JOptionPane.WARNING_MESSAGE);   
		}   
	}   */
}
