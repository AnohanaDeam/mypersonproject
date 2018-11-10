package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.HousingProjectVo;

/**
 * ��Ʒ����Ŀ���������
 * @author JTXY
 *
 */
public interface HousingProjectService {
	
	/**
	 * ��ѯ��Ʒ����Ŀ���� tb_HousingProjectVo��������
	 * @return
	 */
	List<HousingProjectVo> selectAll();
	
	/**
	 * �޸���Ʒ����Ŀ���� tb_HousingProjectVo��������
	 * @param housingProjectVo
	 * @return
	 */
	 boolean updateByItem_no(HousingProjectVo housingProjectVo);
	 
	 /**
	  * ɾ����Ʒ����Ŀ���� tb_HousingProjectVo��������
	  * @param item_no
	  * @return
	  */
	 boolean deleteByItem_no(String item_no);
	 
	 /**
	  * ������Ʒ����Ŀ���� tb_HousingProjectVo��������
	  * @param housingProjectVo
	  */
    void save(HousingProjectVo housingProjectVo);
    
    /**
     * ͨ��item_noѡ������Ŀ
     * @param item_no
     * @return
     */
    HousingProjectVo selectByItem_no(String item_no);
}
