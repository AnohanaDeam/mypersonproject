package com.EMS.model.vo;
/**
 * 业务表
 * @author 苏婵
 *
 */
public class ServiceVo {
	/**
	 * 业务编号
	 */
	private String service_number;
	/**
	 * 业务名称
	 */
	private String service_name;
	/**
	 * 业务父编号
	 */
	private String f_service;
	
	
	public String getService_number() {
		return service_number;
	}
	public void setService_number(String service_number) {
		this.service_number = service_number;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getF_service() {
		return f_service;
	}
	public void setF_service(String f_service) {
		this.f_service = f_service;
	}
	@Override
	public String toString() {
		return "ServiceVo [service_number=" + service_number + ", service_name=" + service_name + ", f_service="
				+ f_service + "]";
	}
	public ServiceVo(String service_number, String service_name, String f_service) {
		super();
		this.service_number = service_number;
		this.service_name = service_name;
		this.f_service = f_service;
	}
	public ServiceVo() {
		super();
	}
	public ServiceVo(String f_service,String service_number) {
		this.f_service = f_service;
		this.service_number = service_number;
	}
	
}
