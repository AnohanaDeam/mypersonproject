package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.RoomrecordVo;

public interface RoomrecordMapper {
	//ȫ��ѯ
	public List<RoomrecordVo> selectRoomrecordAll();
	//����
	public void updateByNumber(RoomrecordVo roomrecordVo);
	//ɾ��
	public void deleteByNumber(String number);
	//����
	public boolean saveRoomrecord(RoomrecordVo roomrecordVo);
	/**
	 * ��������ģ����ѯ��ñ���
	 * @return
	 */
	List<RoomrecordVo> selectForbuyer();
	/**
	 * ��ҵ���ģ����ѯ��ñ���
	 * @return
	 */
	List<RoomrecordVo> selectForbusiness_number();
	/**
	 * �����ģ����ѯ��ñ���
	 * @return
	 */
	List<RoomrecordVo> selectForarea();
	public RoomrecordVo selectRoomrecordAllByNumber(String number);
	
	public void deleteByBusiness_number(String business_number);
}
