package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.CourseService;
import cn.zhao.Service.TeacherService;
import cn.zhao.entity.StuToCouEntity;
import cn.zhao.entity.VwCountOfSTTEntity;
import cn.zhao.entity.VwTeaToScoreEntity;
import cn.zhao.entity.vwCoMaToTeaEntity;

@Controller
public class AddSoresController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value="potiutui")
	public String addScoreShow(Model model,HttpServletRequest request) {
		String cou_id=request.getParameter("cou_id");
		String tea_id=(String)request.getSession().getAttribute("account");

		try {
				String account=(String)request.getSession().getAttribute("account");
				List<vwCoMaToTeaEntity> vwCoMaToTeaEntities=teacherService.getCoMaToTea(account);
			if (vwCoMaToTeaEntities.size()!=0) {
				model.addAttribute("vwCoMaToTeaEntities", vwCoMaToTeaEntities);
			} else {
				model.addAttribute("vwCoMaToTeaEntities", "0");
			}
		} catch (Exception e) {
			return "index";
		}
		try {
			String account=(String)request.getSession().getAttribute("account");
			List<VwTeaToScoreEntity> vwTeaToScoreEntities=teacherService.getVwTeaToScore(account,
					cou_id);
			model.addAttribute("Course", courseService.getCourseInfo(cou_id));
			for (VwTeaToScoreEntity vwTeaToScoreEntity : vwTeaToScoreEntities) {
				System.out.println(vwTeaToScoreEntity);
			}
			if (vwTeaToScoreEntities.size()!=0) {
				model.addAttribute("vwTeaToScoreEntities", vwTeaToScoreEntities);
			}else {
				model.addAttribute("vwTeaToScoreEntities", "0");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "index";
		}
		List<VwCountOfSTTEntity> vwCountOfSTTEntities=teacherService.getvwCountOfSTT(tea_id);
		if (vwCountOfSTTEntities.size()!=0) {
			model.addAttribute("vwCountOfSTTEntities", vwCountOfSTTEntities);
		} else {
			model.addAttribute("vwCountOfSTTEntities","0");
		}
		return "AddSores";
	}
	
	@RequestMapping(value="addScoToStu")
	public String addScoToStu(StuToCouEntity stuToCouEntity,
			Model model,HttpServletRequest request) {
		teacherService.updateScores(stuToCouEntity);
		return addScoreShow(model, request);
	}
}
