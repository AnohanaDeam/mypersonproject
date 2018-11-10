package cn.zhao.initialize;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import cn.zhao.Service.CommenDataService;
import cn.zhao.Service.StudentService;
import cn.zhao.entity.StudentEntity;

@Repository
public class StuIndexInitialize {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CommenDataService commenDataService;
	
	public void setInitialize(Model model,StudentEntity studentEntity) {
		model.addAttribute("studentEntity", studentEntity);
		List<StudentEntity> studentEntities=
				studentService.getStudentInfoByCl(studentEntity.getClassM());
		model.addAttribute("departmentEntity", 
				commenDataService.getDepartmentInfo(studentEntity.getDepartment()));
		if (studentEntities.size()!=0) {
			model.addAttribute("studentEntities", studentEntities);
		} else {
			model.addAttribute("studentEntities", true);
		}
	}
}
