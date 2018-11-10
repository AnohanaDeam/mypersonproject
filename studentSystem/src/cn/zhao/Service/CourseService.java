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
	 * �����Ϣ
	 * @param courseEntity �γ���
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
	 * ��ȡtea_id��ʦ�Ŀγ���Ϣ--�Ρ���ʦ
	 * @param cou_id
	 * @return
	 */
	public List<VwTeaToCouEntity> getCourseInfoCTT(String tea_id) {
		return courseManageDao.getVwTeaToCou(tea_id);
	}
	
	/**
	 * ��ȡtea_id��ʦ�Ŀγ���Ϣ--ѧ������ʦ,����ʦID
	 * @param cou_id
	 * @return
	 */
	public List<VwStuToTeaEntity> getCourseInfoSTTT(String tea_id) {
		return courseManageDao.getVwStuToTeaByT(tea_id);
	}
	
	/**
	 * ��ȡstuid��ʦ�Ŀγ���Ϣ--ѧ������ʦ,��ѧ��ID
	 * @param cou_id
	 * @return
	 */
	public List<VwStuToTeaEntity> getCourseInfoSTTS(String stuid) {
		return courseManageDao.getVwStuToTeaByS(stuid);
	}
	
	/**
	 * ��ӽ̲�
	 * @param materialEntity �̲���
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
	 * ��ȡȫ���̲���Ϣ
	 * @return
	 */
	public List<MaterialEntity> getAllMaterial() {
		return courseManageDao.getAllMaterial();
	}
	
	/**
	 * ��ȡѡ�ҿγ̵�ѧ����
	 * @param tea_id
	 * @return
	 */
	public int getSelMyCouCount(String tea_id) {
		return courseManageDao.getSelMyCouCount(tea_id);
	}
	
	/**
	 * ��ȡ���ڿγ���
	 * @param tea_id
	 * @return
	 */
	public int getMyCouCount(String tea_id) {
		return courseManageDao.getMyCouCount(tea_id);
	}
	
	/**
	 * ��ȡ�γ̶�Ӧ����cou_id
	 * @param cou_id
	 * @return
	 */
	public List<StuToCouEntity> getStuToCouByC(String cou_id) {
		return courseManageDao.getStuToCouByC(cou_id);
	}
	/**
	 * ��ȡ�γ̶�Ӧ����stu_id
	 * @param cou_id
	 * @return
	 */
	public List<StuToCouEntity> getStuToCouByS(String stu_id) {
		return courseManageDao.getStuToCouByS(stu_id);
	}
	
	/**
	 * ��ȡ�γ���Ϣ
	 * @param cou_id
	 * @return
	 */
	public CourseEntity getCourseInfo(String cou_id) {
		return courseManageDao.getCourseInfo(cou_id);
	}
	
	/**
	 * ��ȡ��ʦ�Կγ̹�ϵ��
	 * @return
	 */
	public List<VwTeaToCouEntity> getVwTeaToCouAll() {
		return courseManageDao.getVwTeaToCouAll();
	}
	
	/**
	 * ��ȡ�γ̵÷����ֵ
	 * @return
	 */
	public double getMaxScore(String cou_id) {
		return courseManageDao.getMaxScore(cou_id);
	}
	
	/**
	 * ��ÿγ���ͷ�
	 * @param cou_id
	 * @return
	 */
	public double getMinScore(String cou_id) {
		return courseManageDao.getMinScore(cou_id);
	}
	
	/**
	 * ��ÿγ�ƽ����
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




