package com.EMS.model.dao;

import java.util.List;
import java.util.Map;

import com.EMS.model.vo.BAndMVo;
import com.EMS.model.vo.CheckVo;

public interface CheckMapper {
	public List<CheckVo> selectCheckAll();
	public void save(CheckVo CheckVo);
	public void updateByBusiness_number1(CheckVo CheckVo);
	public void updateByBusiness_number2(CheckVo CheckVo);
	public void updateByBusiness_number3(CheckVo CheckVo);
	public void deleteByBusiness_number(String business_number);
	public List<CheckVo> selectCheckAllByNumber(String number);
	public void addCheck(CheckVo CheckVo);
	public List<CheckVo> selectbyfirst(String a);
	public List<CheckVo> selectbyfirst2();
	public List<CheckVo> selectbySencond(String a);
	public CheckVo selectCheckByNumber(String a);
}
