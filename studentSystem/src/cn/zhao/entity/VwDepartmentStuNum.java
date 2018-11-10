package cn.zhao.entity;

public class VwDepartmentStuNum {
	private String dep_name;
	private String dep_phone;
	private String dep_id;
	private double stu_num;
	private String academy;
	public VwDepartmentStuNum(String dep_name, String dep_phone, String dep_id, double stu_num, String academy) {
		super();
		this.dep_name = dep_name;
		this.dep_phone = dep_phone;
		this.dep_id = dep_id;
		this.stu_num = stu_num;
		this.academy = academy;
	}
	public VwDepartmentStuNum() {

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
	public double getStu_num() {
		return stu_num;
	}
	public void setStu_num(double stu_num) {
		this.stu_num = stu_num;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	@Override
	public String toString() {
		return "VwDepartmentStuNum [dep_name=" + dep_name + ", dep_phone=" + dep_phone + ", dep_id=" + dep_id
				+ ", stu_num=" + stu_num + ", academy=" + academy + "]";
	}
	
}
