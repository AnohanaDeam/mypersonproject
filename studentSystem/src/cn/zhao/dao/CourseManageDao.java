package cn.zhao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import cn.zhao.entity.CourseEntity;
import cn.zhao.entity.MaterialEntity;
import cn.zhao.entity.StuToCouEntity;
import cn.zhao.entity.TeaToCouEntity;
import cn.zhao.entity.VwStuToTeaEntity;
import cn.zhao.entity.VwTeaToCouEntity;

@Repository
public class CourseManageDao extends JdbcDaoSupport{
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	/**
	 * ��Course������ݣ��γ�
	 * @param courseEntity
	 */
	public String addToCourse(CourseEntity courseEntity) {
		String sql="insert into course values(seq_cou_id.nextval,?,?,?)";
		this.getJdbcTemplate().update(sql, courseEntity.getCou_name(),courseEntity.getCredit(),
				courseEntity.getMaterials());
		sql="select max(to_number(cou_id)) from zhao.course";
		return this.getJdbcTemplate().queryForObject(sql, String.class);
	}
	
	/**
	 * �޸Ŀγ�����
	 * @param courseEntity
	 */
	public void updateCourse(CourseEntity courseEntity) {
		String sql="update course set cou_name=?,credit=?,materials=? where cou_id=?";
		this.getJdbcTemplate().update(sql, 
				new Object[] {courseEntity.getCou_name(),courseEntity.getCredit(),
						courseEntity.getMaterials(),courseEntity.getCou_id()});
	}
	
	/**
	 * ɾ���γ�����
	 * @param cou_id
	 */
	public void deleteCourse(String cou_id) {
		String sql="delete from course where cou_id=?";
		this.getJdbcTemplate().update(sql, new Object[] {cou_id});
		sql="delete stutocou where cou_id=?";
		this.getJdbcTemplate().update(sql, new Object[] {cou_id});
	}
	/**
	 * ��ȡ�γ���Ϣ
	 * @param cou_id
	 * @return
	 */
	public CourseEntity getCourseInfo(String cou_id) {
		String sql="select * from course where cou_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {cou_id}, new CourseRowMapper());
	}
	
	/**
	 * ��ȡ�γ̱�
	 * @return
	 */
	public List<CourseEntity> gCourseEntities() {
		String sql="select * from course";
		return this.getJdbcTemplate().query(sql, new CourseRowMapper());
	}
	
	/**
	 * ��ȡVwTeaToCou tea_idΪ����
	 * @param tea_id
	 * @return
	 */
	public List<VwTeaToCouEntity> getVwTeaToCou(String tea_id) {
		String sql="select * from VwTeaToCou where tea_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {tea_id},new VwTeaToCouRowMapper());
	}
	
	/**
	 * ��ȡȫ��VwTeaToCou
	 * @param tea_id
	 * @return
	 */
	public List<VwTeaToCouEntity> getVwTeaToCouAll() {
		String sql="select * from VwTeaToCou";
		return this.getJdbcTemplate().query(
				sql,new VwTeaToCouRowMapper());
	}
	/**
	 * ��material������ݣ��̲�
	 * @param matertal
	 */
	public void addToMaterial(MaterialEntity material) {
		String sql="insert into material values(?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, material.getIsbn(),material.getAuthor(),
				material.getPrice(),material.getPublishing(),material.getBook_name());
	}
	
	/**
	 * �޸�material������
	 * @param material
	 */
	public void updateMaterial(MaterialEntity material) {
		String sql="update material set author=?,book_name=?,price=?,publishing=? where isbn=?";
		this.getJdbcTemplate().update(sql, 
				new Object[] {material.getAuthor(),material.getBook_name(),
						material.getPrice(),material.getPublishing(),material.getIsbn()});
	}
	
	/**
	 * ɾ���̲�
	 * @param isbn
	 */
	public void deleteMaterial(String isbn) {
		String sql="delete material where isbn=?";
		this.getJdbcTemplate().update(sql, new Object[] {isbn});
	}
	
	/**
	 * ��ȡ�̲���Ϣ
	 * @param ISBN �̲ı��
	 * @return
	 */
	public MaterialEntity getMaterialInfo(String ISBN) {
		String sql="select * from material where ISBN=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {ISBN}, new MaterialRowMapper());
	}
	
	/**
	 * ��ȡȫ���̲���Ϣ
	 * @param ISBN �̲ı��
	 * @return
	 */
	public List<MaterialEntity> getAllMaterial() {
		String sql="select * from material";
		return this.getJdbcTemplate().query(sql, new MaterialRowMapper());
	}
	
	/**
	 * ��TeaToCou��Ӷ�Ӧ��ϵ���γ̶�Ӧ��ʦ
	 * @param tea_id ��ʦID
	 * @param cou_id �γ�ID
	 */
	public void addToTeaToCou(String tea_id,String cou_id) {
		String sql="insert into TeaToCou values(?,?)";
		this.getJdbcTemplate().update(sql,tea_id,cou_id);
	}
	
	/**
	 * ����ʦID�ķ�ʽ��ȡ��Ӧ�γ���Ϣ
	 * @param tea_id
	 * @return
	 */
	public TeaToCouEntity getTeaToCouInfoByTID(String tea_id) {
		String sql="select * from TeaToCou where tea_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql,new Object[]{tea_id},new TeaToCouRowMapper());
	}
	
	/**
	 * �ÿγ�ID�ķ�ʽ��ȡ��Ӧ��ʦ��Ϣ
	 * @param tea_id
	 * @return
	 */
	public TeaToCouEntity getTeaToCouInfoByCID(String cou_id) {
		String sql="select * from TeaToCou where cou_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql,new Object[]{cou_id},new TeaToCouRowMapper());
	}
	
	/**
	 * ��tea_idΪKey��ѯVwStuToTea��ͼ
	 * @return
	 */
	public List<VwStuToTeaEntity> getVwStuToTeaByT(String tea_id) {
		String sql="Select * from VwStuToTea where tea_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {tea_id},new vwStuToTeaRowMapper());
	}
	/**
	 * ��stuidΪKey��ѯVwStuToTea��ͼ
	 * @return
	 */
	public List<VwStuToTeaEntity> getVwStuToTeaByS(String stuid) {
		String sql="Select * from VwStuToTea where stuid=?";
		return this.getJdbcTemplate().query(
				sql, new Object[] {stuid},new vwStuToTeaRowMapper());
	}
	
	/**
	 * ѧ�ҿγ̵�ѧ����
	 * @return
	 */
	public int getSelMyCouCount(String tea_id) {
		String sql="select count(*) from vwstutotea where tea_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {tea_id}, Integer.class);
	}
	
	/**
	 * �ҿγ̵Ŀγ���
	 * @return
	 */
	public int getMyCouCount(String tea_id) {
		String sql="select count(*) from vwteatocou where tea_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[] {tea_id}, Integer.class);
	}
	
	/**
	 * ��ȡ�γ̶�Ӧ�� ��CID
	 * @param cou_id
	 * @return
	 */
	public List<StuToCouEntity> getStuToCouByC(String cou_id) {
		String sql="select * from StuToCou where cou_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[]{cou_id}, new StuToCouRowMapper());
	}
	/**
	 * ��ȡ�γ̶�Ӧ�� ��SID
	 * @param cou_id
	 * @return
	 */
	public List<StuToCouEntity> getStuToCouByS(String stu_id) {
		String sql="select * from StuToCou where stu_id=?";
		return this.getJdbcTemplate().query(
				sql, new Object[]{stu_id}, new StuToCouRowMapper());
	}
	
	/**
	 * ��ȡѧ��ĳ�εĳɼ�
	 * @param cou_id
	 * @return
	 */
	public StuToCouEntity getStuToCouBySC(String stu_id,String cou_id) {
		String sql="select * from StuToCou where cou_id=? and stu_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, new Object[]{cou_id,stu_id}, new StuToCouRowMapper());
	}
	
	/**
	 * ��ÿγ���߷�
	 * @param cou_id
	 * @return
	 */
	public double getMaxScore(String cou_id) {
		String sql="select max(scores) from ZHAO.stutocou where cou_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, Double.class, new Object[]{cou_id});
	}
	
	/**
	 * ��ÿγ���ͷ�
	 * @param cou_id
	 * @return
	 */
	public double getMinScore(String cou_id) {
		String sql="select min(scores) from ZHAO.stutocou where cou_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, Double.class, new Object[]{cou_id});
	}
	
	/**
	 * ��ÿγ�ƽ����
	 * @param cou_id
	 * @return
	 */
	public double getAvgScore(String cou_id) {
		String sql="select avg(scores) from ZHAO.stutocou where cou_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, Double.class, new Object[]{cou_id});
	}
	
	/**
	 * ��÷���������
	 * @param cou_id
	 * @param a
	 * @param b
	 * @return
	 */
	public int getCountForFeil(String cou_id,String area) {
		String sql="select count(*) from ZHAO.stutocou where "+area+" and cou_id=?";
		return this.getJdbcTemplate().queryForObject(
				sql, Integer.class, new Object[]{cou_id});
	}
}


/**
 * StuToCou���RowMapperʵ��
 * @author zhxn5
 *
 */
class StuToCouRowMapper implements RowMapper<StuToCouEntity>{

	public StuToCouEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		StuToCouEntity stuToCouEntity = new StuToCouEntity();
		stuToCouEntity.setCou_id(rs.getString("cou_id"));
		stuToCouEntity.setScores(rs.getInt("scores"));
		stuToCouEntity.setStu_id(rs.getString("stu_id"));
		return stuToCouEntity;
	}
	
}
/**
 * MaterialEntity���RowMapperʵ��
 * @author zhxn5
 *
 */
class MaterialRowMapper implements RowMapper<MaterialEntity>{
	public MaterialEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		MaterialEntity materialEntity=new MaterialEntity();
		materialEntity.setAuthor(rs.getString("author"));
		materialEntity.setBook_name(rs.getString("book_name"));
		materialEntity.setIsbn(rs.getString("ISBN"));
		materialEntity.setPrice(rs.getInt("price"));
		materialEntity.setPublishing(rs.getString("publishing"));
		return materialEntity;
	}
}
/**
 * vwStuToTeaEntity���RowMapperʵ��
 * @author zhxn5
 *
 */
class vwStuToTeaRowMapper implements RowMapper<VwStuToTeaEntity>{
	public VwStuToTeaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwStuToTeaEntity vwStuToTeaEntity = new VwStuToTeaEntity();
		vwStuToTeaEntity.setCou_id(rs.getString("cou_id"));
		vwStuToTeaEntity.setCou_name(rs.getString("cou_name"));
		vwStuToTeaEntity.setStu_name(rs.getString("stu_name"));
		vwStuToTeaEntity.setStuid(rs.getString("Stuid"));
		vwStuToTeaEntity.setTea_id(rs.getString("tea_id"));
		vwStuToTeaEntity.setTea_name(rs.getString("tea_id"));
		return vwStuToTeaEntity;
	}
}

/**
 * TeaToCouEntity���RowMapperʵ��
 * @author zhxn5
 *
 */
class TeaToCouRowMapper implements RowMapper<TeaToCouEntity>{

	public TeaToCouEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		TeaToCouEntity teaToCouEntity = new TeaToCouEntity();
		teaToCouEntity.setTea_id(rs.getString("tea_id"));
		teaToCouEntity.setCou_id(rs.getString("cou_id"));
		return teaToCouEntity;
	}
}

/**
 * VwTeaToCou���RowMapperʵ��
 * @author zhxn5
 *
 */
class VwTeaToCouRowMapper implements RowMapper<VwTeaToCouEntity>{
	public VwTeaToCouEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VwTeaToCouEntity vwTeaToCouEntity=new VwTeaToCouEntity();
		vwTeaToCouEntity.setCou_id(rs.getString("cou_id"));
		vwTeaToCouEntity.setCou_name(rs.getString("cou_name"));
		vwTeaToCouEntity.setCredit(rs.getInt("credit"));
		vwTeaToCouEntity.setTea_id(rs.getString("tea_id"));
		vwTeaToCouEntity.setTea_name(rs.getString("tea_name"));
		return vwTeaToCouEntity;
	}
}

class CourseRowMapper implements RowMapper<CourseEntity>{
	public CourseEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCou_id(rs.getString("cou_id"));
		courseEntity.setCou_name(rs.getString("cou_name"));
		courseEntity.setCredit(rs.getDouble("credit"));
		courseEntity.setMaterials(rs.getString("materials"));
		return courseEntity;
	}
}




