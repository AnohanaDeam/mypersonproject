package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.BAndMMapper;
import com.EMS.model.dao.BusinessMapper;

import com.EMS.model.dao.MaterialMapper;
import com.EMS.model.dao.MtypeMapper;
import com.EMS.model.dao.ServiceMapper;
import com.EMS.model.service.ServiceService;
import com.EMS.model.vo.BAndMVo;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.MaterialVo;
import com.EMS.model.vo.MtypeVo;
import com.EMS.model.vo.ServiceVo;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceMapper serviceMapper;
	@Override
	public List<ServiceVo> selectServiceAll() {
		return serviceMapper.selectServiceAll();
	}

	@Override
	public void updateByService_number(ServiceVo serviceVo) {
		serviceMapper.updateByService_number(serviceVo);
	}

	@Override
	public void deleteByService_number(String service_number) {
		serviceMapper.deleteByService_number(service_number);
	}

	@Override
	public void saveService(ServiceVo serviceVo) {
		serviceMapper.saveService(serviceVo);
	}

	@Override
	public ServiceVo selectServiceName(ServiceVo serviceVo) {
		return serviceMapper.selectServiceName(serviceVo);
	}
	
}
