package com.EMS.model.vo;

import java.util.Date;

public class FileVo {
private String business_number;
private String business_types;
private String property_owner;
private String file_location;
private String security;
private String address;
private Date filing_date;
public String getBusiness_number() {
	return business_number;
}
public void setBusiness_number(String business_number) {
	this.business_number = business_number;
}
public String getBusiness_types() {
	return business_types;
}
public void setBusiness_types(String business_types) {
	this.business_types = business_types;
}
public String getProperty_owner() {
	return property_owner;
}
public void setProperty_owner(String property_owner) {
	this.property_owner = property_owner;
}
public String getFile_location() {
	return file_location;
}
public void setFile_location(String file_location) {
	this.file_location = file_location;
}
public String getSecurity() {
	return security;
}
public void setSecurity(String security) {
	this.security = security;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getFiling_date() {
	return filing_date;
}
public void setFiling_date(Date filing_date) {
	this.filing_date = filing_date;
}
@Override
public String toString() {
	return "FileVo [business_number=" + business_number + ", business_types=" + business_types + ", property_owner="
			+ property_owner + ", file_location=" + file_location + ", security=" + security + ", address=" + address
			+ ", filing_date=" + filing_date + "]";
}
public FileVo(String business_number, String business_types, String property_owner, String file_location,
		String security, String address, Date filing_date) {
	super();
	this.business_number = business_number;
	this.business_types = business_types;
	this.property_owner = property_owner;
	this.file_location = file_location;
	this.security = security;
	this.address = address;
	this.filing_date = filing_date;
}
public FileVo() {
	super();
	// TODO Auto-generated constructor stub
}

}
