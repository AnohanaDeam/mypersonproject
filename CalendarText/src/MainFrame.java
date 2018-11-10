import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, MouseListener{

	JButton titleName[]=new JButton[7],labelDay[]=new JButton[42];
	String name[]={"日","一","二","三", "四","五","六"};
	JButton nextMonth,previousMonth/*,nextYear,previousYear*/;
	CalendarBean calendar;
	JLabel showMessage=new JLabel("",JLabel.CENTER);
	JComboBox<String> yearField,monthField;
	Calendar nowday = Calendar.getInstance();
	int year = nowday.get(Calendar.YEAR),month = nowday.get(Calendar.MONTH)+1,today = nowday.get(Calendar.DATE);
	int selectday=nowday.get(Calendar.DATE);
	int flag = 1;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unused")
	public MainFrame() {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asus-M\\workspace\\CalendarText\\img\\icon_calendar.png"));
		setTitle("\u65E5\u5386\u8BB0\u4E8B\u672C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		
		String path="bg0.jpg";
		ImageIcon background = new ImageIcon(path);
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(background);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) this.getContentPane();
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		AddItemToPannel();
	}
	private void AddItemToPannel() {
		// TODO 自动生成的方法存根
		JPanel pCenter=new JPanel();
		pCenter.setOpaque(false);
		pCenter.setLayout(new GridLayout(8,7)); //将pCenter的布局设置为7行7列的GridLayout 布局。
		pCenter.setBackground(Color.WHITE);
        for(int i=0;i<7;i++){
        	titleName[i] = new JButton(name[i]);
        	//titleName[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        	titleName[i].setContentAreaFilled(false);
        	titleName[i].setBorderPainted(false);
        	titleName[i].setFocusPainted(false);
        	titleName[i].setForeground(Color.WHITE);
        	titleName[i].setFont(new Font("微软雅黑",Font.PLAIN, 20));
        	pCenter.add(titleName[i]);
        }
        for(int i=0;i<42;i++){
        	labelDay[i]=new JButton("");
        	//labelDay[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        	labelDay[i].setForeground(Color.WHITE);
        	labelDay[i].setContentAreaFilled(false);
        	labelDay[i].setBorderPainted(false);
        	labelDay[i].addMouseListener(this);
        	labelDay[i].setFocusPainted(false);
        	labelDay[i].setFont(new Font("微软雅黑",Font.PLAIN, 20));
        	pCenter.add(labelDay[i]);//pCenter添加组件labelDay[i]。
        }
        calendar = new CalendarBean();
        calendar.setYear(year);
        calendar.setMonth(month);
        String day[]=calendar.getCalendar();
        for(int i=0;i<42;i++){
        	labelDay[i].setText(day[i]);
        }
        previousMonth=new JButton("上月");
        previousMonth.setForeground(Color.WHITE);
        previousMonth.setBackground(Color.WHITE);
        previousMonth.setContentAreaFilled(false); 
        previousMonth.setFocusPainted(false);
        previousMonth.addActionListener(this);
        monthField = new JComboBox<String>();
        monthField.setForeground(Color.WHITE);
        monthField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        monthField.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < 12; i++) {
        	monthField.addItem(""+(i+1));
		}
        monthField.addActionListener(this);
        yearField = new JComboBox<String>();
        yearField.setForeground(Color.WHITE);
        yearField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        yearField.setBackground(Color.LIGHT_GRAY);
        for (int y_1=nowday.get(Calendar.YEAR)-100,i = 0; i < 200; i++) {
        	y_1++;
        	yearField.addItem(""+y_1);
		}
        yearField.addActionListener(this);
        
        JPanel ppNonth=new JPanel(),pNorth=new JPanel(),pSouth = new JPanel();
        pNorth.setOpaque(false);
        pSouth.setOpaque(false);
        ppNonth.setOpaque(false);
        pNorth.setBackground(Color.WHITE);
        pSouth.setBackground(Color.WHITE);
        ppNonth.setBackground(Color.WHITE);
        ppNonth.setLayout(new BorderLayout());
       // pNorth.add(previousYear);
        pNorth.add(yearField);
        //pNorth.add(nextYear);
        JLabel label = new JLabel("年");
        label.setForeground(Color.WHITE);
        pNorth.add(label);
        pSouth.add(previousMonth);
        pNorth.add(monthField);
        JLabel label_1 = new JLabel("月");
        label_1.setForeground(Color.WHITE);
        pNorth.add(label_1);
        /*pSouth.setBackground(Color.WHITE);
        pSouth.add(showMessage);*/
        ppNonth.add(pNorth, BorderLayout.WEST);
        ppNonth.add(pSouth, BorderLayout.EAST);
        
        JPanel ptime=new JPanel();
        ptime.setOpaque(false);
        ptime.setBackground(Color.WHITE);
        JLabel pclock = new JLabel("00:00:00");
        pclock.setForeground(Color.WHITE);
        pclock.setFont(new Font("Consolas", Font.PLAIN, 64));
        pclock.setBackground(Color.WHITE);
        TimeColck timeColck=new TimeColck();
        timeColck.setLable(pclock);
        Thread threadone=new Thread(timeColck);
        threadone.start();
        ptime.setLayout(new BorderLayout());
        ptime.add(pclock,BorderLayout.NORTH);
        JLabel caLabel=new JLabel(""+nowday.get(Calendar.YEAR)+"年"+nowday.get(Calendar.MONTH)+1+"月"+nowday.get(Calendar.DATE)+"日");
        
        caLabel.setForeground(Color.CYAN);
        caLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        caLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent arg0) {
        		caLabel.setForeground(Color.LIGHT_GRAY);
        		
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		caLabel.setForeground(Color.CYAN);
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		setYearAndMonth(nowday.get(Calendar.YEAR),nowday.get(Calendar.MONTH)+1,nowday.get(Calendar.DATE));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		caLabel.setForeground(Color.GRAY);
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		caLabel.setForeground(Color.CYAN);
        	}
        });
        ptime.add(caLabel,BorderLayout.SOUTH);
        
        ppNonth.add(ptime, BorderLayout.NORTH);
        nextMonth=new JButton("下月");
        nextMonth.setForeground(Color.WHITE);
        nextMonth.setBackground(Color.WHITE);
        pSouth.add(nextMonth);
        nextMonth.setContentAreaFilled(false); 
        nextMonth.setFocusPainted(false);
        nextMonth.addActionListener(this);
        getContentPane().add(pCenter,BorderLayout.CENTER);
        getContentPane().add("North",ppNonth);//  窗口添加pNorth 在北面区域
        
        JPanel Downpanel=new JPanel();
        Downpanel.setOpaque(false);
        Downpanel.setBackground(Color.WHITE);
        Downpanel.setLayout(new BorderLayout());
        JLabel showSchedule=new JLabel("显示日记  /\\  ");
        showSchedule.setBackground(Color.WHITE);
        showSchedule.setForeground(Color.CYAN);
        showSchedule.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        showSchedule.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent arg0) {
        		showSchedule.setForeground(Color.LIGHT_GRAY);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		showSchedule.setForeground(Color.CYAN);
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		newBottem(Downpanel, showSchedule);
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		showSchedule.setForeground(Color.GRAY);
        		
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		showSchedule.setForeground(Color.CYAN);
        	}
        });
        Downpanel.add(showSchedule, BorderLayout.NORTH);
        
        getContentPane().add("South",Downpanel);// 窗口添加pSouth 在南区域。
        setYearAndMonth(year, month,today);
        
	}

	public void newBottem(JPanel Downpanel, JLabel showSchedule) {
		SchedulePanel schedulePanel=new SchedulePanel(this);
		if (flag==1) {
			
			System.out.println("-"+year+"-"+month+"-"+today);
			schedulePanel.setCalendar(year,month,selectday);
			schedulePanel.setOpaque(false);
			Downpanel.add(schedulePanel,BorderLayout.CENTER);
			showSchedule.setText("隐藏日记  \\/  ");
			Downpanel.add(showSchedule,BorderLayout.SOUTH);
			setSize(500, 800);
			flag = 0;
		}else if (flag == 0) {
			Downpanel.removeAll();
			showSchedule.setText("显示日记  /\\  ");
			Downpanel.add(showSchedule,BorderLayout.NORTH);
			setSize(500, 600);
			flag = 1;
		}
	}
	
	public void setYearAndMonth(int y,int m,int d) {
		calendar.setYear(y);
		calendar.setMonth(m);
		yearField.setSelectedIndex(y-nowday.get(Calendar.YEAR)+99);
		monthField.setSelectedIndex(m-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==nextMonth){
			month=month+1;
			if(month>12){
				month=1;
				year++;
				yearField.setSelectedIndex(year-nowday.get(Calendar.YEAR)+99);
				calendar.setYear(year);
			}
			System.out.println(month);
			monthField.setSelectedIndex(month-1);
			calendar.setMonth(month);
			String day[]=calendar.getCalendar();
			for(int i=0;i<42;i++){
				labelDay[i].setText(day[i]);
				labelDay[i].setOpaque(false);
				labelDay[i].setBackground(null);
				labelDay[i].setForeground(Color.WHITE);
				if(day[i]!=null&&nowday.get(Calendar.DATE)!=0&&month == nowday.get(Calendar.MONTH)+1&&year == nowday.get(Calendar.YEAR)){
					if (Integer.parseInt(day[i]) == nowday.get(Calendar.DATE)) {
						labelDay[i].setOpaque(true);
						labelDay[i].setBackground(Color.GRAY);
						labelDay[i].setForeground(Color.WHITE);
					}
				}
			}
		}
		else if(e.getSource()==previousMonth){
			month=month-1;
			if(month<1){
				month=12;
				year--;
				yearField.setSelectedIndex(year-nowday.get(Calendar.YEAR)+99);
				calendar.setYear(year);
			}
			System.out.println(month);
			monthField.setSelectedIndex(month-1);
			calendar.setMonth(month);
			String day[]=calendar.getCalendar();
			for(int i=0;i<42;i++){
				labelDay[i].setText(day[i]);
				labelDay[i].setOpaque(false);
				labelDay[i].setBackground(null);
				labelDay[i].setForeground(Color.WHITE);
				if(day[i]!=null&&nowday.get(Calendar.DATE)!=0&&month == nowday.get(Calendar.MONTH)+1&&year == nowday.get(Calendar.YEAR)){
					if (Integer.parseInt(day[i]) == nowday.get(Calendar.DATE)) {
						labelDay[i].setOpaque(true);
						labelDay[i].setBackground(Color.GRAY);
						labelDay[i].setForeground(Color.WHITE);
					}
				}
			}
		}
		else if(e.getSource()==yearField){
			int y;
			String str= (String) yearField.getSelectedItem();
			System.out.println(str);
			try {
				y = Integer.parseInt(str);
				calendar.setYear(y);
				String day[]=calendar.getCalendar();
				for(int i=0;i<42;i++){
					labelDay[i].setText(day[i]);
					labelDay[i].setOpaque(false);
					labelDay[i].setBackground(null);
					labelDay[i].setForeground(Color.WHITE);
					if(day[i]!=null&&nowday.get(Calendar.DATE)!=0&&y == nowday.get(Calendar.YEAR)&&year == nowday.get(Calendar.YEAR)){
						if (Integer.parseInt(day[i]) == nowday.get(Calendar.DATE)) {
							labelDay[i].setOpaque(true);
							labelDay[i].setBackground(Color.GRAY);
							labelDay[i].setForeground(Color.WHITE);
						}
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
		else if(e.getSource()==monthField){
			int m;
			String str= (String) monthField.getSelectedItem();
			System.out.println(str);
			try {
				m = Integer.parseInt(str);
				calendar.setYear(m);
				String day[]=calendar.getCalendar();
				for(int i=0;i<42;i++){
					labelDay[i].setText(day[i]);
					labelDay[i].setOpaque(false);
					labelDay[i].setBackground(null);
					labelDay[i].setForeground(Color.WHITE);
					if(day[i]!=null&&nowday.get(Calendar.DATE)!=0&&m == nowday.get(Calendar.MONTH)+1&&year == nowday.get(Calendar.YEAR)){
						if (Integer.parseInt(day[i]) == nowday.get(Calendar.DATE)) {
							labelDay[i].setOpaque(true);
							labelDay[i].setBackground(Color.GRAY);
							labelDay[i].setForeground(Color.WHITE);
						}
					}
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		try {
			String day[]=calendar.getCalendar();
			for (int i = 0; i < labelDay.length; i++) {
				if (day[i]!=null&&arg0.getSource()==labelDay[i]) {
					selectday=Integer.parseInt(labelDay[i].getText());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		try {
			String day[]=calendar.getCalendar();
			for (int i = 0; i < labelDay.length; i++) {
				if (day[i]!=null&&arg0.getSource()==labelDay[i]) {
					labelDay[i].setBorderPainted(true);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		try {
			String day[]=calendar.getCalendar();
			for (int i = 0; i < labelDay.length; i++) {
				if (day[i]!=null&&arg0.getSource()==labelDay[i]) {
					labelDay[i].setBorderPainted(false);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		try {
			String day[]=calendar.getCalendar();
			for (int i = 0; i < labelDay.length; i++) {
				if (labelDay[i].getBackground()!=Color.GRAY) {
					//labelDay[i].setBackground(Color.white);
					labelDay[i].setOpaque(false);
				}
				if (day[i]!=null&&arg0.getSource()==labelDay[i]&&labelDay[i].getBackground()!=Color.GRAY) {
					labelDay[i].setBackground(Color.LIGHT_GRAY);
					labelDay[i].setOpaque(true);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
