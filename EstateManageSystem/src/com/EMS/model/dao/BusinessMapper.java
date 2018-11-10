package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.BusinessVo;

public interface BusinessMapper {
	
	public List<BusinessVo> selectBusinessAll();
	public void updateBybusiness_number(BusinessVo housingProjectVo);
	public void deleteBybusiness_number(String business_number);
	public void saveBusiness(BusinessVo businessVO);
	public BusinessVo selectBusinessByBNumber(String number);
	public void updateService_time(String business_number);
	public List<BusinessVo> selectTimeNoNull(int num);
	public List<BusinessVo> selectTimeNull(int num);
	public int selectCount();
	public int selectNullCount();
	public int selectNoNullCount();
	public List<BusinessVo> selectCheckAllServicetime();
	public List<BusinessVo> selectCheckAllNoServicetime();
}
