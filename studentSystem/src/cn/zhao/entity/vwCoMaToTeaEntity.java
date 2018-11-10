package cn.zhao.entity;

public class vwCoMaToTeaEntity {
	private String cou_id;
	private String cou_name;
	private String book_name;
	private String tea_name;
	private String tea_id;
	public vwCoMaToTeaEntity(String cou_id, String cou_name, String book_name, String tea_name, String tea_id) {
		super();
		this.cou_id = cou_id;
		this.cou_name = cou_name;
		this.book_name = book_name;
		this.tea_name = tea_name;
		this.tea_id = tea_id;
	}
	public vwCoMaToTeaEntity() {
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
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	@Override
	public String toString() {
		return "vwCoMaToTeaEntity [cou_id=" + cou_id + ", cou_name=" + cou_name + ", book_name=" + book_name
				+ ", tea_name=" + tea_name + ", tea_id=" + tea_id + "]";
	}
	
	
	
}
