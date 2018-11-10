package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EMS.model.dao.BusinessMapper;
import com.EMS.model.service.BusinessService;
import com.EMS.model.vo.BusinessVo;
@Service
@Transactional
public class BusinessServiceImpl implements BusinessService{
@Autowired
     private BusinessMapper  businessmapper; 
	/**
	 * ��ѯҵ����Ϣ
	 */
	public List<BusinessVo> selectBusinessAll() {
		return businessmapper.selectBusinessAll();
	}
/**
 * ����ҵ��������޸�ҵ����Ϣ
 */
	@Override
	public void updateBybusiness_number(BusinessVo housingProjectVo) {
		businessmapper.updateBybusiness_number(housingProjectVo);
	}
/**
 * ����ҵ�������ɾ��ҵ����Ϣ
 */
	@Override
	public void deleteBybusiness_number(String business_number) {
		businessmapper.deleteBybusiness_number(business_number);
	}
/**
 * ���ҵ����Ϣ
 */
	@Override
	public void saveBusiness(BusinessVo businessVO) {
		businessmapper.saveBusiness(businessVO);
	}
	@Override
	public BusinessVo selectBusinessByBNumber(String number) {
		return businessmapper.selectBusinessByBNumber(number);
		
	}
	/**
	 * �޸�����ʱ��
	 */
	@Override
	public void updateService_time(String business_number) {
		businessmapper.updateService_time(business_number);
		
	}
	@Override
	public List<BusinessVo> selectTimeNoNull(int num) {
		return businessmapper.selectTimeNoNull(num);
	}
	@Override
	public List<BusinessVo> selectTimeNull(int num) {
		return businessmapper.selectTimeNull(num);
	}
	@Override
	public int selectCount() {
		return businessmapper.selectCount();
	}
	@Override
	public int selectNullCount() {
		return businessmapper.selectNullCount();
	}
	@Override
	public int selectNoNullCount() {
		return businessmapper.selectNoNullCount();
	}
	@Override
	public List<BusinessVo> selectCheckAllServicetime() {
		// TODO Auto-generated method stub
		return businessmapper.selectCheckAllServicetime();
	}
	@Override
	public List<BusinessVo> selectCheckAllNoServicetime() {
		return businessmapper.selectCheckAllNoServicetime();
	}
}
