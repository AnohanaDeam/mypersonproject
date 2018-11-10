package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.MaterialVo;

/**
 * ���ϱ������
 * @author JTXY
 *
 */
public interface MaterialService {
	
	/**
	 * ��ѯ���ϱ�tb_Material��������
	 * @return
	 */
	List<MaterialVo> selectAll();
	
	/**
	 * �޸Ĳ��ϱ�tb_Material��������
	 * @param materialVo
	 * @return
	 */
	 boolean updateByMaterial_type_number(MaterialVo materialVo);
	 
	 /**
	  * ɾ�����ϱ�tb_Material��������
	  * @param material_type_number
	  * @return
	  */
	 boolean deleteByMaterial_type_number(String material_type_number);
	 
	 /**
	  * ���Ӳ��ϱ�tb_Material��������
	  * @param materialVo
	  */
    void save(MaterialVo materialVo);
    
    /**
     * ͨ��Business_number��ò��ϱ�����
     * @param Business_number
     * @return
     */
    public List<MaterialVo> selectByBusiness_number(String Business_number);
}
