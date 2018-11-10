package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.BAndMVo;

public interface BAndMMapper {
	public List<BAndMVo> selectAll();
	public void updateByService_number(BAndMVo BAndMVo);
	public void deleteByService_number(String service_number);
	public void save(BAndMVo b);
	public List<BAndMVo> selectBAndMVoByService(BAndMVo bAndMVo);
}
