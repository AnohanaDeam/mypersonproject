package com.EMS.model.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.CertificateMapper;
import com.EMS.model.service.CertificateService;
import com.EMS.model.vo.CertificateVo;
@Service
public class CertificateServiceImpl implements CertificateService{
@Autowired 
  private CertificateMapper certificatemapper;
	@Override
	/**
	 * ��ѯ֤��
	 */
	public List<CertificateVo> selectAll() {
		// TODO Auto-generated method stub
		return certificatemapper.selectAll();
	}

	@Override
	/**
	 * ����ҵ������޸�֤����Ϣ
	 */
	public void updateByBusiness_number(CertificateVo c) {
		// TODO Auto-generated method stub
		certificatemapper.updateByBusiness_number(c);
	}

	@Override
	/**
	 * ����ҵ�����ɾ��֤����Ϣ
	 */
	public void deleteByBusiness_number(CertificateVo c) {
		// TODO Auto-generated method stub
		certificatemapper.deleteByBusiness_number(c);
	}

	@Override
	/**
	 * ��д֤����Ϣ
	 */
	public void save(CertificateVo c) {
		// TODO Auto-generated method stub
		certificatemapper.save(c);
	}
	
	/**
	 * �޸��Ƿ���ȡ
	 */
	@Override
	public void updateReceive(CertificateVo c) {
		certificatemapper.updateReceive(c);
	}
	
	 /**
	  * ͨ��֤���Ų�ѯ���� 
	  */
	@Override
	public List<CertificateVo> selectByCertificateId(String certificate_id) {
		return certificatemapper.selectByCertificateId(certificate_id);
	}

	/**
	 * ͨ�����Ͳ�ѯ����
	 */
	@Override
	public List<CertificateVo> selectByBusinessTypes(String business_types) {
		return certificatemapper.selectByBusinessTypes(business_types);
	}
	/**
	 * ͨ��ҵ��Ų�ѯ����
	 */
	@Override
	public List<CertificateVo> selectByBusinessNumber(String business_number) {
		return certificatemapper.selectByBusinessNumber(business_number);
	}
	/**
	 * ͨ��֤�������˲�ѯ����
	 */
	@Override
	public List<CertificateVo> selectByOwner(String owner) {
		return certificatemapper.selectByOwner(owner);
	}
	/**
	 * ������ʾ��ģ����ѯ
	 */
	public List<CertificateVo> selectPrompt(String str1,int str2){
		return certificatemapper.selectPrompt(str1,str2);
	}

}
