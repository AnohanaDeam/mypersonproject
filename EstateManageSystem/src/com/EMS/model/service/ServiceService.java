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
 * ҵ�����
 * 
 * @author JTXY
 *
 */
public interface ServiceService {

	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<ServiceVo> selectServiceAll();
	/**
	 * ����
	 * @param serviceVo
	 */
	public void updateByService_number(ServiceVo serviceVo);
	/**
	 * ɾ��
	 * @param service_number
	 */
	public void deleteByService_number(String service_number);
	/**
	 * ����
	 * @param serviceVo
	 */
	public void saveService(ServiceVo serviceVo);
	
	/**
	 * ���ҵ����
	 * @param serviceVo
	 * @return
	 */
	public ServiceVo selectServiceName(ServiceVo serviceVo);
	
}
