package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.FileMapper;
import com.EMS.model.service.FileService;
import com.EMS.model.vo.FileVo;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileMapper fileMapper;

	@Override
	public List<FileVo> selectAll() {
		
		return fileMapper.selectAll();
	}
	@Override
	public FileVo selectByBusiness_number(String business_number) {
			
			return fileMapper.selectByBusiness_number(business_number);
		}

	@Override
	public boolean updateByBusiness_number(FileVo fileVo) {
		
		return fileMapper.updateByBusiness_number(fileVo);
	}

	@Override
	public boolean deleteByBusiness_number(String business_number) {
		
		return fileMapper.deleteByBusiness_number(business_number);
	}

	@Override
	public void save(FileVo fileVo) {
		fileMapper.save(fileVo);

	}

	@Override
	public List<FileVo> selectForLike(String property_owner) {
		
		return fileMapper.selectForLike("%"+property_owner+"%");
	}

	@Override
	public List<FileVo> selectFornumber(String business_number) {
		
		return fileMapper.selectFornumber("%"+business_number+"%");
	}

	@Override
	public List<FileVo> selectFortype(String Business_types) {
		
		return fileMapper.selectFortype("%"+Business_types+"%");
	}

	@Override
	public FileVo selectbynumber(String number) {
		// TODO Auto-generated method stub
		return fileMapper.selectbynumber(number);
	}

}
