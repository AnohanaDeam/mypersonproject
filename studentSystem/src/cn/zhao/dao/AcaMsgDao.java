package cn.zhao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zhao.entity.VwAcademyDNumEntity;
import cn.zhao.entity.VwAcademyStuNumEntity;
import cn.zhao.entity.VwAcademyTeaNumEntity;
import cn.zhao.entity.VwDepartmentStuNum;
import cn.zhao.entity.VwDepartmentTeaNum;

@Repository
public class AcaMsgDao extends JdbcDaoSupport{
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	/**
	 * 获取学院系数量
	 * @return
	 */
	public List<VwAcademyDNumEntity> getVwAcademyDNum() {
		String sql="select * from VwAcademyDNum";
		return this.getJdbcTemplate().query(sql, new VwAcademyDNumRowMapper());
	}
	/**
	 * 获取学院学生数量
	 * @return
	 */
	public List<VwAcademyStuNumEntity> getVwAcademyStuNum() {
		String sql="select * from VwAcademyStuNum";
		return this.getJdbcTemplate().query(sql, new VwAcademyStuNumRowMapper());
	}
	/**
	 * 获取学院老师数量
	 * @return
	 */
	public List<VwAcademyTeaNumEntity> getVwAcademyTeaNum() {
		String sql="select * from VwAcademyTeaNum";
		return this.getJdbcTemplate().query(sql, new VwAcademyTeaNumRowMapper());
	}
	/**
	 * 获取该学院系学生数量
	 * @return
	 */
	public List<VwDepartmentStuNum> getVwDepartmentStuNum(String academy) {
		String sql="select * from VwDepartStuNum where academy=?";
		return this.getJdbcTemplate().query(
				sql,new Object[] {academy}, new VwDepartmentStuNumRowMapper());
	}
	
	/**
	 * 获取该学院系老师数量
	 * @return
	 */
	public List<VwDepartmentTeaNum> getVwDepartmentTeaNum(String academy) {
		String sql="select * from VwDepartTeaNum where academy=?";
		return this.getJdbcTemplate().query(
				sql,new Object[] {academy}, new VwDepartmentTeaNumRowMapper());
	}
	
	/**
	 * 获取所有学生数目
	 * @return
	 */
	public double getAllStuNum() {
		String sql="select count(*) from student";
		return this.getJdbcTemplate().queryForObject(sql, Double.class);
	}
	
	/**
	 * 获取所有老师数目
	 * @return
	 */
	public double getAllTeaNum() {
		String sql="select count(*) from teacher";
		return this.getJdbcTemplate().queryForObject(sql, Double.class);
	}
}


class VwAcademyDNumRowMapper implements RowMapper<VwAcademyDNumEntity>{

	public VwAcademyDNumEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwAcademyDNumEntity vwAcademyDNumEntity=new VwAcademyDNumEntity();
		vwAcademyDNumEntity.setAca_dean(rs.getString("aca_dean"));
		vwAcademyDNumEntity.setAca_name(rs.getString("Aca_name"));
		vwAcademyDNumEntity.setDepNum(rs.getDouble("DepNum"));
		return vwAcademyDNumEntity;
	}
}

class VwAcademyStuNumRowMapper implements RowMapper<VwAcademyStuNumEntity>{

	public VwAcademyStuNumEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwAcademyStuNumEntity vwAcademyDNumEntity=new VwAcademyStuNumEntity();
		vwAcademyDNumEntity.setAca_dean(rs.getString("aca_dean"));
		vwAcademyDNumEntity.setAca_name(rs.getString("Aca_name"));
		vwAcademyDNumEntity.setStu_num(rs.getDouble("Stu_num"));
		return vwAcademyDNumEntity;
	}
}

class VwAcademyTeaNumRowMapper implements RowMapper<VwAcademyTeaNumEntity>{

	public VwAcademyTeaNumEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwAcademyTeaNumEntity vwAcademyDNumEntity=new VwAcademyTeaNumEntity();
		vwAcademyDNumEntity.setAca_dean(rs.getString("aca_dean"));
		vwAcademyDNumEntity.setAca_name(rs.getString("Aca_name"));
		vwAcademyDNumEntity.setTeaa_num(rs.getDouble("tea_num"));
		return vwAcademyDNumEntity;
	}
}

class VwDepartmentStuNumRowMapper implements RowMapper<VwDepartmentStuNum>{

	public VwDepartmentStuNum mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwDepartmentStuNum vwDepartmentStuNum=new VwDepartmentStuNum();
		vwDepartmentStuNum.setDep_id(rs.getString("dep_id"));
		vwDepartmentStuNum.setDep_name(rs.getString("Dep_name"));
		vwDepartmentStuNum.setDep_phone(rs.getString("Dep_phone"));
		vwDepartmentStuNum.setStu_num(rs.getDouble("stu_num"));
		vwDepartmentStuNum.setAcademy(rs.getString("academy"));
		return vwDepartmentStuNum;
	}
	
}

class VwDepartmentTeaNumRowMapper implements RowMapper<VwDepartmentTeaNum>{

	public VwDepartmentTeaNum mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwDepartmentTeaNum vwDepartmentStuNum=new VwDepartmentTeaNum();
		vwDepartmentStuNum.setDep_id(rs.getString("dep_id"));
		vwDepartmentStuNum.setDep_name(rs.getString("Dep_name"));
		vwDepartmentStuNum.setDep_phone(rs.getString("Dep_phone"));
		vwDepartmentStuNum.setTea_num(rs.getDouble("tea_num"));
		vwDepartmentStuNum.setAcademy(rs.getString("academy"));
		return vwDepartmentStuNum;
	}
	
}







