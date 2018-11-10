package cn.zhao.entity;

public class VwDepartmentTeaNum {
	private String dep_name;
	private String dep_phone;
	private String dep_id;
	private double tea_num;
	private String academy;
	public VwDepartmentTeaNum(String dep_name, String dep_phone, String dep_id, double tea_num, String academy) {
		super();
		this.dep_name = dep_name;
		this.dep_phone = dep_phone;
		this.dep_id = dep_id;
		this.tea_num = tea_num;
		this.academy = academy;
	}
	public VwDepartmentTeaNum() {

	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getDep_phone() {
		return dep_phone;
	}
	public void setDep_phone(String dep_phone) {
		this.dep_phone = dep_phone;
	}
	public String getDep_id() {
		return dep_id;
	}
	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	public double getTea_num() {
		return tea_num;
	}
	public void setTea_num(double tea_num) {
		this.tea_num = tea_num;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	@Override
	public String toString() {
		return "VwDepartmentTeaNum [dep_name=" + dep_name + ", dep_phone=" + dep_phone + ", dep_id=" + dep_id
				+ ", tea_num=" + tea_num + ", academy=" + academy + "]";
	}
	
}
