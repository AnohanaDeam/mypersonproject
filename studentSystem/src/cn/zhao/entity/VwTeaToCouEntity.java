package cn.zhao.entity;

public class VwTeaToCouEntity {
	private String cou_id;
	private String cou_name;
	private int credit;
	private String tea_id;
	private String tea_name;
	
	public VwTeaToCouEntity(String cou_id, String cou_name, int credit, String tea_id, String tea_name) {
		super();
		this.cou_id = cou_id;
		this.cou_name = cou_name;
		this.credit = credit;
		this.tea_id = tea_id;
		this.tea_name = tea_name;
	}
	
	public VwTeaToCouEntity() {}

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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

	public String getTea_name() {
		return tea_name;
	}

	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}

	@Override
	public String toString() {
		return "VwTeaToCouEntity [cou_id=" + cou_id + ", cou_name=" + cou_name + ", credit=" + credit + ", tea_id="
				+ tea_id + ", tea_name=" + tea_name + "]";
	}
	
	
}
