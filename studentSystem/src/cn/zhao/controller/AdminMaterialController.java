package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.AdminService;
import cn.zhao.entity.MaterialEntity;

@Controller
public class AdminMaterialController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="AdminMaterial")
	public String AdminMaterial(Model model,HttpServletRequest request) {
		List<MaterialEntity> materialEntities=adminService.getAllMaterial();
		if (materialEntities.size()!=0) {
			model.addAttribute("materialEntities", materialEntities);
		} else {
			model.addAttribute("materialEntities", "0");
		}
		return "AdminMaterial";
	}
	
	@RequestMapping(value="updateMaterial")
	public String updateDepartMent(MaterialEntity materialEntity,Model model,
			HttpServletRequest request) {
		adminService.updateMaterial(materialEntity);
		return AdminMaterial(model, request);
	}
	
	
	@RequestMapping(value="deleteMaterial")
	public String deleteDepartMent(Model model,HttpServletRequest request) {
		adminService.deleteMaterial(request.getParameter("isbn"));
		return AdminMaterial(model, request);
	}
	
	@RequestMapping(value="addMaterial")
	public String addStudent(MaterialEntity materialEntity,Model model,
			HttpServletRequest request) {
		adminService.addToMaterial(materialEntity);
		return AdminMaterial(model, request);
	}
}
