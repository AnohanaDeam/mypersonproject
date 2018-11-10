package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.RoomrecordVo;

public interface RoomrecordMapper {
	//全查询
	public List<RoomrecordVo> selectRoomrecordAll();
	//更新
	public void updateByNumber(RoomrecordVo roomrecordVo);
	//删除
	public void deleteByNumber(String number);
	//插入
	public boolean saveRoomrecord(RoomrecordVo roomrecordVo);
	/**
	 * 按买受人模糊查询获得备案
	 * @return
	 */
	List<RoomrecordVo> selectForbuyer();
	/**
	 * 按业务号模糊查询获得备案
	 * @return
	 */
	List<RoomrecordVo> selectForbusiness_number();
	/**
	 * 按面积模糊查询获得备案
	 * @return
	 */
	List<RoomrecordVo> selectForarea();
	public RoomrecordVo selectRoomrecordAllByNumber(String number);
	
	public void deleteByBusiness_number(String business_number);
}
