
import java.util.Calendar;

public class CalendarBean{  
	String  day[];
	int year=2005,month=0,date=0;
	public void setYear(int year){
		this.year=year;
	}
	public int getYear(){    
		return year; 
	}
	public void setMonth(int month){   
		this.month=month;
	}
	public int getMonth(){ 
		return month; 
	}
	public void setdate(int date) {
		this.date=date;
	}
	public int getdate() {
		return date;
	}
	public String[] getCalendar(){
		String a[]=new String[42];     
		Calendar 日历=Calendar.getInstance();
		日历.set(year,month-1,1);             
		int 星期几=日历.get(Calendar.DAY_OF_WEEK)-1;
		int day=0;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			day=31;//设置为31天的月份
		} 
		if(month==4||month==6||month==9||month==11){
			day=30;//设置为30天的月份
		}
		if(month==2){
			if(((year%4==0)&&(year%100!=0))||(year%400==0)){
				day=29;//判断闰年
			}else{
				day=28;
			}
		}
		for(int i=星期几,n=1;i<星期几+day;i++){ 
				a[i]=String.valueOf(n) ;
				n++;
		}  
		return a;//返回可用于设置日历的数组
	} 
}

