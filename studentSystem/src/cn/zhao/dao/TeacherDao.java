package cn.zhao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zhao.entity.TeacherEntity;
import cn.zhao.entity.VwCountOfSTTEntity;
import cn.zhao.entity.VwTeaToScoreEntity;
import cn.zhao.entity.vwCoMaToTeaEntity;

@Repository
public class TeacherDao extends JdbcDaoSupport{
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	/**
	 * 获取教师信息以教师ID的方式
	 * @param id
	 * @return
	 */
	public TeacherEntity getTeacherInfo(String id) {
		String sql = "select * from teacher where tea_id=?";
		return (TeacherEntity)this.getJdbcTemplate().queryForObject(
				sql, new Object[] {id}, new TeacherEntityRowMapper());
	}
	
	/**
	 * 获取教师表
	 * @return
	 */
	public List<TeacherEntity> gTeacherEntities(int a,int b) {
		String sql="SELECT * FROM (SELECT a.*, ROWNUM rn FROM teacher a) WHERE rn >= ? AND rn <= ?";
		return this.getJdbcTemplate().query(
				sql, new TeacherEntityRowMapper(),new Object[] {a,b});
	}
	/**
	 * 获取Tea_id的所授课程信息
	 * @param tea_id
	 * @return
	 */
	public List<vwCoMaToTeaEntity> getCoMaToTea(String tea_id) {
		String sql="select * from vwCoMaToTea where tea_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {tea_id},new vwCoMaToTeaRowMapper());
	}
	
	/**
	 * 获取所授课程的学生成绩
	 * @param tea_id
	 * @param cou_id
	 * @return
	 */
	public List<VwTeaToScoreEntity> getVwTeaToScore(String tea_id,String cou_id) {
		String sql="select * from VwTeaToScore where tea_id=? and cou_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {tea_id,cou_id},new VwTeaToScoreRowMapper());
	}
	
	/**
	 * 获取选某门课程的学生数
	 * @param tea_id
	 * @param cou_id
	 * @return
	 */
	public List<VwCountOfSTTEntity> getvwCountOfSTT(String tea_id) {
		String sql="select * from vwCountOfSTT where tea_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {tea_id},new VwCountOfSTTRowMapper());
	}
	
	/**
	 * 获取学生成绩 by stuid
	 * @param tea_id
	 * @param cou_id
	 * @return
	 */
	public List<VwTeaToScoreEntity> getVwTeaToScoreByS(String stuid) {
		String sql="select * from VwTeaToScore where stuid=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {stuid}, new VwTeaToScoreRowMapper());
	}
	
	/**
	 * 获取学生成绩 by cou_id
	 * @param cou_id
	 * @return
	 */
	public List<VwTeaToScoreEntity> getVwTeaToScoreByC(String cou_id) {
		String sql="select * from VwTeaToScore where cou_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {cou_id}, new VwTeaToScoreRowMapper());
	}
}

/**
 * vwCoMaToTea的rowMapper类实现
 * @author zhxn5
 *
 */
class vwCoMaToTeaRowMapper implements RowMapper<vwCoMaToTeaEntity>{

	public vwCoMaToTeaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		vwCoMaToTeaEntity vwCoMaToTeaEntity = new vwCoMaToTeaEntity();
		vwCoMaToTeaEntity.setBook_name(rs.getString("book_name"));
		vwCoMaToTeaEntity.setCou_id(rs.getString("cou_id"));
		vwCoMaToTeaEntity.setCou_name(rs.getString("cou_name"));
		vwCoMaToTeaEntity.setTea_id(rs.getString("tea_id"));
		vwCoMaToTeaEntity.setTea_name("tea_name");
		return vwCoMaToTeaEntity;
	}
}

/**
 * VwTeaToScore的RowMapper实现
 * @author zhxn5
 *
 */
class VwTeaToScoreRowMapper implements RowMapper<VwTeaToScoreEntity>{
	
	public VwTeaToScoreEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwTeaToScoreEntity vwTeaToScore=new VwTeaToScoreEntity();
		vwTeaToScore.setCou_name(rs.getString("Cou_name"));
		vwTeaToScore.setCou_id(rs.getString("cou_id"));
		vwTeaToScore.setSclass(rs.getString("class"));
		vwTeaToScore.setScores(rs.getInt("scores"));
		vwTeaToScore.setStu_name(rs.getString("stu_name"));
		vwTeaToScore.setStuid(rs.getString("stuid"));
		vwTeaToScore.setTea_id(rs.getString("tea_id"));
		vwTeaToScore.setTea_name(rs.getString("tea_name"));
		return vwTeaToScore;
	}
	
}

/**
 * VwCountOfSTT类的RowMapper实现
 * @author zhxn5
 *
 */
class VwCountOfSTTRowMapper implements RowMapper<VwCountOfSTTEntity>{

	@Override
	public VwCountOfSTTEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwCountOfSTTEntity vwCountOfSTT=new VwCountOfSTTEntity();
		vwCountOfSTT.setCou_id(rs.getString("cou_id"));
		vwCountOfSTT.setCou_name(rs.getString("cou_name"));
		vwCountOfSTT.setSnum(rs.getInt("snum"));
		vwCountOfSTT.setTea_id(rs.getString("tea_id"));
		vwCountOfSTT.setTea_name(rs.getString("tea_name"));
		return vwCountOfSTT;
	}
	
}

class TeacherEntityRowMapper implements RowMapper<TeacherEntity>{
	public TeacherEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeacherEntity teacherEntity = new TeacherEntity();
		teacherEntity.setTea_id(rs.getString("tea_id"));
		teacherEntity.setTea_name(rs.getString("tea_name"));
		teacherEntity.setPost(rs.getString("post"));
		teacherEntity.setAge(rs.getInt("age"));
		teacherEntity.setDepartment(rs.getString("department"));
		teacherEntity.setEmploy(rs.getInt("Employ"));
		return teacherEntity;
	}
	
}

