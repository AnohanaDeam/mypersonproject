package com.EMS.model.vo;

/**
 * 商品房项目房表
 * HousingProject表的数据传递类
 * @author JTXY
 * 功能:存储转发HousingProject的数据
 */
public class HousingProjectVo {
	/**
	 * 项目号
	 */
	private String item_no;
	/**
	 * 开发企业
	 */
	private String enterprise;
	/**
	 * 项目名称
	 */
	private String project_name;
	/**
	 * 预售证号
	 */
	private String booking_number;
	/**
	 * 地址
	 * @return
	 */
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getBooking_number() {
		return booking_number;
	}
	public void setBooking_number(String booking_number) {
		this.booking_number = booking_number;
	}
	
	public HousingProjectVo(String item_no, String enterprise, String project_name, String booking_number,
			String address) {
		super();
		this.item_no = item_no;
		this.enterprise = enterprise;
		this.project_name = project_name;
		this.booking_number = booking_number;
		this.address = address;
	}
	public HousingProjectVo() {
		super();
	}
	@Override
	public String toString() {
		return "HousingProjectVo [item_no=" + item_no + ", enterprise=" + enterprise + ", project_name=" + project_name
				+ ", booking_number=" + booking_number + ", address=" + address + "]";
	}
	
}
