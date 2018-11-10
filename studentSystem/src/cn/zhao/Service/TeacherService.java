package cn.zhao.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhao.dao.StudentDao;
import cn.zhao.dao.TeacherDao;
import cn.zhao.entity.StuToCouEntity;
import cn.zhao.entity.TeacherEntity;
import cn.zhao.entity.VwCountOfSTTEntity;
import cn.zhao.entity.VwTeaToScoreEntity;
import cn.zhao.entity.vwCoMaToTeaEntity;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private StudentDao studentDao;
	
	/**
	 * ��ȡ��ʦ��Ϣ
	 * @param id
	 * @return
	 */
	public TeacherEntity getTeacherInfo(String id) {
		TeacherEntity teacherEntity = new TeacherEntity();
		teacherEntity.setTea_id(id);
		teacherEntity = teacherDao.getTeacherInfo(teacherEntity.getTea_id());
		return teacherEntity;
	}
	
	/**
	 * ��ȡ��ʦ���ѿγ���Ϣ��tea_id
	 * @param tea_id
	 * @return
	 */
	public List<vwCoMaToTeaEntity> getCoMaToTea(String tea_id) {
		return teacherDao.getCoMaToTea(tea_id);
	}
	
	/**
	 * ��ȡ����ĳ�γ̵�ѧ���ɼ�
	 * @param tea_id
	 * @param cou_id
	 * @return
	 */
	public List<VwTeaToScoreEntity> getVwTeaToScore(String tea_id,String cou_id) {
		return teacherDao.getVwTeaToScore(tea_id, cou_id);
	}
	
	/**
	 * ��ʦ��ȡĳ�ſγ�ѧ������
	 * @param tea_id
	 * @param cou_id
	 * @return
	 */
	public List<VwCountOfSTTEntity> getvwCountOfSTT(String tea_id) {
		return teacherDao.getvwCountOfSTT(tea_id);
	}
	
	public void updateScores(StuToCouEntity stuToCouEntity) {
		studentDao.updateScore(stuToCouEntity);
	}
}
