package cn.zhao.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhao.dao.CommenDataDao;
import cn.zhao.dao.CourseManageDao;
import cn.zhao.dao.DataAddingDao;
import cn.zhao.dao.RegisterDao;
import cn.zhao.dao.StudentDao;
import cn.zhao.dao.TeacherDao;
import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.CourseEntity;
import cn.zhao.entity.DepartmentEntity;
import cn.zhao.entity.MaterialEntity;
import cn.zhao.entity.StudentEntity;
import cn.zhao.entity.TeacherEntity;

@Service
public class AdminService {
	
	@Autowired
	private CommenDataDao commenDataDao;
	
	@Autowired
	private DataAddingDao dataAddingDao;
	
	@Autowired
	private CourseManageDao courseManageDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	/**
	 * 添加学院信息
	 * @param academyEntity
	 */
	@Transactional
	public void addAcademy(AcademyEntity academyEntity) {
		dataAddingDao.addToAcademy(academyEntity);
	}
	/**
	 * 获得学院表
	 * @return
	 */
	public List<AcademyEntity> gAcademyEntities() {
		return commenDataDao.gAcademyEntities();
	}
	/**
	 * 修改学院信息
	 * @param academyEntity
	 */
	@Transactional
	public void updateAcademy(AcademyEntity academyEntity) {
		commenDataDao.updateAcademy(academyEntity);
	} 
	
	/**
	 * 删除学院信息
	 * @param aca_name
	 */
	@Transactional
	public void delectAcademy(String aca_name) {
		commenDataDao.delectAcademy(aca_name);
	}
	
	/**
	 * 添加系
	 * @param departmentEntity
	 */
	@Transactional
	public void addDepartment(DepartmentEntity departmentEntity) {
		dataAddingDao.addToDepartment(departmentEntity);
	}
	/**
	 * 获得系表
	 * @return
	 */
	public List<DepartmentEntity> gDepartmentEntities() {
		return commenDataDao.gDepartmentEntities();
	}
	
	/**
	 * 更新系信息
	 * @param departmentEntity
	 */
	@Transactional
	public void updateDepartment(DepartmentEntity departmentEntity) {
		commenDataDao.updateDepartment(departmentEntity);
	}
	
	/**
	 * 删除系
	 * @param dep_id
	 */
	@Transactional
	public void deleteDepartment(String dep_id) {
		commenDataDao.deleteDepartment(dep_id);
	}
	
	
	/**
	 * 向Course添加数据，课程
	 * @param courseEntity
	 */
	@Transactional
	public String addToCourse(CourseEntity courseEntity) {
		return courseManageDao.addToCourse(courseEntity);
	}
	
	/**
	 * 修改课程数据
	 * @param courseEntity
	 */
	@Transactional
	public void updateCourse(CourseEntity courseEntity) {
		courseManageDao.updateCourse(courseEntity);
	}
	
	/**
	 * 删除课程数据
	 * @param cou_id
	 */
	@Transactional
	public void deleteCourse(String cou_id) {
		courseManageDao.deleteCourse(cou_id);
	}
	
	/**
	 * 获取课程表
	 * @return
	 */
	public List<CourseEntity> gCourseEntities() {
		return courseManageDao.gCourseEntities();
	}
	
	/**
	 * 获取全部教材信息
	 * @return
	 */
	public List<MaterialEntity> getAllMaterial() {
		return courseManageDao.getAllMaterial();
	}
	
	/**
	 * 修改material的数据
	 * @param material
	 */
	@Transactional
	public void updateMaterial(MaterialEntity material) {
		courseManageDao.updateMaterial(material);
	}
	
	/**
	 * 删除教材
	 * @param isbn
	 */
	@Transactional
	public void deleteMaterial(String isbn) {
		courseManageDao.deleteMaterial(isbn);
	}
	
	/**
	 * 向material添加数据，教材
	 * @param matertal
	 */
	@Transactional
	public void addToMaterial(MaterialEntity material) {
		courseManageDao.addToMaterial(material);
	}
	
	/**
	 * 向Student表中添加数据
	 * @param studentEntity
	 */
	@Transactional
	public void addToStudent(StudentEntity studentEntity) {
		registerDao.addToStudent(studentEntity);
	}
	
	/**
	 * 获取学生表
	 * @return
	 */
	public List<StudentEntity> gStudentEntities(int a,int b) {
		return studentDao.gStudentEntities(a,b);
	}
	
	/**
	 * 修改学生信息
	 * @param studentEntity
	 */
	@Transactional
	public void updateStudent(StudentEntity studentEntity) {
		registerDao.updateStudent(studentEntity);
	}
	
	/**
	 * 删除学生信息
	 * @param stuid
	 */
	public void deleleStudent(String stuid) {
		registerDao.deleleStudent(stuid);
	}
	
	/**
	 * 获取教师表
	 * @return
	 */
	public List<TeacherEntity> gTeacherEntities(int a,int b) {
		return teacherDao.gTeacherEntities(a,b);
	}
	
	/**
	 * 修改教师数据
	 * @param teacherEntity
	 */
	@Transactional
	public void updateTeacher(TeacherEntity teacherEntity) {
		registerDao.updateTeacher(teacherEntity);
	}
	
	/**
	 * 删除教师数据
	 * @param tea_id
	 */
	@Transactional
	public void deleteTeacher(String tea_id) {
		registerDao.deleteTeacher(tea_id);
	}
	
	/**
	 * 向教师表内添加数据，教师注册
	 * @param teacherEntity
	 */
	@Transactional
	public void addToTeacher(TeacherEntity teacherEntity) {
		registerDao.addToTeacher(teacherEntity);
	}
}
	
	
	



