package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.RoomrecordVo;

/**
 * 备案功能接口
 * @author JTXY
 * 实现档案馆相关功能
 */
public interface RoomrecordService {
	/**
	 * 查询全部备案
	 */
	public List<RoomrecordVo> selectRoomrecordAll();
	/**
	 * 更新备案信息
	 * @param roomrecordVo
	 */
	public void updateByNumber(RoomrecordVo roomrecordVo);
		/**
		 * 删除备案信息
		 * @param number
		 * @return
		 */
		public void deleteByNumber(String number);
		/**
		 * 添加备案信息
		 * @param roomrecordVo
		 * @return
		 */
		public void saveRoomrecord(RoomrecordVo roomrecordVo);
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
