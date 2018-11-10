package cn.zhao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.CourseService;
import cn.zhao.Service.StudentService;
import cn.zhao.entity.StuToCouEntity;
import cn.zhao.entity.StudentScoreEntity;
import cn.zhao.entity.VwTeaToCouEntity;
import cn.zhao.entity.VwTeaToScoreEntity;
import cn.zhao.initialize.StuIndexInitialize;

@Controller
public class StuIndexController {
	
	@Autowired
	StuIndexInitialize stuIndexInitialize;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value="StuIndex")
	public String getStuIndex(Model model,HttpServletRequest request) {
		try {
			String account=(String)request.getSession().getAttribute("account");
			stuIndexInitialize.setInitialize(model,
					studentService.getStudentInfo(account));
		} catch (Exception e) {
			return "index";
		}
		return "StuIndex";
	}
	
	@RequestMapping(value="CourseInfoToStu")
	public String getCourseInfoToStu(Model model,HttpServletRequest request) {
		String account=(String)request.getSession().getAttribute("account");
		
		List<StuToCouEntity> stuToCouEntities=courseService.getStuToCouByS(account);
		List<VwTeaToCouEntity> vwTeaToCouEntities=courseService.getVwTeaToCouAll();
		
		List<VwTeaToCouEntity> couStuAbSelects=new ArrayList<VwTeaToCouEntity>();
		List<VwTeaToCouEntity> couStuAlSelects=new ArrayList<VwTeaToCouEntity>();
		
		for (VwTeaToCouEntity vwTeaToCouEntity : vwTeaToCouEntities) {
			if (stuToCouEntities.size()!=0) {
				for (StuToCouEntity stuToCouEntity : stuToCouEntities) {
					if (vwTeaToCouEntity.getCou_id().equals(stuToCouEntity.getCou_id())) {
						if (!couStuAlSelects.contains(vwTeaToCouEntity)) {
							couStuAlSelects.add(vwTeaToCouEntity);
						}
					}
				}
			} else {
				couStuAbSelects.add(vwTeaToCouEntity);
			}
		}
		for (VwTeaToCouEntity vwTeaToCouEntity : vwTeaToCouEntities) {
			if (!couStuAbSelects.contains(vwTeaToCouEntity)&&!couStuAlSelects.contains(vwTeaToCouEntity)) {
				couStuAbSelects.add(vwTeaToCouEntity);
			}
		}
		if (couStuAbSelects.size()!=0) {
			//model.addAttribute("couStuAbSelects", couStuAbSelects);
			System.out.println("----couStuAbSelects----");
			for (VwTeaToCouEntity vwTeaToCouEntity : couStuAbSelects) {
				System.out.println(vwTeaToCouEntity);
			}
			model.addAttribute("couStuAbSelects", couStuAbSelects);
		} else {
			model.addAttribute("couStuAbSelects", "0");
		}
		if (couStuAlSelects.size()!=0) {
			//model.addAttribute("couStuAlSelects", couStuAlSelects);
			System.out.println("----couStuAlSelects----");
			for (VwTeaToCouEntity vwTeaToCouEntity : couStuAlSelects) {
				System.out.println(vwTeaToCouEntity);
			}
			model.addAttribute("couStuAlSelects", couStuAlSelects);
		} else {
			model.addAttribute("couStuAlSelects", "0");
		}
		return "CourseInfoToStu";
	}
	
	@RequestMapping(value="SelectScores")
	public String getSelectScores(Model model,HttpServletRequest request) {
		String stuid=(String)request.getSession().getAttribute("account");
		List<VwTeaToScoreEntity> vwTeaToScoreEntities=studentService.getVwTeaToScore(stuid);
		List<StudentScoreEntity> studentScoreEntities = new ArrayList<StudentScoreEntity>();
		for (VwTeaToScoreEntity vwTeaToScoreEntity : vwTeaToScoreEntities) {
			StudentScoreEntity studentScoreEntity=new StudentScoreEntity();
			studentScoreEntity.setCou_name(vwTeaToScoreEntity.getCou_name());
			System.out.println("cou_idºÍstuid:"+vwTeaToScoreEntity.getCou_id()+stuid);
			studentScoreEntity.setRank(studentService.getRankingInCou(
					vwTeaToScoreEntity.getCou_id(), stuid));
			studentScoreEntity.setScore(vwTeaToScoreEntity.getScores());
			studentScoreEntities.add(studentScoreEntity);
		}
		if (studentScoreEntities.size()!=0) {
			model.addAttribute("studentScoreEntities", studentScoreEntities);
			//studentScoreEntities.clear();
		} else {
			model.addAttribute("studentScoreEntities", "0");
		}
		model.addAttribute("AverageScore", studentService.getAverageScore(stuid));
		
		return "SelectScores";
	}
	
	@RequestMapping(value="SelectCou")
	public String SelectCou(Model model,HttpServletRequest request) {
		String cou_id=request.getParameter("cou_id");
		String stuid=(String)request.getSession().getAttribute("account");
		System.out.println("Ñ§¿ÎID:"+stuid+"--"+cou_id);
		studentService.SelectCou(stuid, cou_id);
		return getCourseInfoToStu(model, request);
	}
	
	@RequestMapping(value="DropCou")
	public String DropCou(Model model,HttpServletRequest request) {
		String cou_id=request.getParameter("cou_id");
		String stuid=(String)request.getSession().getAttribute("account");
		studentService.DropCou(stuid, cou_id);

		return getCourseInfoToStu(model, request);
	}
}
