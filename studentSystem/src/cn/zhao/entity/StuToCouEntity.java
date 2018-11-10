package cn.zhao.entity;

public class StuToCouEntity {
	private String stu_id;
	private String cou_id;
	private int scores;
	public StuToCouEntity() {

	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "StuToCouEntity [stu_id=" + stu_id + ", cou_id=" + cou_id + ", scores=" + scores + "]";
	}
	
	
}
