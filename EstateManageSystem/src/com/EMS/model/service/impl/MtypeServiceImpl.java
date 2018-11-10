package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.MtypeMapper;
import com.EMS.model.service.MtypeService;
import com.EMS.model.vo.MtypeVo;
@Service
public class MtypeServiceImpl implements MtypeService{
	@Autowired
    private MtypeMapper mtypeMapper;
	@Override
	public List<MtypeVo> selectAll() {
		return mtypeMapper.selectMtypeAll();
	}

	@Override
	public void updateByMaterial_type_number(MtypeVo housingProjectVo) {
		// TODO Auto-generated method stub
		mtypeMapper.updateByMaterial_type_number(housingProjectVo);
	}

	@Override
	public void deleteByMaterial_type_number(String Material_type_number) {
		// TODO Auto-generated method stub
		mtypeMapper.deleteByMaterial_type_number(Material_type_number);
	}

	@Override
	public void saveMtype(MtypeVo tb_m_type) {
		// TODO Auto-generated method stub
		mtypeMapper.saveMtype(tb_m_type);
	}

	@Override
	public MtypeVo selectMaterial_name(String Material_type_number) {
		// TODO Auto-generated method stub
		return mtypeMapper.selectMaterial_name(Material_type_number);
	}

	
}
