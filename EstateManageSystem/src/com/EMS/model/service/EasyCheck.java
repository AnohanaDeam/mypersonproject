package com.EMS.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.BAndMMapper;
import com.EMS.model.dao.ServiceMapper;
import com.EMS.model.vo.BAndMVo;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.ServiceVo;

@Service
public class EasyCheck {
	
	@Autowired
	ServiceMapper serviceMapper;
	
	@Autowired
	BAndMMapper bAndMMapper;
	
	@Autowired
	MtypeService mtypeService;

	/**
	 * 通过f_service，和service_number获得ServiceVo对象
	 * @param f_service
	 * @param service_number
	 * @return ServiceVo
	 */
	public ServiceVo getServiceVo(String f_service,String service_number) {
		ServiceVo serviceVo = new ServiceVo();
		serviceVo.setF_service(f_service);
		serviceVo.setService_number(service_number);
		serviceVo = serviceMapper.selectServiceName(serviceVo);
		return serviceVo;
	}
	
	/**
	 * 通过f_service，和service_number获得BAndMVo对象
	 * @param f_service
	 * @param service_number
	 * @return List<BAndMVo>
	 */
	public List<BAndMVo> getBAndMVo(String f_service,String service_number){
		BAndMVo bAndMVo = new BAndMVo();
		bAndMVo.setF_service(f_service);
		bAndMVo.setService_number(service_number);
		List<BAndMVo> bAndMVos = bAndMMapper.selectBAndMVoByService(bAndMVo);
		for (BAndMVo bAndMVo2 : bAndMVos) {
			bAndMVo2.setMtypeVo(mtypeService.selectMaterial_name(bAndMVo2.getMaterial_number()));
		}
		return bAndMVos;
	}
	/**
	 *通过f_service，和service_number获得service_name
	 */
	public String getservice_number(String f_service,String service_number){
		BusinessVo business=new BusinessVo();
		ServiceVo serviceVo = new ServiceVo();
		serviceVo.setF_service(f_service);
		serviceVo.setService_number(service_number);
		serviceVo = serviceMapper.selectServiceName(serviceVo);
		business.setService_name(serviceVo.getService_name());
		return business.getService_name();
	}
}
