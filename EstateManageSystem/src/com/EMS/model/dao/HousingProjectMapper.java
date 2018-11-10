package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.HousingProjectVo;

public interface HousingProjectMapper {
	 List<HousingProjectVo> selectAll();
	 boolean updateByItem_no(HousingProjectVo housingProjectVo);
	 boolean deleteByItem_no(String item_no);
     void save(HousingProjectVo housingProjectVo);
     HousingProjectVo selectByItem_no(String item_no);
}
