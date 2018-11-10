package com.EMS.model.vo;

/**
 * ֤����ȡ��
 * @author JTXY
 *
 */
public class CertificateVo {
	/**
	 * ֤����
	 */
	private String certificate_id;
	/**
	 * ҵ������
	 */
	private String business_types;
	/**
	 * ҵ�������
	 */
	private String business_number;
	/**
	 * ֤��������
	 */
	private String owner;
	/**
	 * �Ƿ���ȡ
	 */
	private String receive;
	/**
	 * ������Ϣ
	 */
	private String other_information;
	public String getCertificate_id() {
		return certificate_id;
	}
	public void setCertificate_id(String certificate_id) {
		this.certificate_id = certificate_id;
	}
	public String getBusiness_types() {
		return business_types;
	}
	public void setBusiness_types(String business_types) {
		this.business_types = business_types;
	}
	public String getBusiness_number() {
		return business_number;
	}
	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}
	public String getOther_information() {
		return other_information;
	}
	public void setOther_information(String other_information) {
		this.other_information = other_information;
	}
	public CertificateVo(String certificate_id, String business_types, String business_number, String owner,
			String receive, String other_information) {
		super();
		this.certificate_id = certificate_id;
		this.business_types = business_types;
		this.business_number = business_number;
		this.owner = owner;
		this.receive = receive;
		this.other_information = other_information;
	}
	
	public CertificateVo(String certificate_id, String business_types, String owner, String receive,
			String other_information) {
		super();
		this.certificate_id = certificate_id;
		this.business_types = business_types;
		this.owner = owner;
		this.receive = receive;
		this.other_information = other_information;
	}
	public CertificateVo() {
		super();
	}
	@Override
	public String toString() {
		return "CertificateVo [certificate_id=" + certificate_id + ", business_types=" + business_types
				+ ", business_number=" + business_number + ", owner=" + owner + ", receive=" + receive
				+ ", other_information=" + other_information + "]";
	}
	public CertificateVo(String business_number, String receive) {
		super();
		this.business_number = business_number;
		this.receive = receive;
	}
	

}
