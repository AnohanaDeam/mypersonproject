package cn.zhao.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.DepartmentEntity;

@Repository
public class DataAddingDao extends JdbcDaoSupport{
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	/**
	 * ��academy����������ݣ�ѧԺ
	 * @param academyEntity
	 */
	public void addToAcademy(AcademyEntity academyEntity) {
		String sql="insert into academy values(?,?,?)";
		this.getJdbcTemplate().update(sql, academyEntity.getAca_name(),
				academyEntity.getAca_dean(),academyEntity.getDeansex());
	}
		
	/**
	 * ��department��������ݣ�ϵ
	 * @param departmentEntity
	 */
	public void addToDepartment(DepartmentEntity departmentEntity) {
		String sql="insert into department values(?,?,?,?)";
		this.getJdbcTemplate().update(sql, departmentEntity.getDep_name(),departmentEntity.getDep_phone(),
				departmentEntity.getAcademy(),departmentEntity.getDep_id());
	}
}
