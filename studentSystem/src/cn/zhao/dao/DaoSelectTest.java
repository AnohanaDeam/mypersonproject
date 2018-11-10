package cn.zhao.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import cn.zhao.entity.LoginEntity;;
public class DaoSelectTest {
	ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("bean.xml");
	@Test
	/**
	 * �������Ե���ʦ:10009010633 ,123456
	 * �������Ե�ѧ��:
	 */
	public void login() {
		LoginEntity loginEntity=new LoginEntity(
				"10009010633","teacher","123456");
		LoginDao loginDao = (LoginDao)applicationContext.getBean("loginDao");
		System.out.println(loginDao.checkLogininfo(loginEntity));
	}
	
	@Test
	public void getStudentInfo() {
		StudentDao studentInfo=(StudentDao)applicationContext.getBean("studentInfo");
		try {
			System.out.println(studentInfo.getStudentInfo("20170010200002"));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("��������Ϊ��");
		}
	}
}
