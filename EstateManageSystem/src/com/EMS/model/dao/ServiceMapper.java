package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.ServiceVo;

public interface ServiceMapper {
	//全查询
	public List<ServiceVo> selectServiceAll();
	//更新
	public void updateByService_number(ServiceVo serviceVo);
	//删除
	public void deleteByService_number(String service_number);
	//插入
	public void saveService(ServiceVo serviceVo);
	//获得业务名
	public ServiceVo selectServiceName(ServiceVo serviceVo);
}
