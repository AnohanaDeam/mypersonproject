package cn.zhao.entity;

public class StudentScoreEntity {
	private int rank;
	private String cou_name;
	private double score;
	public StudentScoreEntity(int rank, String cou_name, double score) {
		super();
		this.rank = rank;
		this.cou_name = cou_name;
		this.score = score;
	}
	public StudentScoreEntity() {
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCou_name() {
		return cou_name;
	}
	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentScoreEntity [rank=" + rank + ", cou_name=" + cou_name + ", score=" + score + "]";
	}
	
}
