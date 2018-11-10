package com.EMS.model.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.CheckMapper;
import com.EMS.model.service.CheckService;
import com.EMS.model.vo.CheckVo;

@Service
public class CheckServiceImpl implements CheckService {
	@Autowired
	private CheckMapper checkMapper;
	/**
	 * 查看三审表
	 */
	@Override
	public List<CheckVo> selectCheckAll() {
		// TODO Auto-generated method stub
		return checkMapper.selectCheckAll();
	}
	/**
	 * 添加审核信息
	 */
	@Override
	public void save(CheckVo checkVo) {
		// TODO Auto-generated method stub
		checkMapper.save(checkVo);
		
	}
	/**
	 * 修改三审表，修改一审信息
	 */
	@Override
	public void updateByBusiness_number1(CheckVo checkVo) {
		// TODO Auto-generated method stub
		checkMapper.updateByBusiness_number1(checkVo);
		
	}
	/**
	 * 修改二审信息
	 */
	@Override
	public void updateByBusiness_number2(CheckVo checkVo) {
		// TODO Auto-generated method stub
		checkMapper.updateByBusiness_number2(checkVo);
	}
	/**
	 * 修改三审信息
	 */
	@Override
	public void updateByBusiness_number3(CheckVo checkVo) {
		// TODO Auto-generated method stub
		checkMapper.updateByBusiness_number3(checkVo);
		
	}
	/**
	 * 删除审核信息
	 */
	@Override
	public void deleteByBusiness_number(String Business_number) {
		// TODO Auto-generated method stub
		checkMapper.deleteByBusiness_number(Business_number);
	}
	@Override
	public List<CheckVo> selectCheckAllByNumber(String number) {
		// TODO Auto-generated method stub
		return checkMapper.selectCheckAllByNumber(number);
	}
	@Override
	public void addCheck(CheckVo CheckVo) {
		checkMapper.addCheck(CheckVo);
		
	}
	@Override
	public List<CheckVo> selectbyfirst(String a) {
		// TODO Auto-generated method stub
		return checkMapper.selectbyfirst(a);
	}
	@Override
	public List<CheckVo> selectbySencond(String a) {
		// TODO Auto-generated method stub
		return checkMapper.selectbySencond(a);
	}
	@Override
	public List<CheckVo> selectbyfirst2() {
		// TODO Auto-generated method stub
		return checkMapper.selectbyfirst2();
	}
	@Override
	public CheckVo selectCheckByNumber(String a) {
		// TODO Auto-generated method stub
		return checkMapper.selectCheckByNumber(a);
	}
	
}

