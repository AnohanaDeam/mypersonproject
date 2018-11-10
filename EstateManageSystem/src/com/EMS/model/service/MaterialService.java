package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.MaterialVo;

/**
 * 材料表服务类
 * @author JTXY
 *
 */
public interface MaterialService {
	
	/**
	 * 查询材料表（tb_Material）的数据
	 * @return
	 */
	List<MaterialVo> selectAll();
	
	/**
	 * 修改材料表（tb_Material）的数据
	 * @param materialVo
	 * @return
	 */
	 boolean updateByMaterial_type_number(MaterialVo materialVo);
	 
	 /**
	  * 删除材料表（tb_Material）的数据
	  * @param material_type_number
	  * @return
	  */
	 boolean deleteByMaterial_type_number(String material_type_number);
	 
	 /**
	  * 增加材料表（tb_Material）的数据
	  * @param materialVo
	  */
    void save(MaterialVo materialVo);
    
    /**
     * 通过Business_number获得材料表数据
     * @param Business_number
     * @return
     */
    public List<MaterialVo> selectByBusiness_number(String Business_number);
}
