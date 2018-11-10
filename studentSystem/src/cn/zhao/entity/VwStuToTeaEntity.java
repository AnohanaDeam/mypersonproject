package cn.zhao.entity;

public class VwStuToTeaEntity {
	private String cou_id;
	private String cou_name;
	private String tea_name;
	private String tea_id;
	private String stu_name;
	private String stuid;
	public VwStuToTeaEntity(String cou_name, String tea_name, String tea_id, String stu_name, String stuid) {
		super();
		this.cou_name = cou_name;
		this.tea_name = tea_name;
		this.tea_id = tea_id;
		this.stu_name = stu_name;
		this.stuid = stuid;
	}
	public VwStuToTeaEntity() {
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
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	@Override
	public String toString() {
		return "VwStuToTeaEntity [cou_id=" + cou_id + ", cou_name=" + cou_name + ", tea_name=" + tea_name + ", tea_id="
				+ tea_id + ", stu_name=" + stu_name + ", stuid=" + stuid + "]";
	}

	
	
	
}
