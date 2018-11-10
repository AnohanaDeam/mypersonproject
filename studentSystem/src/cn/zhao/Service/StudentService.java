package cn.zhao.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhao.dao.CourseManageDao;
import cn.zhao.dao.StudentDao;
import cn.zhao.dao.TeacherDao;
import cn.zhao.entity.StudentEntity;
import cn.zhao.entity.VwTeaToScoreEntity;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentInfo;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private CourseManageDao courseManageDao;
	
	public StudentEntity getStudentInfo(String id) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStuid(id);
		studentEntity = studentInfo.getStudentInfo(studentEntity.getStuid());
		return studentEntity;
	}
	
	public List<StudentEntity> getStudentInfoByCl(String sclass) {
		return studentInfo.getStudentInfoByCl(sclass);
	}
	
	public List<VwTeaToScoreEntity> getVwTeaToScore(String stuid) {
		return teacherDao.getVwTeaToScoreByS(stuid);
	}
	
	/**
	 * 获得该学生的平均成绩
	 * @param stuid
	 * @return
	 */
	public double getAverageScore(String stuid) {
		double average=0;
		List<VwTeaToScoreEntity> teaToScoreEntities=teacherDao.getVwTeaToScoreByS(stuid);
		for (VwTeaToScoreEntity vwTeaToScoreEntity : teaToScoreEntities) {
			average+=vwTeaToScoreEntity.getScores();
		}
		if (teaToScoreEntities.size()!=0) {
			return average/teaToScoreEntities.size();
		}else {
			return average;
		}
	}
	
	/**
	 * 获取在某门课程的成绩排名
	 * @param cou_id
	 * @return
	 */
	public int getRankingInCou(String cou_id,String stu_id) {
		double myScore=courseManageDao.getStuToCouBySC(stu_id, cou_id).getScores();
		List<VwTeaToScoreEntity> vwTeaToScoreEntities=teacherDao.getVwTeaToScoreByC(cou_id);
		List<Double> allScore=new ArrayList<Double>();
		for (VwTeaToScoreEntity vwTeaToScoreEntity : vwTeaToScoreEntities) {
			allScore.add((double) vwTeaToScoreEntity.getScores());
		}
		Collections.sort(allScore);
		Collections.reverse(allScore);
		return allScore.indexOf(myScore)+1;
	}
	
	/**
	 * 选课
	 * @param stu_id
	 * @param cou_id
	 */
	public void SelectCou(String stu_id,String cou_id) {
		studentInfo.SelectCou(cou_id, stu_id);
	}
	
	/**
	 * 退课
	 * @param stu_id
	 * @param cou_id
	 */
	public void DropCou(String stu_id,String cou_id) {
		studentInfo.DropCou(cou_id, stu_id);
	}
}
