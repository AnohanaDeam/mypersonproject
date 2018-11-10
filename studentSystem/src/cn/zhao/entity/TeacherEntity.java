package cn.zhao.entity;

public class TeacherEntity {
	private String tea_id;
	private String tea_name;
	private String post;
	private int age;
	private String department;
	private int employ;
	
	
	public TeacherEntity(String tea_id, String tea_name, String post, int age, String department, int employ) {
		super();
		this.tea_id = tea_id;
		this.tea_name = tea_name;
		this.post = post;
		this.age = age;
		this.department = department;
		this.employ = employ;
	}
	
	public TeacherEntity() {}
	
	public int getEmploy() {
		return employ;
	}

	public void setEmploy(int employ) {
		this.employ = employ;
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

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "TeacherEntity [tea_id=" + tea_id + ", tea_name=" + tea_name + ", post=" + post + ", age=" + age
				+ ", department=" + department + ", employ=" + employ + "]";
	}
	
	
}
