package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.AdminService;
import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.DepartmentEntity;
import cn.zhao.entity.TeacherEntity;

@Controller
public class AdminTeacherController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="AdminTeacher")
	public String AdminStudent(Model model,HttpServletRequest request) {
		List<TeacherEntity> teacherEntities=adminService.gTeacherEntities(1,10);
		List<AcademyEntity> academyEntities=adminService.gAcademyEntities();
		List<DepartmentEntity> departmentEntities=adminService.gDepartmentEntities();
		if (teacherEntities.size()!=0) {
			model.addAttribute("teacherEntities", teacherEntities);
		} else {
			model.addAttribute("teacherEntities", "0");
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
		return "AdminTeacher";
	}
	
	@RequestMapping(value="updateTeacher")
	public String updateDepartMent(TeacherEntity teacherEntity,Model model,
			HttpServletRequest request) {
		System.out.println(teacherEntity);
		adminService.updateTeacher(teacherEntity);
		return AdminStudent(model, request);
	}
	
	
	@RequestMapping(value="deleteTeacher")
	public String deleteDepartMent(Model model,HttpServletRequest request) {
		System.out.println(request.getParameter("tea_id"));
		adminService.deleteTeacher(request.getParameter("tea_id"));
		return AdminStudent(model, request);
	}
	
	@RequestMapping(value="addTeacher")
	public String addStudent(TeacherEntity teacherEntity,Model model,
			HttpServletRequest request) {
		System.out.println(teacherEntity);
		adminService.addToTeacher(teacherEntity);
		return AdminStudent(model, request);
	}
}
