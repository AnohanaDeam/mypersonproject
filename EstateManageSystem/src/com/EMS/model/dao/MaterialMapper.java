package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.MaterialVo;
public interface MaterialMapper {
	public List<MaterialVo> selectAll();
	public boolean updateByMaterial_type_number(MaterialVo materialVo);
	public boolean deleteByMaterial_type_number(String material_type_number);
	public void save(MaterialVo materialVo);
	public List<MaterialVo> selectByBusiness_number(String Business_number);
}
