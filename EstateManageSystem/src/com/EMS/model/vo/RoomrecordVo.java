package com.EMS.model.vo;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品房备案表
 * @author 苏婵
 *
 */
public class RoomrecordVo implements Serializable{
	/**
	 * 序号
	 */
	private String number;
	/**
	 * 栋号
	 */
	private String movie_theater;
	/**
	 * 房号
	 */
	private String room_number;
	/**
	 * 面积
	 */
	private String area;
	/**
	 * 买受人
	 */
	private String buyer;
	/**
	 * 合同号
	 */
	private String business_number;
	/**
	 * 签约时间
	 */
	private Date signing_time;
	/**
	 * 总房款
	 */
	private double total_price;
	/**
	 * 付款方式
	 */
	private String payment_method;
	/**
	 * 预售备案
	 */
	private String booking_record;
	/**
	 * 按揭备案
	 */
	private String mortgage_reg;
	/**
	 * 按揭银行
	 */
	private String mortgage_bank;
	/**
	 * 项目号
	 */
	private String item_no;
	/**
	 * 地址
	 */
	public String address;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMovie_theater() {
		return movie_theater;
	}
	public void setMovie_theater(String movie_theater) {
		this.movie_theater = movie_theater;
	}
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getBusiness_number() {
		return business_number;
	}
	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}
	public Date getSigning_time() {
		return signing_time;
	}
	public void setSigning_time(Date signing_time) {
		this.signing_time = signing_time;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getBooking_record() {
		return booking_record;
	}
	public void setBooking_record(String booking_record) {
		this.booking_record = booking_record;
	}
	public String getMortgage_reg() {
		return mortgage_reg;
	}
	public void setMortgage_reg(String mortgage_reg) {
		this.mortgage_reg = mortgage_reg;
	}
	public String getMortgage_bank() {
		return mortgage_bank;
	}
	public void setMortgage_bank(String mortgage_bank) {
		this.mortgage_bank = mortgage_bank;
	}
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "RoomrecordVo [number=" + number + ", movie_theater=" + movie_theater + ", room_number=" + room_number
				+ ", area=" + area + ", buyer=" + buyer + ", business_number=" + business_number + ", signing_time="
				+ signing_time + ", total_price=" + total_price + ", payment_method=" + payment_method
				+ ", booking_record=" + booking_record + ", mortgage_reg=" + mortgage_reg + ", mortgage_bank="
				+ mortgage_bank + ", item_no=" + item_no + ", address=" + address + "]";
	}
	public RoomrecordVo(String number, String movie_theater, String room_number, String area, String buyer,
			String business_number, Date signing_time, double total_price, String payment_method, String booking_record,
			String mortgage_reg, String mortgage_bank, String item_no, String address) {
		super();
		this.number = number;
		this.movie_theater = movie_theater;
		this.room_number = room_number;
		this.area = area;
		this.buyer = buyer;
		this.business_number = business_number;
		this.signing_time = signing_time;
		this.total_price = total_price;
		this.payment_method = payment_method;
		this.booking_record = booking_record;
		this.mortgage_reg = mortgage_reg;
		this.mortgage_bank = mortgage_bank;
		this.item_no = item_no;
		this.address = address;
	}
	public RoomrecordVo() {
		super();
	}
	public RoomrecordVo(String movie_theater, String room_number, String area, String buyer, String business_number,
			Date signing_time, double total_price, String payment_method, String booking_record, String mortgage_reg,
			String mortgage_bank, String item_no, String address) {
		super();
		this.movie_theater = movie_theater;
		this.room_number = room_number;
		this.area = area;
		this.buyer = buyer;
		this.business_number = business_number;
		this.signing_time = signing_time;
		this.total_price = total_price;
		this.payment_method = payment_method;
		this.booking_record = booking_record;
		this.mortgage_reg = mortgage_reg;
		this.mortgage_bank = mortgage_bank;
		this.item_no = item_no;
		this.address = address;
	}
}
