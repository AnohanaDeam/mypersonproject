package cn.zhao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zhao.entity.StuToCouEntity;
import cn.zhao.entity.StudentEntity;

@Repository
public class StudentDao extends JdbcDaoSupport  {
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	/**
	 * 获取一个学生的信息
	 * @param id 学生的ID
	 * @return 学生的信息
	 */
	public StudentEntity getStudentInfo(String id) {
		String sql = "select * from student where stuid=?";
		return (StudentEntity) this.getJdbcTemplate().queryForObject(
				sql, new Object[]{id},new StudentEntityRowMapper());
	}
		
	/**
	 * 获取一堆学生的信息
	 * @param id 学生的班级
	 * @return 学生的信息
	 */
	public List<StudentEntity> getStudentInfoByCl(String sclass) {
		String sql = "select * from student where class=?";
		return this.getJdbcTemplate().query(
				sql, new Object[]{sclass},new StudentEntityRowMapper());
	}
	
	/**
	 * 获取一段学生表
	 * @return
	 */
	public List<StudentEntity> gStudentEntities(int a,int b) {
		String sql="SELECT * FROM (SELECT a.*, ROWNUM rn FROM student a) WHERE rn >= ? AND rn <= ?";
		return this.getJdbcTemplate().query(
				sql, new StudentEntityRowMapper(),new Object[] {a,b});
	}
	
	/**
	 * 获得学生个数
	 * @return
	 */
	public int gCountStudents() {
		String sql="select count(*) from zhao.student";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	/**
	 * 添加学生课程关系
	 * @param cou_id
	 * @param stuid
	 */
	public void SelectCou(String cou_id,String stuid) {
		String sql="insert into stutocou values(?,?,?)";
		this.getJdbcTemplate().update(sql,stuid,cou_id,0);
	}
	
	/**
	 * 删除学生课程关系
	 * @param cou_id
	 * @param stuid
	 */
	public void DropCou(String cou_id,String stuid) {
		String sql="delete from stutocou where cou_id=? and stu_id=?";
		this.getJdbcTemplate().update(sql,cou_id,stuid);
	}
	
	/**
	 * 更新成绩
	 * @param stuToCouEntity
	 */
	public void updateScore(StuToCouEntity stuToCouEntity) {
		String sql="update stutocou set scores =? where cou_id = ? and stu_id=?";
		this.getJdbcTemplate().update(
				sql,stuToCouEntity.getScores(),
				stuToCouEntity.getCou_id(),
				stuToCouEntity.getStu_id());
	}
}
	
/**
 * StudentEntity类的RowMapper实现
 * @author zhxn5
 *
 */
class StudentEntityRowMapper implements RowMapper<StudentEntity>{

	public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setStuid(rs.getString("stuid"));
		studentEntity.setSex(rs.getString("sex"));
		studentEntity.setDepartment(rs.getString("department"));
		studentEntity.setAcademy(rs.getString("academy"));
		studentEntity.setClassM(rs.getString("class"));
		studentEntity.setTotalcredits(rs.getInt("totalcredits"));
		studentEntity.setGpa(rs.getInt("gpa"));
		studentEntity.setStu_name(rs.getString("stu_name"));
		return studentEntity;
	}
	
}
	
	
	
	
	
	
