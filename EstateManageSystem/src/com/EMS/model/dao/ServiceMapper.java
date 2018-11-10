package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.ServiceVo;

public interface ServiceMapper {
	//ȫ��ѯ
	public List<ServiceVo> selectServiceAll();
	//����
	public void updateByService_number(ServiceVo serviceVo);
	//ɾ��
	public void deleteByService_number(String service_number);
	//����
	public void saveService(ServiceVo serviceVo);
	//���ҵ����
	public ServiceVo selectServiceName(ServiceVo serviceVo);
}
