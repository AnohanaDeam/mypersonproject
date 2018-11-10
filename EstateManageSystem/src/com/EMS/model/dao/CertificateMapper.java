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
     //修改receive
     public void updateReceive(CertificateVo c);
     //通过证件号查询数据 
     public List<CertificateVo> selectByCertificateId(String certificate_id);
     //通过类型查询数据
     public List<CertificateVo> selectByBusinessTypes(String business_types);
     //通过业务号查询数据
     public List<CertificateVo> selectByBusinessNumber(String business_number);
     //通过证件所有人查询数据
     public List<CertificateVo> selectByOwner(String owner);
     //搜索提示框模糊查询
     /*public List<CertificateVo> selectPrompt(@Param("search")String search);*/
     public List<CertificateVo> selectPrompt(String str1,int str2);
}
