package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.AcaMsgService;
import cn.zhao.Service.AdminService;
import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.DepartmentEntity;
import cn.zhao.entity.StudentEntity;

@Controller
public class AdminStudentController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AcaMsgService acaMsgService;
	
	@RequestMapping(value="AdminStudent")
	public String AdminStudent(Model model,HttpServletRequest request) {
		List<StudentEntity> studentEntities=adminService.gStudentEntities(1,10);
		for (StudentEntity studentEntity : studentEntities) {
			System.out.println(studentEntity);
		}
		List<AcademyEntity> academyEntities=adminService.gAcademyEntities();
		List<DepartmentEntity> departmentEntities=adminService.gDepartmentEntities();
		if (studentEntities.size()!=0) {
			model.addAttribute("studentEntities", studentEntities);
		} else {
			model.addAttribute("studentEntities", "0");
		}
		
		if (academyEntities.size()!=0) {
			model.addAttribute("academyEntities", academyEntities);
		} else {
			model.addAttribute("academyEntities", "0");
		}
		
		if (departmentEntities.size()!=0) {
			model.addAttribute("departmentEntities", departmentEntities);
		}else {
			model.addAttribute("departmentEntities", "0");
		}
		
		return "AdminStudent";
	}
	
	@RequestMapping(value="updateStudent")
	public String updateDepartMent(StudentEntity studentEntity,Model model,
			HttpServletRequest request) {
		adminService.updateStudent(studentEntity);
		return AdminStudent(model, request);
	}
	
	
	@RequestMapping(value="deleteStudent")
	public String deleteDepartMent(Model model,HttpServletRequest request) {
		adminService.deleleStudent(request.getParameter("stuid"));
		return AdminStudent(model, request);
	}
	
	@RequestMapping(value="addStudent")
	public String addStudent(StudentEntity studentEntity,Model model,
			HttpServletRequest request) {
		adminService.addToStudent(studentEntity);
		return AdminStudent(model, request);
	}
}
