package com.EMS.model.service;

import java.util.List;
import java.util.Map;

import com.EMS.model.vo.CheckVo;
/**
 * ���
 * @author ������
 *
 */
public interface CheckService {
	/**
	 * ��ѯ���������Ϣ
	 */
	public List<CheckVo> selectCheckAll();
	
	/**
	 * ��������Ϣ
	 */
	void save(CheckVo checkVo);
	
	/**
	 * �޸�һ����Ϣ
	 */
	void updateByBusiness_number1(CheckVo checkVo);
	/**
	 * �޸Ķ�����Ϣ
	 */
	void updateByBusiness_number2(CheckVo checkVo);
	/**
	 * �޸�������Ϣ
	 */
	void updateByBusiness_number3(CheckVo checkVo);
    /**
     * ɾ����˱�
     * @param business_number
     */
	void deleteByBusiness_number(String business_number);
	public List<CheckVo> selectCheckAllByNumber(String number);
	public void addCheck(CheckVo CheckVo);
	public List<CheckVo> selectbyfirst(String a);
	public List<CheckVo> selectbyfirst2();
	public List<CheckVo> selectbySencond(String a);
	public CheckVo selectCheckByNumber(String a);
}
