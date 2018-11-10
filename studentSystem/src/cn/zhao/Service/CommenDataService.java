package cn.zhao.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhao.dao.CommenDataDao;
import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.DepartmentEntity;

@Service
public class CommenDataService {
	
	@Autowired
	CommenDataDao commenDataDao;
	
	public AcademyEntity getAcaInfo(String dep_id) {
		return commenDataDao.getAcademyInfo(
				commenDataDao.getDepartmentInfo(dep_id).getAcademy());
	}
	
	public DepartmentEntity getDepartmentInfo(String dep_id) {
		return commenDataDao.getDepartmentInfo(dep_id);
	}
}
