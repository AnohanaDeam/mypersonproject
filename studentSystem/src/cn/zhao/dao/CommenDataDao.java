package cn.zhao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.DepartmentEntity;

@Repository
public class CommenDataDao extends JdbcDaoSupport{
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	/**
	 * 获得某个学院信息
	 * @param aca_name
	 * @return
	 */
	public AcademyEntity getAcademyInfo(String aca_name) {
		String sql = "select * from academy where aca_name=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {aca_name}, new AcademyRowMapper());
	}
	
	/**
	 * 获得学院表
	 * @return
	 */
	public List<AcademyEntity> gAcademyEntities() {
		String sql = "select * from academy";
		return this.getJdbcTemplate().query(sql, new AcademyRowMapper());
	}
	/**
	 * 更新学院信息
	 * @param academyEntity
	 */
	public void updateAcademy(AcademyEntity academyEntity) {
		String sql="update academy set aca_dean=?,deansex=? where aca_name=?";
		this.getJdbcTemplate().update(
				sql, new Object[] {academyEntity.getAca_dean(),
						academyEntity.getDeansex(),academyEntity.getAca_name()});
	}
	
	/**
	 * 删除学院信息
	 * @param aca_name
	 */
	public void delectAcademy(String aca_name) {
		String sql="delete from Academy where aca_name=?";
		this.getJdbcTemplate().update(sql,new Object[] {aca_name});
	}
	
	/**
	 * 获得某个系信息
	 * @param dep_id
	 * @return
	 */
	public DepartmentEntity getDepartmentInfo(String dep_id) {
		String sql = "select * from department where dep_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {dep_id}, new DepartMentRowMapper());
	}
	
	/**
	 * 获得系表
	 * @return
	 */
	public List<DepartmentEntity> gDepartmentEntities() {
		String sql="select * from department";
		return this.getJdbcTemplate().query(sql, new DepartMentRowMapper());
	}
	
	/**
	 * 修改系表
	 * @param departmentEntity
	 */
	public void updateDepartment(DepartmentEntity departmentEntity) {
		String sql="update Department set dep_name=?,dep_phone=? where dep_id=?";
		this.getJdbcTemplate().update(sql, 
				new Object[] {departmentEntity.getDep_name(),departmentEntity.getDep_phone(),
						departmentEntity.getDep_id()});
	}
	
	/**
	 * 删除系
	 * @param dep_id
	 */
	public void deleteDepartment(String dep_id) {
		String sql="delete from Department where dep_id=?";
		this.getJdbcTemplate().update(sql, new Object[] {dep_id});
	}
}

/**
 * Academy类的RowMapper实现
 * @author zhxn5
 *
 */
class AcademyRowMapper implements RowMapper<AcademyEntity>{
	public AcademyEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		AcademyEntity academyEntity = new AcademyEntity();
		academyEntity.setAca_name(rs.getString("aca_name"));
		academyEntity.setAca_dean(rs.getString("aca_dean"));
		academyEntity.setDeansex(rs.getString("deansex"));
		return academyEntity;
	}
}

/**
 * DepartMent类的RowMapper实现
 * @author zhxn5
 *
 */
class DepartMentRowMapper implements RowMapper<DepartmentEntity>{
	public DepartmentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setAcademy(rs.getString("academy"));
		departmentEntity.setDep_name(rs.getString("dep_name"));
		departmentEntity.setDep_phone(rs.getString("dep_phone"));
		departmentEntity.setDep_id(rs.getString("dep_id"));
		return departmentEntity;
	}
}




