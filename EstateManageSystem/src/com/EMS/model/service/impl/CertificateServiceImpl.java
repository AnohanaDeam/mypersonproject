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
	 * 查询证件
	 */
	public List<CertificateVo> selectAll() {
		// TODO Auto-generated method stub
		return certificatemapper.selectAll();
	}

	@Override
	/**
	 * 根据业务处理号修改证件信息
	 */
	public void updateByBusiness_number(CertificateVo c) {
		// TODO Auto-generated method stub
		certificatemapper.updateByBusiness_number(c);
	}

	@Override
	/**
	 * 根据业务处理号删除证件信息
	 */
	public void deleteByBusiness_number(CertificateVo c) {
		// TODO Auto-generated method stub
		certificatemapper.deleteByBusiness_number(c);
	}

	@Override
	/**
	 * 填写证件信息
	 */
	public void save(CertificateVo c) {
		// TODO Auto-generated method stub
		certificatemapper.save(c);
	}
	
	/**
	 * 修改是否领取
	 */
	@Override
	public void updateReceive(CertificateVo c) {
		certificatemapper.updateReceive(c);
	}
	
	 /**
	  * 通过证件号查询数据 
	  */
	@Override
	public List<CertificateVo> selectByCertificateId(String certificate_id) {
		return certificatemapper.selectByCertificateId(certificate_id);
	}

	/**
	 * 通过类型查询数据
	 */
	@Override
	public List<CertificateVo> selectByBusinessTypes(String business_types) {
		return certificatemapper.selectByBusinessTypes(business_types);
	}
	/**
	 * 通过业务号查询数据
	 */
	@Override
	public List<CertificateVo> selectByBusinessNumber(String business_number) {
		return certificatemapper.selectByBusinessNumber(business_number);
	}
	/**
	 * 通过证件所有人查询数据
	 */
	@Override
	public List<CertificateVo> selectByOwner(String owner) {
		return certificatemapper.selectByOwner(owner);
	}
	/**
	 * 搜索提示框模糊查询
	 */
	public List<CertificateVo> selectPrompt(String str1,int str2){
		return certificatemapper.selectPrompt(str1,str2);
	}

}
