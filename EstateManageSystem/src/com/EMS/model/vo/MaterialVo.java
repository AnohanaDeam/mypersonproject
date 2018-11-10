package com.EMS.model.vo;


/**
 * ���ϱ�
 * @author JTXY
 *
 */
public class MaterialVo {
	/**
	 * ���ϱ��
	 */
private String material_number;
/**
 * �������ͱ��
 */
private String material_type_number;
/**
 * �ļ�����
 */
private String file_name;
/**
 * �ļ��ֺ�
 */
private String file_size;
/**
 * ���ϵ�ַ
 */
private String material_address;
/**
 * ������ʽ
 */
private String form;
/**
 * ����ҵ��
 */
private String business_number;


public String getMaterial_number() {
	return material_number;
}
public void setMaterial_number(String material_number) {
	this.material_number = material_number;
}
public String getMaterial_type_number() {
	return material_type_number;
}
public void setMaterial_type_number(String material_type_number) {
	this.material_type_number = material_type_number;
}
public String getFile_name() {
	return file_name;
}
public void setFile_name(String file_name) {
	this.file_name = file_name;
}
public String getFile_size() {
	return file_size;
}
public void setFile_size(String file_size) {
	this.file_size = file_size;
}
public String getMaterial_address() {
	return material_address;
}
public void setMaterial_address(String material_address) {
	this.material_address = material_address;
}
public String getForm() {
	return form;
}
public void setForm(String form) {
	this.form = form;
}
public String getBusiness_number() {
	return business_number;
}
public void setBusiness_number(String business_number) {
	this.business_number = business_number;
}
@Override
public String toString() {
	return "MaterialVo [material_number=" + material_number + ", material_type_number=" + material_type_number
			+ ", file_name=" + file_name + ", file_size=" + file_size + ", material_address=" + material_address
			+ ", form=" + form + ", business_number=" + business_number + ", getMaterial_number()="
			+ getMaterial_number() + ", getMaterial_type_number()=" + getMaterial_type_number() + ", getFile_name()="
			+ getFile_name() + ", getFile_size()=" + getFile_size() + ", getMaterial_address()=" + getMaterial_address()
			+ ", getForm()=" + getForm() + ", getBusiness_number()=" + getBusiness_number() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
public MaterialVo(String material_number, String material_type_number, String file_name, String file_size,
		String material_address, String form, String business_number) {
	super();
	this.material_number = material_number;
	this.material_type_number = material_type_number;
	this.file_name = file_name;
	this.file_size = file_size;
	this.material_address = material_address;
	this.form = form;
	this.business_number = business_number;
}
public MaterialVo() {
	super();
	// TODO Auto-generated constructor stub
}


}
