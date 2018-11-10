package cn.zhao.entity;

public class DepartmentDateEntity extends DepartmentEntity{
	private double stuNum;
	private double teaNum;
	public DepartmentDateEntity(String dep_name, String dep_phone, String academy, String dep_id, double stuNum,
			double teaNum) {
		super(dep_name, dep_phone, academy, dep_id);
		this.stuNum = stuNum;
		this.teaNum = teaNum;
	}
	public DepartmentDateEntity() {

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
		return "DepartmentDateEntity [stuNum=" + stuNum + ", teaNum=" + teaNum + "]";
	}
	
}
