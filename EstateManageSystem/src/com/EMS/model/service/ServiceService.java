package com.EMS.model.service;

import java.util.List;

import com.EMS.model.dao.BAndMMapper;
import com.EMS.model.dao.BusinessMapper;
import com.EMS.model.vo.BAndMVo;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.CheckVo;
import com.EMS.model.vo.MaterialVo;
import com.EMS.model.vo.MtypeVo;
import com.EMS.model.vo.ServiceVo;

/**
 * 业务服务
 * 
 * @author JTXY
 *
 */
public interface ServiceService {

	/**
	 * 全查询
	 * @return
	 */
	public List<ServiceVo> selectServiceAll();
	/**
	 * 更新
	 * @param serviceVo
	 */
	public void updateByService_number(ServiceVo serviceVo);
	/**
	 * 删除
	 * @param service_number
	 */
	public void deleteByService_number(String service_number);
	/**
	 * 插入
	 * @param serviceVo
	 */
	public void saveService(ServiceVo serviceVo);
	
	/**
	 * 获得业务名
	 * @param serviceVo
	 * @return
	 */
	public ServiceVo selectServiceName(ServiceVo serviceVo);
	
}
