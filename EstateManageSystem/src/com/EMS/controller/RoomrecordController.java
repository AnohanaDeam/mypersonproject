package com.EMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EMS.model.service.RoomrecordService;
import com.EMS.model.vo.RoomrecordVo;

@Controller
public class RoomrecordController {

	@Autowired
	private RoomrecordService roomrecordService;
	
	
	@RequestMapping(value = "getInfoLike", method = RequestMethod.GET)
	public @ResponseBody List<RoomrecordVo> getInfoLike(String name) {
		List<RoomrecordVo> list = roomrecordService.selectForbusiness_number();
		return list;
	}
	
	@RequestMapping(value ="getInFoArea", method = RequestMethod.GET)
	public @ResponseBody List<RoomrecordVo> getInFoArea(String area) {
		List<RoomrecordVo> list = roomrecordService.selectForarea();
		return list;
	}
	
	@RequestMapping(value ="getInFoBuyer", method = RequestMethod.GET)
	public @ResponseBody List<RoomrecordVo> getInFoBuyer(String buyer) {
		List<RoomrecordVo> list = roomrecordService.selectForbuyer();
		return list;
	}
}
