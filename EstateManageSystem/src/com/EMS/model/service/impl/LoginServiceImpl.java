package com.EMS.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.LoginMapper;
import com.EMS.model.service.LoginsService;
import com.EMS.model.vo.LoginVo;
@Service
public class LoginServiceImpl implements LoginsService{
	@Autowired
     private LoginMapper loginmapper;

	public LoginVo login(LoginVo LoginVo) {
		// TODO Auto-generated method stub
		return loginmapper.login(LoginVo);
	}
	
}
