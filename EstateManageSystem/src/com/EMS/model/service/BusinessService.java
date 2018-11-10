package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.BusinessVo;

public interface BusinessService {
	/**
	 * 查询业务信息
	 * @return
	 */
	public List<BusinessVo> selectBusinessAll();
	/**
	 * 根据业务受理号修改业务
	 * @param housingProjectVo
	 */
	public void updateBybusiness_number(BusinessVo housingProjectVo);
	/**
	 * 根据业务受理号删除业务
	 * @param business_number
	 */
	public void deleteBybusiness_number(String business_number);
	/**
	 * 添加业务信息
	 * @param businessVO
	 */
	public void saveBusiness(BusinessVo businessVO);
	/**
	 * 通过业务号查找业务
	 * @param business_number
	 * @return
	 */
	public BusinessVo selectBusinessByBNumber(String number);
	/**
	 * 根据业务号更新受理时间
	 */
	public void updateService_time(String business_number);
	/**
	 * 查询受理时间不为空的BusinessVo
	 * @param num 从第num条往后查5条
	 * @return
	 */
	public List<BusinessVo> selectTimeNoNull(int num);
	/**
	 * 查询受理时间为空的BusinessVo
	 * @param num 从第num条往后查5条
	 * @return
	 */
	public List<BusinessVo> selectTimeNull(int num);
	
	/**
	 * 获得查询的条数
	 * @return
	 */
	public int selectCount();
	/**
	 * 查询受理时间为空的条数
	 * @return
	 */
	public int selectNullCount();
	/**
	 * 查询受理时间不为空的条数
	 * @return
	 */
	public int selectNoNullCount();
	public List<BusinessVo> selectCheckAllServicetime();
	public List<BusinessVo> selectCheckAllNoServicetime();

}
