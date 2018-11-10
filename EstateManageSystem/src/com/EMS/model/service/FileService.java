package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.FileVo;

/**
 * ����������
 * @author JTXY
 *
 */
public interface FileService {
	
	/**
	 * ���ȫ�������(tb_file)����
	 * @return
	 */
	public  List<FileVo> selectAll();
	/**
	 * ����ҵ������Ż��������Ϣ
	 */
	 FileVo selectByBusiness_number(String business_number);
	/**
	 * �޸������(tb_file)����
	 * @param fileVo
	 * @return
	 */
	boolean updateByBusiness_number(FileVo fileVo);
	
	/**
	 * ɾ�������(tb_file)����
	 * @param business_number
	 * @return
	 */
	boolean deleteByBusiness_number(String business_number);
	
	/**
	 * ���������tb_file�������
	 */
	void save(FileVo fileVo);
	
	/**
	 * ͨ����Ȩ��ģ����ѯ��õ���
	 * @return
	 */
	List<FileVo> selectForLike(String property_owner);
	
	/**
	 * ͨ��ҵ���ں�ģ����ѯ��õ���
	 * @return
	 */
	List<FileVo> selectFornumber(String business_number);
	
	/**
	 * ͨ��ҵ������ģ����ѯ��õ��� 
	 * @return
	 */
	List<FileVo> selectFortype(String Business_types);

	FileVo selectbynumber(String number);
}
