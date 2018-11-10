package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.BAndMMapper;
import com.EMS.model.service.BAndMService;
import com.EMS.model.vo.BAndMVo;

@Service
public class BAndMServiceImpl implements BAndMService {

	@Autowired
	private BAndMMapper bAndMMapper;

	public List<BAndMVo> selectAll() {
		return bAndMMapper.selectAll();
	}

	@Override
	public void updateByService_number(BAndMVo BAndMVo) {
		bAndMMapper.updateByService_number(BAndMVo);
	}

	@Override
	public void deleteByService_number(String service_number) {
		bAndMMapper.deleteByService_number(service_number);
	}

	@Override
	public void save(BAndMVo b) {
		bAndMMapper.save(b);
	}

	@Override
	public List<BAndMVo> selectBAndMVoByService(BAndMVo bAndMVo) {
		return bAndMMapper.selectBAndMVoByService(bAndMVo);
	}

}
