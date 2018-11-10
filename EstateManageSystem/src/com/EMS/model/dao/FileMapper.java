package com.EMS.model.dao;

import java.util.List;
import com.EMS.model.vo.FileVo;

/**
 * µµ°¸´æ·Å±í
 * @author JTXY
 *
 */
public interface FileMapper {
	public  List<FileVo> selectAll();
	public  FileVo selectByBusiness_number(String business_number);
	boolean updateByBusiness_number(FileVo fileVo);
	boolean deleteByBusiness_number(String business_number);
	void save(FileVo fileVo);
	List<FileVo> selectForLike(String property_owner);
	List<FileVo> selectFornumber(String business_number);
	List<FileVo> selectFortype(String Business_types);
	FileVo selectbynumber(String number);
}
