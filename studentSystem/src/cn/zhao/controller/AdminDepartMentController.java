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

@Controller
public class AdminDepartMentController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="AdminDepartMent")
	public String AdminDepartMent(Model model,HttpServletRequest request) {
		List<AcademyEntity> academyEntities=adminService.gAcademyEntities();
		List<DepartmentEntity> departmentEntities=adminService.gDepartmentEntities();
		if (academyEntities.size()!=0) {
			model.addAttribute("academyEntities", academyEntities);
		} else {
			model.addAttribute("academyEntities", "0");
		}
		if (departmentEntities.size()!=0) {
			model.addAttribute("departmentEntities", departmentEntities);
		} else {
			model.addAttribute("departmentEntities", "0");
		}
		return "AdminDepartMent";
	}
	
	@RequestMapping(value="updateDepartMent")
	public String updateDepartMent(DepartmentEntity departmentEntity,Model model,
			HttpServletRequest request) {
		System.out.println(departmentEntity);
		adminService.updateDepartment(departmentEntity);
		return AdminDepartMent(model, request);
	}
	
	
	@RequestMapping(value="deleteDepartMent")
	public String deleteDepartMent(Model model,HttpServletRequest request) {
		adminService.deleteDepartment(request.getParameter("dep_id"));
		return AdminDepartMent(model, request);
	}
	
	@RequestMapping(value="increaseDepartment")
	public String increaseDepartment(DepartmentEntity departmentEntity,Model model,
			HttpServletRequest request) {
		adminService.addDepartment(departmentEntity);
		return AdminDepartMent(model, request);
	}
}
