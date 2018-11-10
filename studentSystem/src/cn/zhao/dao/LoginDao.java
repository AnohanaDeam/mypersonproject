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
	 * ����½��Ϣ���˺�������ȷ
	 * @param loginEntity
	 * @return �鵽����1�����򷵻�0
	 */
	public int checkLogininfo(LoginEntity loginEntity) {
		String sql = "select Count(*) from login where account=? and password=?";
		return this.getJdbcTemplate().queryForObject(
				sql,new Object[] {loginEntity.getAccount(),loginEntity.getPassword()},
				Integer.class);
	}
	
	/**
	 * ��ȡ��½���е������Ϣ
	 * @param loginEntity
	 * @return ���
	 */
	public String getIdentity(LoginEntity loginEntity) {
		String sql = "select identity from login where account=? and password=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {loginEntity.getAccount(),loginEntity.getPassword()},
				String.class);
	}
}
