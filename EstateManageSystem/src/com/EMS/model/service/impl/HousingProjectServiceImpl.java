package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.HousingProjectMapper;
import com.EMS.model.service.HousingProjectService;
import com.EMS.model.vo.HousingProjectVo;

@Service
public class HousingProjectServiceImpl implements HousingProjectService {

	@Autowired
	private HousingProjectMapper housingProjectMapper;
	
	@Override
	public List<HousingProjectVo> selectAll() {
		
		return housingProjectMapper.selectAll();
	}

	@Override
	public boolean updateByItem_no(HousingProjectVo housingProjectVo) {
		
		return housingProjectMapper.updateByItem_no(housingProjectVo);
	}

	@Override
	public boolean deleteByItem_no(String item_no) {
		
		return housingProjectMapper.deleteByItem_no(item_no);
	}

	@Override
	public void save(HousingProjectVo housingProjectVo) {
		housingProjectMapper.save(housingProjectVo);

	}

	@Override
	public HousingProjectVo selectByItem_no(String item_no) {
		return housingProjectMapper.selectByItem_no(item_no);
	}

}
