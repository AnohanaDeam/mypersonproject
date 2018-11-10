package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.AdminService;
import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.CourseEntity;
import cn.zhao.entity.DepartmentEntity;
import cn.zhao.entity.MaterialEntity;
import cn.zhao.entity.CourseEntity;

@Controller
public class AdminCourseController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="AdminCourse")
	public String AdminCourse(Model model,HttpServletRequest request) {
		List<CourseEntity> courseEntities=adminService.gCourseEntities();
		List<MaterialEntity> materialEntities=adminService.getAllMaterial();
		if (courseEntities.size()!=0) {
			model.addAttribute("courseEntities", courseEntities);
		} else {
			model.addAttribute("courseEntities", "0");
		}
		
		if (materialEntities.size()!=0) {
			model.addAttribute("materialEntities", materialEntities);
		} else {
			model.addAttribute("materialEntities", "0");
		}
		
		return "AdminCourse";
	}
	
	@RequestMapping(value="updateCourse")
	public String updateDepartMent(CourseEntity courseEntity,Model model,
			HttpServletRequest request) {
		adminService.updateCourse(courseEntity);
		return AdminCourse(model, request);
	}
	
	
	@RequestMapping(value="deleteCourse")
	public String deleteDepartMent(Model model,HttpServletRequest request) {
		adminService.deleteCourse(request.getParameter("cou_id"));
		return AdminCourse(model, request);
	}
	
	@RequestMapping(value="addCourse")
	public String addStudent(CourseEntity courseEntity,Model model,
			HttpServletRequest request) {
		adminService.addToCourse(courseEntity);
		return AdminCourse(model, request);
	}
}
