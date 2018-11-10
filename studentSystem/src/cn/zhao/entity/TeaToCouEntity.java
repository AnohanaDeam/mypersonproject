package cn.zhao.entity;

public class TeaToCouEntity {
	private String tea_id;
	private String cou_id;
	public TeaToCouEntity(String tea_id, String cou_id) {
		super();
		this.tea_id = tea_id;
		this.cou_id = cou_id;
	}
	
	public TeaToCouEntity() {}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

	public String getCou_id() {
		return cou_id;
	}

	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}

	@Override
	public String toString() {
		return "TeaToCouEntity [tea_id=" + tea_id + ", cou_id=" + cou_id + "]";
	}
	
	
}
