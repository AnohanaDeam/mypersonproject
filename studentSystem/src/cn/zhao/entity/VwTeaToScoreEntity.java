package cn.zhao.entity;

public class VwTeaToScoreEntity {
	private String stuid;
	private String tea_id;
	private String tea_name;
	private String cou_id;
	private String cou_name;
	private String stu_name;
	private String sclass;
	private int scores;
	
	public VwTeaToScoreEntity() {
	}
	
	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
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

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "VwTeaToScoreEntity [stuid=" + stuid + ", tea_id=" + tea_id + ", tea_name=" + tea_name + ", cou_id="
				+ cou_id + ", cou_name=" + cou_name + ", stu_name=" + stu_name + ", sclass=" + sclass + ", scores="
				+ scores + "]";
	}
	
	
	
}
