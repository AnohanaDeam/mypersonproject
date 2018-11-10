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
	 * ��½���
	 * @param loginEntity
	 * @return �ɹ�����1��ʧ�ܷ���0
	 */
	public int login(LoginEntity loginEntity) {
		return loginDao.checkLogininfo(loginEntity);
	}
	
	/**
	 * ��ȡ���
	 * @param loginEntity
	 * @return ���
	 */
	public String getIdentity(LoginEntity loginEntity) {
		return loginDao.getIdentity(loginEntity);
	}
}
