package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.BAndMVo;

/**
 * 业务材料关系服务类
 * @author JTXY
 *
 */
public interface BAndMService {
	/**
	 * 获得全部业务材料关系表(BAndM)数据
	 * @return
	 */
	public List<BAndMVo> selectAll();
	
	/**
	 * 更改业务材料关系表(BAndM)数据
	 * @param BAndMVo
	 */
	public void updateByService_number(BAndMVo BAndMVo);
	
	/**
	 * 删除业务材料关系表(BAndM)数据
	 * @param BAndMVo
	 */
	public void deleteByService_number(String service_number);
	
	/**
	 * 添加业务材料关系表(BAndM)数据
	 * @param BAndMVo
	 */
	public void save(BAndMVo b);
	
	/**
	 * 通过业务号获得bAndMVo
	 * @param bAndMVo
	 * @return
	 */
	public List<BAndMVo> selectBAndMVoByService(BAndMVo bAndMVo);
}
