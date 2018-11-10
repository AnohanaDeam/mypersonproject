package cn.zhao.entity;

public class StudentEntity {
	private String stuid;
	private String sex;
	private String department;
	private String academy;
	private String classM;
	private double totalcredits;
	private double gpa;
	private String stu_name;
	
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getClassM() {
		return classM;
	}
	public void setClassM(String classM) {
		this.classM = classM;
	}
	public double getTotalcredits() {
		return totalcredits;
	}
	public void setTotalcredits(double totalcredits) {
		this.totalcredits = totalcredits;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public StudentEntity(String sex, String indepartment, String academy, String classM, double totalcredits, double gpa,
			String studentname) {
		super();
		this.sex = sex;
		this.department = indepartment;
		this.academy = academy;
		this.classM = classM;
		this.totalcredits = totalcredits;
		this.gpa = gpa;
		this.stu_name = studentname;
	}
	public StudentEntity() {

	}
	@Override
	public String toString() {
		return "StudentEntity [stuid=" + stuid + ", sex=" + sex + ", department=" + department + ", academy=" + academy
				+ ", classM=" + classM + ", totalcredits=" + totalcredits + ", gpa=" + gpa + ", studentname="
				+ stu_name + "]";
	}
	
}
