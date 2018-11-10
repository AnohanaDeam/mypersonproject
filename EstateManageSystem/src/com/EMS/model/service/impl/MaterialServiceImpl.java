package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.MaterialMapper;
import com.EMS.model.service.MaterialService;
import com.EMS.model.vo.MaterialVo;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired 
	private MaterialMapper materialMapper;
	private String material_type_number;
	
	@Override
	public List<MaterialVo> selectAll() {
		
		return materialMapper.selectAll();
	}

	@Override
	public boolean updateByMaterial_type_number(MaterialVo materialVo) {
		
		return materialMapper.deleteByMaterial_type_number(material_type_number);
	}

	@Override
	public boolean deleteByMaterial_type_number(String material_type_number) {
		
		return materialMapper.deleteByMaterial_type_number(material_type_number);
	}

	@Override
	public void save(MaterialVo materialVo) {
		materialMapper.save(materialVo);

	}

	@Override
	public List<MaterialVo> selectByBusiness_number(String Business_number) {
		return materialMapper.selectByBusiness_number(Business_number);
	}

}
