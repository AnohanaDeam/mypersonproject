package cn.zhao.entity;

public class SegmentCouidEntity {
	private String Segment;
	private String cou_id;
	public SegmentCouidEntity(String segment, String cou_id) {
		super();
		Segment = segment;
		this.cou_id = cou_id;
	}
	public SegmentCouidEntity() {

	}
	public String getSegment() {
		return Segment;
	}
	public void setSegment(String segment) {
		Segment = segment;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	@Override
	public String toString() {
		return "SegmentCouidEntity [Segment=" + Segment + ", cou_id=" + cou_id + "]";
	}
	
}
