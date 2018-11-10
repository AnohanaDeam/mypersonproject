package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.CommenDataService;
import cn.zhao.Service.CourseService;
import cn.zhao.Service.TeacherService;
import cn.zhao.entity.MaterialEntity;
import cn.zhao.entity.TeacherEntity;
import cn.zhao.entity.VwCountOfSTTEntity;
import cn.zhao.entity.VwTeaToScoreEntity;
import cn.zhao.entity.vwCoMaToTeaEntity;
import cn.zhao.initialize.TeaIndexInitialize;

@Controller
public class TeaIndexController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeaIndexInitialize teaIndexInitialize;
	
	@RequestMapping(value="CourseInfo")
	public String LinkToCourseInfo(Model model,HttpServletRequest request) {
		List<vwCoMaToTeaEntity> vwCoMaToTeaEntities;
		
		try {
				String account=(String)request.getSession().getAttribute("account");
			vwCoMaToTeaEntities=teacherService.getCoMaToTea(account);
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
					vwCoMaToTeaEntities.get(0).getCou_id());
			model.addAttribute("Course", vwCoMaToTeaEntities.get(0));
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
		try {
			model.addAttribute("maxscore", courseService.getMaxScore(vwCoMaToTeaEntities.get(0).getCou_id()));
			model.addAttribute("minscore", courseService.getMinScore(vwCoMaToTeaEntities.get(0).getCou_id()));
			model.addAttribute("avgscore", courseService.getAvgScore(vwCoMaToTeaEntities.get(0).getCou_id()));
			model.addAttribute("bandscore", courseService.getCountForFeil(vwCoMaToTeaEntities.get(0).getCou_id(),
							"scores>=0 and scores<=100"));
		} catch (NullPointerException e) {
			model.addAttribute("maxscore", "0");
			model.addAttribute("minscore", "0");
			model.addAttribute("avgscore", "0");
			model.addAttribute("bandscore", "0");
		}
		
		return "CourseInfo";
	}
	
	@RequestMapping(value="TeaIndex")
	public String LinkToTeaIndex(Model model,HttpServletRequest request) {
		try {
			String account=(String)request.getSession().getAttribute("account");
			teaIndexInitialize.setInitialize(model,
					teacherService.getTeacherInfo(account));
		} catch (Exception e) {
			return "index";
		}
		return "TeaIndex";
	}
	
	@RequestMapping(value="SelectMyCou")
	public String LinkToSelectMyCou(Model model,HttpServletRequest request) {
		String tea_id=(String)request.getSession().getAttribute("account");
		List<VwCountOfSTTEntity> vwCountOfSTTEntities=teacherService.getvwCountOfSTT(tea_id);
		model.addAttribute("Course", vwCountOfSTTEntities.get(0));
		if (vwCountOfSTTEntities.size()!=0) {
			model.addAttribute("vwCountOfSTTEntities", vwCountOfSTTEntities);
		} else {
			model.addAttribute("vwCountOfSTTEntities", "0");
		}
		return "SelectMyCou";
	}
	
	@RequestMapping(value="AddCourse")
	public String LinkToAddCourse(Model model,HttpServletRequest request) {
		
		List<MaterialEntity> materialEntities=courseService.getAllMaterial();
		if (materialEntities.size()==0) {
			model.addAttribute("Materials", "ÔÝÎÞ½Ì²Ä");
		}else {
			/*for (MaterialEntity materialEntity : courseService.getAllMaterial()) {
				System.out.println(materialEntity);
			}*/
			model.addAttribute("Materials", materialEntities);
		}
		return "AddCourse";
	}
	
	@RequestMapping(value="AddSores")
	public String LinkToAddSores(Model model,HttpServletRequest request) {
		List<vwCoMaToTeaEntity> vwCoMaToTeaEntities;
		
		try {
				String account=(String)request.getSession().getAttribute("account");
			vwCoMaToTeaEntities=teacherService.getCoMaToTea(account);
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
					vwCoMaToTeaEntities.get(0).getCou_id());
			model.addAttribute("Course", vwCoMaToTeaEntities.get(0));
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
		return "AddSores";
	}
}
