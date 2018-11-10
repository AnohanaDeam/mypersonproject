package cn.zhao.entity;

public class VwAcademyTeaNumEntity {
	private String aca_name;
	private String aca_dean;
	private double teaa_num;
	public VwAcademyTeaNumEntity(String aca_name, String aca_dean, double teaa_num) {
		super();
		this.aca_name = aca_name;
		this.aca_dean = aca_dean;
		this.teaa_num = teaa_num;
	}
	public VwAcademyTeaNumEntity() {

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
	public double getTeaa_num() {
		return teaa_num;
	}
	public void setTeaa_num(double teaa_num) {
		this.teaa_num = teaa_num;
	}
	@Override
	public String toString() {
		return "VwAcademyTeaNum [aca_name=" + aca_name + ", aca_dean=" + aca_dean + ", teaa_num=" + teaa_num + "]";
	}
	
}
