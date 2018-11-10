package cn.zhao.entity;

public class VwAcademyDNumEntity {
	private String aca_name;
	private String aca_dean;
	private double depNum;
	public VwAcademyDNumEntity(String aca_name, String aca_dean, double depNum) {
		super();
		this.aca_name = aca_name;
		this.aca_dean = aca_dean;
		this.depNum = depNum;
	}
	public VwAcademyDNumEntity() {

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
	@Override
	public String toString() {
		return "VwAcademyDNumEntity [aca_name=" + aca_name + ", aca_dean=" + aca_dean + ", depNum=" + depNum + "]";
	}
	
	
	
}
