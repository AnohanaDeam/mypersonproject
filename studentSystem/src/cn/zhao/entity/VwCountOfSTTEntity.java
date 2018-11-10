package cn.zhao.entity;

public class VwCountOfSTTEntity {
	private String cou_id;
	private String cou_name;
	private String tea_name;
	private String tea_id;
	private int snum;
	public VwCountOfSTTEntity() {
		
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
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	@Override
	public String toString() {
		return "VwCountOfSTT [cou_id=" + cou_id + ", cou_name=" + cou_name + ", tea_name=" + tea_name + ", tea_id="
				+ tea_id + ", snum=" + snum + "]";
	}
	
	
}
