package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.FileVo;

/**
 * 文书表服务类
 * @author JTXY
 *
 */
public interface FileService {
	
	/**
	 * 获得全部文书表(tb_file)数据
	 * @return
	 */
	public  List<FileVo> selectAll();
	/**
	 * 根据业务受理号获得文书信息
	 */
	 FileVo selectByBusiness_number(String business_number);
	/**
	 * 修改文书表(tb_file)数据
	 * @param fileVo
	 * @return
	 */
	boolean updateByBusiness_number(FileVo fileVo);
	
	/**
	 * 删除文书表(tb_file)数据
	 * @param business_number
	 * @return
	 */
	boolean deleteByBusiness_number(String business_number);
	
	/**
	 * 增加文书表tb_file表的数据
	 */
	void save(FileVo fileVo);
	
	/**
	 * 通过产权人模糊查询获得档案
	 * @return
	 */
	List<FileVo> selectForLike(String property_owner);
	
	/**
	 * 通过业务宗号模糊查询获得档案
	 * @return
	 */
	List<FileVo> selectFornumber(String business_number);
	
	/**
	 * 通过业务类型模糊查询获得档案 
	 * @return
	 */
	List<FileVo> selectFortype(String Business_types);

	FileVo selectbynumber(String number);
}
