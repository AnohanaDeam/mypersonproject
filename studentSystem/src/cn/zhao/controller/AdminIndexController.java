package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.AdminService;
import cn.zhao.entity.AcademyEntity;

@Controller
public class AdminIndexController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="AdminIndex")
	public String AdminIndex(Model model,HttpServletRequest request) {
		List<AcademyEntity> academyEntities=adminService.gAcademyEntities();
		if (academyEntities.size()!=0) {
			model.addAttribute("academyEntities", academyEntities);
		}else {
			model.addAttribute("academyEntities", "0");
		}
		return "AdminIndex";
	}
	
	@RequestMapping(value="updateacademy")
	public String UpdateAcademy(AcademyEntity academyEntity,Model model,
			HttpServletRequest request) {
		adminService.updateAcademy(academyEntity);
		return AdminIndex(model, request);
	}
	
	@RequestMapping(value="deleteacademy")
	public String DeleteAcademy(Model model,HttpServletRequest request) {
		adminService.delectAcademy(request.getParameter("aca_name"));
		return AdminIndex(model, request);
	}
	
	@RequestMapping(value="increaseAcademy")
	public String increaseAcademy(AcademyEntity academyEntity,Model model,
			HttpServletRequest request) {
		adminService.addAcademy(academyEntity);
		return AdminIndex(model, request);
	}
	
}
