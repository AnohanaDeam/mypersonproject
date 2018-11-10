package com.EMS.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EMS.model.service.BusinessService;
import com.EMS.model.service.HousingProjectService;
import com.EMS.model.service.RoomrecordService;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.HousingProjectVo;
import com.EMS.model.vo.RoomrecordVo;
import com.EMS.test.RandomValue;

@Controller
public class AnalogDataController {
	
	RandomValue randomValue = new RandomValue();
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	RoomrecordService roomrecordService;
	
	@Autowired
	HousingProjectService housingProjectService;
	
	/**
	 * 响应业务添加请求
	 * @param addNum
	 * @return
	 */
	@RequestMapping(value="/addBusiness",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addBusiness(int addNum) {
		Map<String, Object> msg = new HashMap<>();
		for (int i = 0; i < addNum; i++) {
			try {
				//获得随机的业务信息
				Map<String, Object> business = randomValue.getBusiness();
				//获得随机的房产信息
				Map<String, Object> house = randomValue.getHouse();
				//信息注入
				BusinessVo businessVo = new BusinessVo(
						business.get("business_number").toString(),
						business.get("name").toString(), 
						business.get("ID_number").toString(),
						business.get("tel").toString(), 
						business.get("f_service").toString(),
						business.get("service_number").toString(), 
						(Date)business.get("Service_time"));
				RoomrecordVo roomrecordVo = new RoomrecordVo(
						house.get("buildingNum").toString(),
						house.get("HouseNum").toString(), 
						house.get("Area").toString(),
						business.get("name").toString(), 
						business.get("business_number").toString(),
						randomValue.getNowTime(), 
						Double.parseDouble(house.get("total_price").toString()),
						house.get("payWay").toString(), 
						house.get("Booking_record").toString(),
						house.get("Mortgage_reg").toString(), 
						house.get("Mortgage_bank").toString(),
						getRandomItem().getItem_no(),
						getRandomItem().getAddress());
				System.out.println(roomrecordVo.toString());
				//数据库写入
				businessService.saveBusiness(businessVo);
				roomrecordService.saveRoomrecord(roomrecordVo);
				msg.put("msg", "添加成功");
			} catch (Exception e) {
				System.out.println(e);
				msg.put("msg", "添加失败");
			}
		}
		return msg;
	} 
	
	/**
	 * 获取随机项目号
	 * @return
	 */
	private HousingProjectVo getRandomItem() {
		List<HousingProjectVo> housingProjectVos = housingProjectService.selectAll();
		return housingProjectVos.get((int)(Math.random()*housingProjectVos.size()));
	}
}
