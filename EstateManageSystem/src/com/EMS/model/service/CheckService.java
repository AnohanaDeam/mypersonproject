package com.EMS.model.service;

import java.util.List;
import java.util.Map;

import com.EMS.model.vo.CheckVo;
/**
 * 审核
 * @author 郭宵宵
 *
 */
public interface CheckService {
	/**
	 * 查询所有审核信息
	 */
	public List<CheckVo> selectCheckAll();
	
	/**
	 * 添加审核信息
	 */
	void save(CheckVo checkVo);
	
	/**
	 * 修改一审信息
	 */
	void updateByBusiness_number1(CheckVo checkVo);
	/**
	 * 修改二审信息
	 */
	void updateByBusiness_number2(CheckVo checkVo);
	/**
	 * 修改三审信息
	 */
	void updateByBusiness_number3(CheckVo checkVo);
    /**
     * 删除审核表
     * @param business_number
     */
	void deleteByBusiness_number(String business_number);
	public List<CheckVo> selectCheckAllByNumber(String number);
	public void addCheck(CheckVo CheckVo);
	public List<CheckVo> selectbyfirst(String a);
	public List<CheckVo> selectbyfirst2();
	public List<CheckVo> selectbySencond(String a);
	public CheckVo selectCheckByNumber(String a);
}
