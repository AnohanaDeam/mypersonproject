package com.EMS.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * tb_business������ݴ�����
 * 
 * @author JTXY ����:�洢ת��Business������
 */

public class BusinessVo{
	/**
	 * ҵ�������
	 */
	private String business_number;
	/**
	 * ����������
	 */
	private String applicant_name;
	/**
	 * ���֤����
	 */
	private String id_number;
	/**
	 * ��ϵ�绰
	 */
	private String phone;
	/**
	 * Ȩ������
	 */
	private String f_service;
	/**
	 * �Ǽ�����
	 */
	private String service_number;
	/**
	 * ҵ������ʱ��
	 */
	private Date service_time;
	/**
	 * ҵ������ʱ��String
	 */
	private String service_timestr;

	/**
	 * �Ѹ��ȼ�����
	 */
	private double level_price;

	/**
	 * ����������ϱ�
	 */
	private List<BAndMVo> bAndMVos;
	
	/**
	 * ����ʱ��
	 */
	private String service_name;
	
	/**
	 * ��Ӧ������
	 */
	private ServiceVo serviceVo;
	
	public ServiceVo getServiceVo() {
		return serviceVo;
	}

	public void setServiceVo(ServiceVo serviceVo) {
		this.serviceVo = serviceVo;
	}

	public List<BAndMVo> getbAndMVos() {
		return bAndMVos;
	}

	public void setbAndMVos(List<BAndMVo> bAndMVos) {
		this.bAndMVos = bAndMVos;
	}

	public String getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getF_service() {
		return f_service;
	}

	public void setF_service(String f_service) {
		this.f_service = f_service;
	}

	public String getService_number() {
		return service_number;
	}

	public void setService_number(String service_number) {
		this.service_number = service_number;
	}

	public Date getService_time() {
		return service_time;
	}

	public void setService_time(Date service_time) {
		this.service_time = service_time;
	}

	public double getLevel_price() {
		return level_price;
	}

	public void setLevel_price(double level_price) {
		this.level_price = level_price;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getService_timestr() {
		return service_timestr;
	}

	public void setService_timestr(String service_timestr) {
		this.service_timestr = service_timestr;
	}
	@Override
	public String toString() {
		return "BusinessVo [business_number=" + business_number + ", applicant_name=" + applicant_name + ", id_number="
				+ id_number + ", phone=" + phone + ", f_service=" + f_service + ", service_number=" + service_number
				+ ", service_time=" + service_time + ", level_price=" + level_price + ", bAndMVos=" + bAndMVos
				+ ", service_name=]";
	}

	public BusinessVo() {
		super();
	}

	public BusinessVo(String business_number, String applicant_name, String id_number, String phone, String f_service,
			String service_number, Date service_time) {
		super();
		this.business_number = business_number;
		this.applicant_name = applicant_name;
		this.id_number = id_number;
		this.phone = phone;
		this.f_service = f_service;
		this.service_number = service_number;
		this.service_time = service_time;
	}
	
}
