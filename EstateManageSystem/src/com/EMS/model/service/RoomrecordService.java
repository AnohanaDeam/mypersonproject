package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.RoomrecordVo;

/**
 * �������ܽӿ�
 * @author JTXY
 * ʵ�ֵ�������ع���
 */
public interface RoomrecordService {
	/**
	 * ��ѯȫ������
	 */
	public List<RoomrecordVo> selectRoomrecordAll();
	/**
	 * ���±�����Ϣ
	 * @param roomrecordVo
	 */
	public void updateByNumber(RoomrecordVo roomrecordVo);
		/**
		 * ɾ��������Ϣ
		 * @param number
		 * @return
		 */
		public void deleteByNumber(String number);
		/**
		 * ��ӱ�����Ϣ
		 * @param roomrecordVo
		 * @return
		 */
		public void saveRoomrecord(RoomrecordVo roomrecordVo);
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
