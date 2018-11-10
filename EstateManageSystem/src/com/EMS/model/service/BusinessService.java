package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.BusinessVo;

public interface BusinessService {
	/**
	 * ��ѯҵ����Ϣ
	 * @return
	 */
	public List<BusinessVo> selectBusinessAll();
	/**
	 * ����ҵ��������޸�ҵ��
	 * @param housingProjectVo
	 */
	public void updateBybusiness_number(BusinessVo housingProjectVo);
	/**
	 * ����ҵ�������ɾ��ҵ��
	 * @param business_number
	 */
	public void deleteBybusiness_number(String business_number);
	/**
	 * ���ҵ����Ϣ
	 * @param businessVO
	 */
	public void saveBusiness(BusinessVo businessVO);
	/**
	 * ͨ��ҵ��Ų���ҵ��
	 * @param business_number
	 * @return
	 */
	public BusinessVo selectBusinessByBNumber(String number);
	/**
	 * ����ҵ��Ÿ�������ʱ��
	 */
	public void updateService_time(String business_number);
	/**
	 * ��ѯ����ʱ�䲻Ϊ�յ�BusinessVo
	 * @param num �ӵ�num�������5��
	 * @return
	 */
	public List<BusinessVo> selectTimeNoNull(int num);
	/**
	 * ��ѯ����ʱ��Ϊ�յ�BusinessVo
	 * @param num �ӵ�num�������5��
	 * @return
	 */
	public List<BusinessVo> selectTimeNull(int num);
	
	/**
	 * ��ò�ѯ������
	 * @return
	 */
	public int selectCount();
	/**
	 * ��ѯ����ʱ��Ϊ�յ�����
	 * @return
	 */
	public int selectNullCount();
	/**
	 * ��ѯ����ʱ�䲻Ϊ�յ�����
	 * @return
	 */
	public int selectNoNullCount();
	public List<BusinessVo> selectCheckAllServicetime();
	public List<BusinessVo> selectCheckAllNoServicetime();

}
