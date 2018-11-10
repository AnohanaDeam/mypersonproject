package cn.zhao.entity;

public class AcademyDateEntity {
	private String aca_name;
	private String aca_dean;
	private double depNum;
	private double stuNum;
	private double teaNum;
	public AcademyDateEntity(String aca_name, String aca_dean, double depNum, double stuNum, double teaNum) {
		super();
		this.aca_name = aca_name;
		this.aca_dean = aca_dean;
		this.depNum = depNum;
		this.stuNum = stuNum;
		this.teaNum = teaNum;
	}
	public AcademyDateEntity() {

	}
	public String getAca_name() {
		return aca_name;
	}
	public void setAca_name(String aca_name) {
		this.aca_name = aca_name;
	}
	public String getAca_dean() {
		return aca_dean;
	}
	public void setAca_dean(String aca_dean) {
		this.aca_dean = aca_dean;
	}
	public double getDepNum() {
		return depNum;
	}
	public void setDepNum(double depNum) {
		this.depNum = depNum;
	}
	public double getStuNum() {
		return stuNum;
	}
	public void setStuNum(double stuNum) {
		this.stuNum = stuNum;
	}
	public double getTeaNum() {
		return teaNum;
	}
	public void setTeaNum(double teaNum) {
		this.teaNum = teaNum;
	}
	@Override
	public String toString() {
		return "AcademyDateEntity [aca_name=" + aca_name + ", aca_dean=" + aca_dean + ", depNum=" + depNum + ", stuNum="
				+ stuNum + ", teaNum=" + teaNum + "]";
	}
	
}
