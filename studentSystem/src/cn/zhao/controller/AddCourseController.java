package cn.zhao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.CourseService;
import cn.zhao.entity.CourseEntity;
import cn.zhao.entity.MaterialEntity;

@Controller
public class AddCourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	TeaIndexController teaIndexController;
	
	@RequestMapping(value="increaseCourse")
	public String increaseCourse(CourseEntity courseEntity,Model model,
			HttpServletRequest request,HttpServletResponse response) {
		String message = "";
		System.out.println(courseEntity);
		
		if (courseEntity!=null) {
			try {
				String account=(String)request.getSession().getAttribute("account");
				if (courseService.addCourse(courseEntity, account)) {
					message="��ӿγ̳ɹ�";
				}
			} catch (Exception e) {
				message=e.toString();
				request.getSession().invalidate();
			}
		}
		message="��ӿγ�ʧ��";
		model.addAttribute("message", message);
		return teaIndexController.LinkToAddCourse(model, request);
	}
	
	@RequestMapping(value="increaseMaterial")
	public String increaseMaterial(MaterialEntity materialEntity,Model model,
			HttpServletRequest request,HttpServletResponse response) {
		String message = "";
		System.out.println(materialEntity);
		if (materialEntity!=null) {
			try {
				if (courseService.addMaterial(materialEntity)) {
					message="��ӽ̲ĳɹ�";
				}
			} catch (DuplicateKeyException e) {
				message="�����Ѵ���";
				request.getSession().invalidate();
				return "index";
			} catch (Exception e) {
				message="��½��ϢʧЧ";
				request.getSession().invalidate();
				return "index";
			}
		}
		message="��ӽ̲�ʧ��";
		model.addAttribute("message", message);
		return teaIndexController.LinkToAddCourse(model, request);
	}
}
