package cn.zhao.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhao.dao.CourseManageDao;
import cn.zhao.entity.CourseEntity;
import cn.zhao.entity.MaterialEntity;
import cn.zhao.entity.StuToCouEntity;
import cn.zhao.entity.VwStuToTeaEntity;
import cn.zhao.entity.VwTeaToCouEntity;

@Service
public class CourseService {
	
	@Autowired
	CourseManageDao courseManageDao;
	
	/**
	 * 添加信息
	 * @param courseEntity 课程类
	 */
	@Transactional
	public boolean addCourse(CourseEntity courseEntity,String tea_id) {
		boolean flag = true;
		try {
			courseManageDao.addToTeaToCou(tea_id, 
					courseManageDao.addToCourse(courseEntity));
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return flag;
	}
	
	/**
	 * 获取tea_id老师的课程信息--课、老师
	 * @param cou_id
	 * @return
	 */
	public List<VwTeaToCouEntity> getCourseInfoCTT(String tea_id) {
		return courseManageDao.getVwTeaToCou(tea_id);
	}
	
	/**
	 * 获取tea_id老师的课程信息--学生、老师,已老师ID
	 * @param cou_id
	 * @return
	 */
	public List<VwStuToTeaEntity> getCourseInfoSTTT(String tea_id) {
		return courseManageDao.getVwStuToTeaByT(tea_id);
	}
	
	/**
	 * 获取stuid老师的课程信息--学生、老师,已学生ID
	 * @param cou_id
	 * @return
	 */
	public List<VwStuToTeaEntity> getCourseInfoSTTS(String stuid) {
		return courseManageDao.getVwStuToTeaByS(stuid);
	}
	
	/**
	 * 添加教材
	 * @param materialEntity 教材类
	 * @return
	 */
	@Transactional
	public boolean addMaterial(MaterialEntity materialEntity) {
		boolean flag = true;
		try {
			courseManageDao.addToMaterial(materialEntity);
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return flag;
	}
	
	/**
	 * 获取全部教材信息
	 * @return
	 */
	public List<MaterialEntity> getAllMaterial() {
		return courseManageDao.getAllMaterial();
	}
	
	/**
	 * 获取选我课程的学生数
	 * @param tea_id
	 * @return
	 */
	public int getSelMyCouCount(String tea_id) {
		return courseManageDao.getSelMyCouCount(tea_id);
	}
	
	/**
	 * 获取我授课程数
	 * @param tea_id
	 * @return
	 */
	public int getMyCouCount(String tea_id) {
		return courseManageDao.getMyCouCount(tea_id);
	}
	
	/**
	 * 获取课程对应表由cou_id
	 * @param cou_id
	 * @return
	 */
	public List<StuToCouEntity> getStuToCouByC(String cou_id) {
		return courseManageDao.getStuToCouByC(cou_id);
	}
	/**
	 * 获取课程对应表由stu_id
	 * @param cou_id
	 * @return
	 */
	public List<StuToCouEntity> getStuToCouByS(String stu_id) {
		return courseManageDao.getStuToCouByS(stu_id);
	}
	
	/**
	 * 获取课程信息
	 * @param cou_id
	 * @return
	 */
	public CourseEntity getCourseInfo(String cou_id) {
		return courseManageDao.getCourseInfo(cou_id);
	}
	
	/**
	 * 获取教师对课程关系表
	 * @return
	 */
	public List<VwTeaToCouEntity> getVwTeaToCouAll() {
		return courseManageDao.getVwTeaToCouAll();
	}
	
	/**
	 * 获取课程得分最大值
	 * @return
	 */
	public double getMaxScore(String cou_id) {
		return courseManageDao.getMaxScore(cou_id);
	}
	
	/**
	 * 获得课程最低分
	 * @param cou_id
	 * @return
	 */
	public double getMinScore(String cou_id) {
		return courseManageDao.getMinScore(cou_id);
	}
	
	/**
	 * 获得课程平均分
	 * @param cou_id
	 * @return
	 */
	public double getAvgScore(String cou_id) {
		return courseManageDao.getAvgScore(cou_id);
	}
	
	public int getCountForFeil(String cou_id,String area) {
		return courseManageDao.getCountForFeil(cou_id, area);
	}
}




