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
	 * ���ѧԺ��Ϣ
	 * @param academyEntity
	 */
	@Transactional
	public void addAcademy(AcademyEntity academyEntity) {
		dataAddingDao.addToAcademy(academyEntity);
	}
	/**
	 * ���ѧԺ��
	 * @return
	 */
	public List<AcademyEntity> gAcademyEntities() {
		return commenDataDao.gAcademyEntities();
	}
	/**
	 * �޸�ѧԺ��Ϣ
	 * @param academyEntity
	 */
	@Transactional
	public void updateAcademy(AcademyEntity academyEntity) {
		commenDataDao.updateAcademy(academyEntity);
	} 
	
	/**
	 * ɾ��ѧԺ��Ϣ
	 * @param aca_name
	 */
	@Transactional
	public void delectAcademy(String aca_name) {
		commenDataDao.delectAcademy(aca_name);
	}
	
	/**
	 * ���ϵ
	 * @param departmentEntity
	 */
	@Transactional
	public void addDepartment(DepartmentEntity departmentEntity) {
		dataAddingDao.addToDepartment(departmentEntity);
	}
	/**
	 * ���ϵ��
	 * @return
	 */
	public List<DepartmentEntity> gDepartmentEntities() {
		return commenDataDao.gDepartmentEntities();
	}
	
	/**
	 * ����ϵ��Ϣ
	 * @param departmentEntity
	 */
	@Transactional
	public void updateDepartment(DepartmentEntity departmentEntity) {
		commenDataDao.updateDepartment(departmentEntity);
	}
	
	/**
	 * ɾ��ϵ
	 * @param dep_id
	 */
	@Transactional
	public void deleteDepartment(String dep_id) {
		commenDataDao.deleteDepartment(dep_id);
	}
	
	
	/**
	 * ��Course������ݣ��γ�
	 * @param courseEntity
	 */
	@Transactional
	public String addToCourse(CourseEntity courseEntity) {
		return courseManageDao.addToCourse(courseEntity);
	}
	
	/**
	 * �޸Ŀγ�����
	 * @param courseEntity
	 */
	@Transactional
	public void updateCourse(CourseEntity courseEntity) {
		courseManageDao.updateCourse(courseEntity);
	}
	
	/**
	 * ɾ���γ�����
	 * @param cou_id
	 */
	@Transactional
	public void deleteCourse(String cou_id) {
		courseManageDao.deleteCourse(cou_id);
	}
	
	/**
	 * ��ȡ�γ̱�
	 * @return
	 */
	public List<CourseEntity> gCourseEntities() {
		return courseManageDao.gCourseEntities();
	}
	
	/**
	 * ��ȡȫ���̲���Ϣ
	 * @return
	 */
	public List<MaterialEntity> getAllMaterial() {
		return courseManageDao.getAllMaterial();
	}
	
	/**
	 * �޸�material������
	 * @param material
	 */
	@Transactional
	public void updateMaterial(MaterialEntity material) {
		courseManageDao.updateMaterial(material);
	}
	
	/**
	 * ɾ���̲�
	 * @param isbn
	 */
	@Transactional
	public void deleteMaterial(String isbn) {
		courseManageDao.deleteMaterial(isbn);
	}
	
	/**
	 * ��material������ݣ��̲�
	 * @param matertal
	 */
	@Transactional
	public void addToMaterial(MaterialEntity material) {
		courseManageDao.addToMaterial(material);
	}
	
	/**
	 * ��Student�����������
	 * @param studentEntity
	 */
	@Transactional
	public void addToStudent(StudentEntity studentEntity) {
		registerDao.addToStudent(studentEntity);
	}
	
	/**
	 * ��ȡѧ����
	 * @return
	 */
	public List<StudentEntity> gStudentEntities(int a,int b) {
		return studentDao.gStudentEntities(a,b);
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 * @param studentEntity
	 */
	@Transactional
	public void updateStudent(StudentEntity studentEntity) {
		registerDao.updateStudent(studentEntity);
	}
	
	/**
	 * ɾ��ѧ����Ϣ
	 * @param stuid
	 */
	public void deleleStudent(String stuid) {
		registerDao.deleleStudent(stuid);
	}
	
	/**
	 * ��ȡ��ʦ��
	 * @return
	 */
	public List<TeacherEntity> gTeacherEntities(int a,int b) {
		return teacherDao.gTeacherEntities(a,b);
	}
	
	/**
	 * �޸Ľ�ʦ����
	 * @param teacherEntity
	 */
	@Transactional
	public void updateTeacher(TeacherEntity teacherEntity) {
		registerDao.updateTeacher(teacherEntity);
	}
	
	/**
	 * ɾ����ʦ����
	 * @param tea_id
	 */
	@Transactional
	public void deleteTeacher(String tea_id) {
		registerDao.deleteTeacher(tea_id);
	}
	
	/**
	 * ���ʦ����������ݣ���ʦע��
	 * @param teacherEntity
	 */
	@Transactional
	public void addToTeacher(TeacherEntity teacherEntity) {
		registerDao.addToTeacher(teacherEntity);
	}
}
	
	
	



