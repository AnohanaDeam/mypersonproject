import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import sun.audio.*;

import javax.swing.JLabel;

public class TimeColck extends Thread{
	JLabel clock;
	SimpleDateFormat m = new SimpleDateFormat("kk:mm:ss");
	public void setLable(JLabel clock) {
		this.clock = clock;
	}
	public void run() {
		while (true) {
			Date date = new Date();
			clock.setText(""+m.format(date));

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			if( (gc.get(Calendar.MINUTE)==0) && (gc.get(Calendar.SECOND)==0) ){
				System.out.println("整点");
				try{
					File Filename=new File("1.wav");
					InputStream in = new FileInputStream(Filename);
					AudioStream as = new AudioStream(in);
					AudioPlayer.player.start(as);//用静态成员player.start播放音乐
					AudioPlayer.player.stop(as);//关闭音乐播放
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e);
				}
			}
		}
	}
