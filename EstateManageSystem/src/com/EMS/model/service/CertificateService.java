package com.EMS.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.EMS.model.vo.CertificateVo;

public interface CertificateService {
	/**
	 * ��ѯ֤����ȡ��
	 * @return
	 */
	  public List<CertificateVo> selectAll(); 
	 /**
	  * �޸�֤����ȡ��
	  * @param c
	  */
	  public void updateByBusiness_number(CertificateVo c);
     /**
      * ����ҵ�������ɾ��֤����ȡ��
      * @param c
      */
     public void deleteByBusiness_number(CertificateVo c);
     /**
      * �취֤��
      * @param c
      */
     public void save(CertificateVo c);
     /**
      * �޸��Ƿ���ȡ
      */
     public void updateReceive(CertificateVo c);
     //ͨ��֤���Ų�ѯ���� 
     public List<CertificateVo> selectByCertificateId(String certificate_id);
     //ͨ�����Ͳ�ѯ����
     public List<CertificateVo> selectByBusinessTypes(String business_types);
     //ͨ��ҵ��Ų�ѯ����
     public List<CertificateVo> selectByBusinessNumber(String business_number);
     //ͨ��֤�������˲�ѯ����
     public List<CertificateVo> selectByOwner(String owner);
     //������ʾ��ģ����ѯ
     /*public List<CertificateVo> selectPrompt(@Param("search")String search);*/
     public List<CertificateVo> selectPrompt(String str1 ,int str2);
}
