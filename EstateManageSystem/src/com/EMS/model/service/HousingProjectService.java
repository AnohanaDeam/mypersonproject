package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.HousingProjectVo;

/**
 * 商品房项目房表服务类
 * @author JTXY
 *
 */
public interface HousingProjectService {
	
	/**
	 * 查询商品房项目房表（ tb_HousingProjectVo）的数据
	 * @return
	 */
	List<HousingProjectVo> selectAll();
	
	/**
	 * 修改商品房项目房表（ tb_HousingProjectVo）的数据
	 * @param housingProjectVo
	 * @return
	 */
	 boolean updateByItem_no(HousingProjectVo housingProjectVo);
	 
	 /**
	  * 删除商品房项目房表（ tb_HousingProjectVo）的数据
	  * @param item_no
	  * @return
	  */
	 boolean deleteByItem_no(String item_no);
	 
	 /**
	  * 增加商品房项目房表（ tb_HousingProjectVo）的数据
	  * @param housingProjectVo
	  */
    void save(HousingProjectVo housingProjectVo);
    
    /**
     * 通过item_no选择房屋项目
     * @param item_no
     * @return
     */
    HousingProjectVo selectByItem_no(String item_no);
}
