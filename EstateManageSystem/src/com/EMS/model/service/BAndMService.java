package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.BAndMVo;

/**
 * ҵ����Ϲ�ϵ������
 * @author JTXY
 *
 */
public interface BAndMService {
	/**
	 * ���ȫ��ҵ����Ϲ�ϵ��(BAndM)����
	 * @return
	 */
	public List<BAndMVo> selectAll();
	
	/**
	 * ����ҵ����Ϲ�ϵ��(BAndM)����
	 * @param BAndMVo
	 */
	public void updateByService_number(BAndMVo BAndMVo);
	
	/**
	 * ɾ��ҵ����Ϲ�ϵ��(BAndM)����
	 * @param BAndMVo
	 */
	public void deleteByService_number(String service_number);
	
	/**
	 * ���ҵ����Ϲ�ϵ��(BAndM)����
	 * @param BAndMVo
	 */
	public void save(BAndMVo b);
	
	/**
	 * ͨ��ҵ��Ż��bAndMVo
	 * @param bAndMVo
	 * @return
	 */
	public List<BAndMVo> selectBAndMVoByService(BAndMVo bAndMVo);
}
