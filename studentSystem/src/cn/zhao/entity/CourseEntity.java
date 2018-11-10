package cn.zhao.entity;

public class CourseEntity {
	private String cou_id;
	private String cou_name;
	private double credit;
	private String materials;
	
	public CourseEntity(String cou_name, int credit, String materials) {
		super();
		this.cou_name = cou_name;
		this.credit = credit;
		this.materials = materials;
	}
	
	public CourseEntity() {
	}

	public String getCou_id() {
		return cou_id;
	}

	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}

	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materals) {
		this.materials = materals;
	}

	@Override
	public String toString() {
		return "CourseEntity [cou_id=" + cou_id + ", cou_name=" + cou_name + ", credit=" + credit + ", materials="
				+ materials + "]";
	}
	
	
	
}
