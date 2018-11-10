package cn.zhao.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhao.dao.AcaMsgDao;
import cn.zhao.entity.AcademyDateEntity;
import cn.zhao.entity.DepartmentDateEntity;
import cn.zhao.entity.VwAcademyDNumEntity;
import cn.zhao.entity.VwAcademyStuNumEntity;
import cn.zhao.entity.VwAcademyTeaNumEntity;
import cn.zhao.entity.VwDepartmentStuNum;
import cn.zhao.entity.VwDepartmentTeaNum;

@Service
public class AcaMsgService {

	@Autowired
	private AcaMsgDao acaMsgDao;
	
	/**
	 * ��ȡѧԺϵ��Ŀ
	 * @return
	 */
	public List<VwAcademyDNumEntity> getVwAcademyDNum() {
		return acaMsgDao.getVwAcademyDNum();
	}
	
	/**
	 * ��ȡѧԺѧ����Ŀ
	 * @return
	 */
	public List<VwAcademyStuNumEntity> getVwAcademyStuNum() {
		return acaMsgDao.getVwAcademyStuNum();
	}
	
	/**
	 * ��ȡѧԺ��ʦ��Ŀ
	 * @return
	 */
	public List<VwAcademyTeaNumEntity> getVwAcademyTeaNum() {
		return acaMsgDao.getVwAcademyTeaNum();
	}
	
	/**
	 * ��ȡ��ϵѧ����Ŀ
	 * @return
	 */
	public List<VwDepartmentStuNum> getDepartmentStuNum(String academy) {
		return acaMsgDao.getVwDepartmentStuNum(academy);
	}
	
	/**
	 * ��ȡ��ϵ��ʦ��Ŀ
	 * @return
	 */
	public List<VwDepartmentTeaNum> getVwDepartmentTeaNum(String academy) {
		return acaMsgDao.getVwDepartmentTeaNum(academy);
	}
	
	/**
	 * ��ȡ����ѧ����Ŀ
	 * @return
	 */
	public double getAllStuNum() {
		return acaMsgDao.getAllStuNum();
	}
	
	/**
	 * ��ȡ������ʦ��Ŀ
	 * @return
	 */
	public double getAllTeaNum() {
		return acaMsgDao.getAllTeaNum();
	}
	
	/**
	 * ��ȡѧУѧԺ����
	 * @return
	 */
	public List<AcademyDateEntity> getAcademyDateEntities(){
		List<AcademyDateEntity> academyDateEntities=new ArrayList<>();
		List<VwAcademyDNumEntity> vwAcademyDNumEntities=getVwAcademyDNum();
		List<VwAcademyStuNumEntity> vwAcademyStuNumEntities=getVwAcademyStuNum();
		List<VwAcademyTeaNumEntity> vwAcademyTeaNumEntities=getVwAcademyTeaNum();
		for (int i = 0; i < getVwAcademyDNum().size(); i++) {
			AcademyDateEntity academyDateEntity=new AcademyDateEntity();
			academyDateEntity.setAca_dean(
					vwAcademyDNumEntities.get(i).getAca_dean());
			academyDateEntity.setAca_name(
					vwAcademyDNumEntities.get(i).getAca_name());
			academyDateEntity.setDepNum(
					vwAcademyDNumEntities.get(i).getDepNum());
			academyDateEntity.setStuNum(
					vwAcademyStuNumEntities.get(i).getStu_num());
			academyDateEntity.setTeaNum(
					vwAcademyTeaNumEntities.get(i).getTeaa_num());
			academyDateEntities.add(academyDateEntity);
		}
		return academyDateEntities;
	}
	
	/**
	 * ��ȡĳѧԺϵ����
	 * @param academy
	 * @return
	 */
	public List<DepartmentDateEntity> getDepartmentDateEntities(String academy) {
		List<DepartmentDateEntity> departmentDateEntities=new ArrayList<>();
		List<VwDepartmentStuNum> vwDepartmentStuNums=getDepartmentStuNum(academy);
		List<VwDepartmentTeaNum> vwDepartmentTeaNums=getVwDepartmentTeaNum(academy);
		for (int i = 0; i < vwDepartmentStuNums.size(); i++) {
			DepartmentDateEntity departmentDateEntity=new DepartmentDateEntity();
			departmentDateEntity.setAcademy(
					vwDepartmentStuNums.get(i).getAcademy());
			departmentDateEntity.setDep_id(
					vwDepartmentStuNums.get(i).getDep_id());
			departmentDateEntity.setDep_name(
					vwDepartmentStuNums.get(i).getDep_name());
			departmentDateEntity.setDep_phone(
					vwDepartmentStuNums.get(i).getDep_phone());
			departmentDateEntity.setStuNum(
					vwDepartmentStuNums.get(i).getStu_num());
			departmentDateEntity.setTeaNum(
					vwDepartmentTeaNums.get(i).getTea_num());
			departmentDateEntities.add(departmentDateEntity);
		}
		return departmentDateEntities;
	}
}
