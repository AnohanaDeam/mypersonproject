package cn.zhao.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhao.dao.LoginDao;
import cn.zhao.entity.LoginEntity;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	/**
	 * 登陆检查
	 * @param loginEntity
	 * @return 成功返回1，失败返回0
	 */
	public int login(LoginEntity loginEntity) {
		return loginDao.checkLogininfo(loginEntity);
	}
	
	/**
	 * 获取身份
	 * @param loginEntity
	 * @return 身份
	 */
	public String getIdentity(LoginEntity loginEntity) {
		return loginDao.getIdentity(loginEntity);
	}
}
