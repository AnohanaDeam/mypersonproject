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
import cn.zhao.Service.TeacherService;
import cn.zhao.entity.StuToCouEntity;
import cn.zhao.entity.StudentEntity;
import cn.zhao.entity.VwCountOfSTTEntity;

@Controller
public class SelectMyCouController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;
	
	@SuppressWarnings({ "null", "unused" })
	@RequestMapping(value="selectCouStu")
	public String selectCouStu(String cou_id,Model model,HttpServletRequest request) {
		String tea_id=(String)request.getSession().getAttribute("account");
		List<VwCountOfSTTEntity> vwCountOfSTTEntities=teacherService.getvwCountOfSTT(tea_id);
		if (vwCountOfSTTEntities.size()!=0) {
			model.addAttribute("vwCountOfSTTEntities", vwCountOfSTTEntities);
		} else {
			model.addAttribute("vwCountOfSTTEntities", '0');
		}
		
		System.out.println(cou_id);
		List<StuToCouEntity> stuToCouEntities=courseService.getStuToCouByC(cou_id);
		List<StudentEntity> studentEntities = new ArrayList<StudentEntity>();
		for (StuToCouEntity stuToCouEntity : stuToCouEntities) {
			System.out.println(stuToCouEntity);
			StudentEntity studentEntity=studentService.getStudentInfo(
					stuToCouEntity.getStu_id());
			System.out.println(studentEntity);
			studentEntities.add(studentEntity);
		}
		if (studentEntities!=null) {
			model.addAttribute("studentEntities", studentEntities);
		}else {
			model.addAttribute("studentEntities", '0');
		}
		System.out.println(courseService.getCourseInfo(cou_id));
		model.addAttribute("Course", courseService.getCourseInfo(cou_id));
		return "SelectMyCou";
	}
}
