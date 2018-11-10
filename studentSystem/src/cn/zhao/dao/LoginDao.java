package cn.zhao.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zhao.entity.LoginEntity;

@Repository
public class LoginDao extends JdbcDaoSupport{
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	/**
	 * 检查登陆信息，账号密码正确
	 * @param loginEntity
	 * @return 查到返回1，否则返回0
	 */
	public int checkLogininfo(LoginEntity loginEntity) {
		String sql = "select Count(*) from login where account=? and password=?";
		return this.getJdbcTemplate().queryForObject(
				sql,new Object[] {loginEntity.getAccount(),loginEntity.getPassword()},
				Integer.class);
	}
	
	/**
	 * 获取登陆表中的身份信息
	 * @param loginEntity
	 * @return 身份
	 */
	public String getIdentity(LoginEntity loginEntity) {
		String sql = "select identity from login where account=? and password=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {loginEntity.getAccount(),loginEntity.getPassword()},
				String.class);
	}
}
