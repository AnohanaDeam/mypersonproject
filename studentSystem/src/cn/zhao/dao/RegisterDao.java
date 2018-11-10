package cn.zhao.dao;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import cn.zhao.entity.LoginEntity;
import cn.zhao.entity.StudentEntity;
import cn.zhao.entity.TeacherEntity;

@Repository
public class RegisterDao extends JdbcDaoSupport {
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	Calendar now = Calendar.getInstance();  
	/**
	 * ΪLogin���������
	 * @param userLogin
	 */
	public void addToLogin(LoginEntity loginEntity) {
		String sql="insert into login values(?,?,?)";
		this.getJdbcTemplate().update(sql, loginEntity.getAccount(),loginEntity.getIdentity(),
				loginEntity.getPassword());
	}
	
	/**
	 * ��Login����ɾ������
	 * @param account
	 */
	public void deleteLogin(String account) {
		String sql="delete login where account=?";
		this.getJdbcTemplate().update(sql, new Object[] {account});
	}
	
	/**
	 * �޸�����
	 * @param loginEntity
	 */
	public void updateLogin(LoginEntity loginEntity) {
		String sql="update login set password=? where account=?";
		this.getJdbcTemplate().update(sql, 
				new Object[] {loginEntity.getPassword(),loginEntity.getAccount()});
	}
	
	/**
	 * ��Student�����������
	 * @param studentEntity
	 */
	public void addToStudent(StudentEntity studentEntity) {
		//String sql = "select dep_id from department where dep_name = ?";
		//String depid=this.getJdbcTemplate().queryForObject(sql,new Object[] {studentEntity.getDepartment()},String.class);
		String id=now.get(Calendar.YEAR)+studentEntity.getDepartment();
		studentEntity.setStuid(id);
		String sql = "insert into student values(?||lpad(seq_stu_id.nextval,5,0),?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(sql,studentEntity.getStuid(),studentEntity.getSex(),
				studentEntity.getDepartment(),studentEntity.getAcademy(),
				studentEntity.getClassM(),studentEntity.getTotalcredits(),
				studentEntity.getGpa(),studentEntity.getStu_name());
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 * @param studentEntity
	 */
	public void updateStudent(StudentEntity studentEntity) {
		String sql="update student set sex=?,class=?,"
				+ "totalcredits=?,gpa=?,stu_name=? where stuid=?";
		this.getJdbcTemplate().update(sql, 
				new Object[] {studentEntity.getSex(),studentEntity.getClassM(),
						studentEntity.getTotalcredits(),studentEntity.getGpa(),
						studentEntity.getStu_name(),studentEntity.getStuid()});
	}
	
	/**
	 * ɾ��ѧ����Ϣ
	 * @param stuid
	 */
	public void deleleStudent(String stuid) {
		String sql="delete stutocou where stu_id=?";
		this.getJdbcTemplate().update(sql, new Object[] {stuid});
		sql="delete student where stuid=?";
		this.getJdbcTemplate().update(sql, new Object[] {stuid});
	}
	/**
	 * ���ʦ����������ݣ���ʦע��
	 * @param teacherEntity
	 */
	public void addToTeacher(TeacherEntity teacherEntity) {
		//String sql="select dep_id from department where dep_name = ?";
		//String depid=this.getJdbcTemplate().queryForObject(sql,new Object[] {teacherEntity.getDepartment()},String.class);
		String id="10"+teacherEntity.getDepartment();
		teacherEntity.setTea_id(id);
		String sql = "insert into teacher values(?||lpad(seq_tea_id.nextval,4,0),?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, teacherEntity.getTea_id(),teacherEntity.getTea_name(),
				teacherEntity.getPost(),teacherEntity.getAge(),teacherEntity.getDepartment(),
				teacherEntity.getEmploy());
	}
	
	/**
	 * �޸Ľ�ʦ����
	 * @param teacherEntity
	 */
	public void updateTeacher(TeacherEntity teacherEntity) {
		String sql="update teacher set tea_name=?,post=?,age=?,employ=? where tea_id=?";
		this.getJdbcTemplate().update(sql, 
				new Object[] {teacherEntity.getTea_name(),teacherEntity.getPost(),
						teacherEntity.getAge(),
						teacherEntity.getEmploy(),teacherEntity.getTea_id()});
	}
	
	/**
	 * ɾ����ʦ����
	 * @param tea_id
	 */
	public void deleteTeacher(String tea_id) {
		String sql="delete teatocou where tea_id=?";
		this.getJdbcTemplate().update(sql, new Object[] {tea_id});
		sql="delete teacher where tea_id=?";
		this.getJdbcTemplate().update(sql, new Object[] {tea_id});
	}
	/**
	 * ɨ��teacher��student��Ϊlogin�������
	 * ������
	 * @param userLogin
	 */
	public void addRadomToLogin() {
		//int k=10/0;
		LoginEntity loginEntity = new LoginEntity();
		String[] identity= {"teacher","student"};
		String[] id= {"tea_id","stuid"};
		String sql;
		for (int i = 0; i < id.length; i++) {
			sql = "select "+id[i]+" from "+identity[i];
			List<String> strings = this.getJdbcTemplate().queryForList(sql,String.class);
			for (String ted_id : strings) {
				loginEntity.setAccount(ted_id);
				loginEntity.setIdentity(identity[i]);
				loginEntity.setPassword("123456");
				addToLogin(loginEntity);
			}
		}
	}
	
}
