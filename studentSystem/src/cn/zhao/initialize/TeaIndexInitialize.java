package cn.zhao.initialize;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import cn.zhao.Service.CommenDataService;
import cn.zhao.Service.CourseService;
import cn.zhao.entity.TeacherEntity;
import cn.zhao.entity.VwStuToTeaEntity;
import cn.zhao.entity.VwTeaToCouEntity;

@Repository
public class TeaIndexInitialize {
	
	@Autowired
	CommenDataService commenDataService;
	
	@Autowired
	CourseService courseService;
	
	public Model setInitialize(Model model,TeacherEntity teacherEntity) {
		model.addAttribute("teacherEntity",teacherEntity);
		model.addAttribute("academyEntity",
				commenDataService.getAcaInfo(teacherEntity.getDepartment()));
		model.addAttribute("departmentEntity", 
				commenDataService.getDepartmentInfo(teacherEntity.getDepartment()));
		model.addAttribute("selMyCouCount",courseService.getSelMyCouCount(teacherEntity.getTea_id()));
		model.addAttribute("MyCouCount",courseService.getMyCouCount(teacherEntity.getTea_id()));
		List<VwTeaToCouEntity> teaToCouEntities=courseService.getCourseInfoCTT(teacherEntity.getTea_id());
		if (teaToCouEntities.size()!=0) {
			model.addAttribute("teaToCouEntities",teaToCouEntities);
		}else {
			model.addAttribute("teaToCouEntities",true);
		}
		return model;
	}
}
