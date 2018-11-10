package cn.zhao.entity;

public class DepartmentEntity {
	private String dep_name;
	private String dep_phone;
	private String academy;
	private String dep_id;
	
	public DepartmentEntity(String dep_name, String dep_phone, String academy, String dep_id) {
		super();
		this.dep_name = dep_name;
		this.dep_phone = dep_phone;
		this.academy = academy;
		this.dep_id = dep_id;
	}
	
	public DepartmentEntity() {}

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

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getDep_id() {
		return dep_id;
	}

	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [dep_name=" + dep_name + ", dep_phone=" + dep_phone + ", academy=" + academy
				+ ", dep_id=" + dep_id + "]";
	}
}
