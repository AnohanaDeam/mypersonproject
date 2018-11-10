package com.EMS.model.service;

import com.EMS.model.vo.LoginVo;

public interface LoginsService {
	/**
	 * 验证用户账号密码
	 */
	public LoginVo login(LoginVo LoginVo);
}
