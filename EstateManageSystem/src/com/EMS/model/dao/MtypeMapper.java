package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.MtypeVo;

public interface MtypeMapper {
	
	public List<MtypeVo> selectMtypeAll();
	public void updateByMaterial_type_number(MtypeVo housingProjectVo);
	public void deleteByMaterial_type_number(String Material_type_number);
	public void saveMtype(MtypeVo tb_m_type);
	public MtypeVo selectMaterial_name(String Material_type_number);

}
