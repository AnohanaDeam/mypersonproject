package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EMS.model.dao.RoomrecordMapper;
import com.EMS.model.service.RoomrecordService;
import com.EMS.model.vo.RoomrecordVo;
@Service
@Transactional
public class RoomrecordServiceImpl implements RoomrecordService{
	@Autowired
	private RoomrecordMapper roomrecordMaaper;
	@Override
	public List<RoomrecordVo> selectRoomrecordAll() {
		return roomrecordMaaper.selectRoomrecordAll();
	}

	@Override
	public void updateByNumber(RoomrecordVo roomrecordVo) {
		// TODO Auto-generated method stub
		roomrecordMaaper.updateByNumber(roomrecordVo);
	}

	@Override
	public void deleteByNumber(String number) {
		// TODO Auto-generated method stub
		roomrecordMaaper.deleteByNumber(number);
	}

	@Override
	public void saveRoomrecord(RoomrecordVo roomrecordVo) {
		// TODO Auto-generated method stub
		roomrecordMaaper.saveRoomrecord(roomrecordVo);
	}

	@Override
	public List<RoomrecordVo> selectForbuyer() {
		// TODO Auto-generated method stub
		return roomrecordMaaper.selectForbuyer();
	}

	@Override
	public List<RoomrecordVo> selectForbusiness_number() {
		// TODO Auto-generated method stub
		return roomrecordMaaper.selectForbusiness_number();
	}

	@Override
	public List<RoomrecordVo> selectForarea() {
		// TODO Auto-generated method stub
		return roomrecordMaaper.selectForarea();
	}

	@Override
	public RoomrecordVo selectRoomrecordAllByNumber(String number) {
		// TODO Auto-generated method stub
		return 	roomrecordMaaper.selectRoomrecordAllByNumber(number);
	}
	
	public void deleteByBusiness_number(String business_number){
		roomrecordMaaper.deleteByBusiness_number(business_number);
	}
	
}
