package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.MtypeVo;
/**
 * ���ϱ������
 * @author JTXY
 *
 */
public interface MtypeService {
	/**
	 * ������в�����Ϣ
	 * @return
	 */
     public List<MtypeVo> selectAll();
     
     /**
      * �޸Ĳ���(Mtype)��
      */
 	public void updateByMaterial_type_number(MtypeVo housingProjectVo);
 	
 	/**
 	 * ɾ������(Mtype)����Ϣ
 	 */
 	public void deleteByMaterial_type_number(String Material_type_number);
 	/**
     * ���Ӳ���(Mtype)����Ϣ
     */
 	public void saveMtype(MtypeVo tb_m_type);
	
 	/**
 	 * ��ö�Ӧ����ID�Ĳ�����
 	 * @param Material_type_number
 	 * @return
 	 */
 	public MtypeVo selectMaterial_name(String Material_type_number);
}
