package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.MtypeVo;
/**
 * 材料表服务类
 * @author JTXY
 *
 */
public interface MtypeService {
	/**
	 * 获得所有材料信息
	 * @return
	 */
     public List<MtypeVo> selectAll();
     
     /**
      * 修改材料(Mtype)表
      */
 	public void updateByMaterial_type_number(MtypeVo housingProjectVo);
 	
 	/**
 	 * 删除材料(Mtype)表信息
 	 */
 	public void deleteByMaterial_type_number(String Material_type_number);
 	/**
     * 增加材料(Mtype)表信息
     */
 	public void saveMtype(MtypeVo tb_m_type);
	
 	/**
 	 * 获得对应材料ID的材料名
 	 * @param Material_type_number
 	 * @return
 	 */
 	public MtypeVo selectMaterial_name(String Material_type_number);
}
