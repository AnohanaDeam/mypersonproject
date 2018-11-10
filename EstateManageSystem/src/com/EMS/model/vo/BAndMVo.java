package com.EMS.model.vo;
/**
 * 业务与材料关系表
 * @author JTXY
 *
 */
public class BAndMVo {
	/**
	 * 业务编号
	 */
	private String service_number;
	/**
	 * 材料编号
	 */
	private String material_number;
	/**
	 * 是否必须
	 */
	private String whether;
	/**
	 * 业务父编号
	 */
	private String f_service;
	
	/**
	 * 材料内容
	 */
	private MtypeVo mtypeVo;
	
	public MtypeVo getMtypeVo() {
		return mtypeVo;
	}
	public void setMtypeVo(MtypeVo mtypeVo) {
		this.mtypeVo = mtypeVo;
	}
	public String getService_number() {
		return service_number;
	}
	public void setService_number(String service_number) {
		this.service_number = service_number;
	}
	public String getMaterial_number() {
		return material_number;
	}
	public void setMaterial_number(String material_number) {
		this.material_number = material_number;
	}
	public String getWhether() {
		return whether;
	}
	public void setWhether(String whether) {
		this.whether = whether;
	}
	public String getF_service() {
		return f_service;
	}
	public void setF_service(String f_service) {
		this.f_service = f_service;
	}
	public BAndMVo(String service_number, String material_number, String whether, String f_service) {
		super();
		this.service_number = service_number;
		this.material_number = material_number;
		this.whether = whether;
		this.f_service = f_service;
	}
	public BAndMVo() {
		super();
	}
	@Override
	public String toString() {
		return "BAndMVo [service_number=" + service_number + ", material_number=" + material_number + ", whether="
				+ whether + ", f_service=" + f_service + ", mtypeVo=" + mtypeVo + "]";
	}
	

}
