package com.EMS.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.EMS.model.vo.CertificateVo;

public interface CertificateMapper {
     public List<CertificateVo> selectAll(); 
     public void updateByBusiness_number(CertificateVo c);
     public void deleteByBusiness_number(CertificateVo c);
     public void save(CertificateVo c);
     //�޸�receive
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
     public List<CertificateVo> selectPrompt(String str1,int str2);
}
