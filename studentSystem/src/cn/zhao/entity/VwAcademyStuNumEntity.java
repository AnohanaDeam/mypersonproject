package cn.zhao.entity;

public class VwAcademyStuNumEntity {
	private String aca_name;
	private String aca_dean;
	private double stu_num;
	public VwAcademyStuNumEntity(String aca_name, String aca_dean, double stu_num) {
		super();
		this.aca_name = aca_name;
		this.aca_dean = aca_dean;
		this.stu_num = stu_num;
	}
	public VwAcademyStuNumEntity() {

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
	public double getStu_num() {
		return stu_num;
	}
	public void setStu_num(double stu_num) {
		this.stu_num = stu_num;
	}
	@Override
	public String toString() {
		return "VwAcademyStuNumEntity [aca_name=" + aca_name + ", aca_dean=" + aca_dean + ", stu_num=" + stu_num + "]";
	}
	
}
