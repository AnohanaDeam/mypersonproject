package com.EMS.model.vo;

/**
 * tb_M_type�������ͱ�����ݴ�����
 * @author JTXY
 * ����:�洢ת��Mtype������
 */

public class MtypeVo {
	
	/**
	 * �������ͱ��
	 */
	private String Material_type_number;
	/**
	 * ��������
	 */
	private String Material_name;
	
	
	public String getMaterial_type_number() {
		return Material_type_number;
	}
	public void setMaterial_type_number(String material_type_number) {
		Material_type_number = material_type_number;
	}
	public String getMaterial_name() {
		return Material_name;
	}
	public void setMaterial_name(String material_name) {
		Material_name = material_name;
	}
	
	@Override
	public String toString() {
		return "MtypeVo [Material_type_number=" + Material_type_number + ", Material_name=" + Material_name + "]";
	}
	public MtypeVo(String material_type_number, String material_name) {
		super();
		Material_type_number = material_type_number;
		Material_name = material_name;
	}
	public MtypeVo() {
		super();
	}
	
	

}
