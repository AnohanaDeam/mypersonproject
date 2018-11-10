package cn.zhao.entity;

public class AcademyEntity {
	private String aca_name;
	private String aca_dean;
	private String deansex;
	
	public AcademyEntity(String aca_name, String aca_dean, String deansex) {
		super();
		this.aca_name = aca_name;
		this.aca_dean = aca_dean;
		this.deansex = deansex;
	}
	
	public AcademyEntity() {

	}

	public String getAca_name() {
		return aca_name;
	}

	public void setAca_name(String aca_name) {
		this.aca_name = aca_name;
	}

	public String getAca_dean() {
		return aca_dean;
	}

	public void setAca_dean(String aca_dean) {
		this.aca_dean = aca_dean;
	}

	public String getDeansex() {
		return deansex;
	}

	public void setDeansex(String deansex) {
		this.deansex = deansex;
	}

	@Override
	public String toString() {
		return "AcademyEntity [aca_name=" + aca_name + ", aca_dean=" + aca_dean + ", deansex=" + deansex + "]";
	}
	
	
}
