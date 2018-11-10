package com.EMS.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.EMS.model.vo.CertificateVo;

public interface CertificateService {
	/**
	 * 查询证件领取表
	 * @return
	 */
	  public List<CertificateVo> selectAll(); 
	 /**
	  * 修改证件领取表
	  * @param c
	  */
	  public void updateByBusiness_number(CertificateVo c);
     /**
      * 根据业务受理号删除证件领取表
      * @param c
      */
     public void deleteByBusiness_number(CertificateVo c);
     /**
      * 办法证件
      * @param c
      */
     public void save(CertificateVo c);
     /**
      * 修改是否领取
      */
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
     public List<CertificateVo> selectPrompt(String str1 ,int str2);
}
