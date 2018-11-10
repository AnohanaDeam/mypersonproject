package cn.zhao.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.AcaMsgService;
import cn.zhao.entity.AcademyDateEntity;
import cn.zhao.entity.DepartmentDateEntity;

@Controller
public class GuestPageController {
	
	@Autowired
	private AcaMsgService acaMsgService;
	
	@RequestMapping(value="GuestPage")
	public String GuestPage(Model model,HttpServletRequest request) {
		
		model.addAttribute("Stu_num", acaMsgService.getAllStuNum());
		model.addAttribute("Tea_num", acaMsgService.getAllTeaNum());
		List<AcademyDateEntity> academyDateEntities=
				acaMsgService.getAcademyDateEntities();
		if (academyDateEntities.size()!=0) {
			model.addAttribute("academyDateEntities", academyDateEntities);
		} else {
			model.addAttribute("academyDateEntities", "0");
		}
		return "GuestPage";
	}
	
	@RequestMapping(value="getDepartMentDate")
	public String getDepartMentDate(Model model,HttpServletRequest request) {
		String academy=request.getParameter("academy");
		//String academy="¿Ì—ß‘∫";
		List<DepartmentDateEntity> departmentDateEntities=
				acaMsgService.getDepartmentDateEntities(academy);
		if (departmentDateEntities.size()!=0) {
			model.addAttribute("departmentDateEntities", departmentDateEntities);
		} else {
			model.addAttribute("departmentDateEntities", "0");
		}
		return GuestPage(model, request);
	}
}

