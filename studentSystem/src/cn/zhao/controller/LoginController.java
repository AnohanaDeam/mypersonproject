package cn.zhao.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.CommenDataService;
import cn.zhao.Service.LoginService;
import cn.zhao.Service.StudentService;
import cn.zhao.Service.TeacherService;
import cn.zhao.entity.LoginEntity;
import cn.zhao.entity.TeacherEntity;
import cn.zhao.initialize.StuIndexInitialize;
import cn.zhao.initialize.TeaIndexInitialize;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private TeaIndexInitialize teaIndexInitialize;
	
	@Autowired
	private StuIndexInitialize stuIndexInitialize;
	
	@Autowired
	private AdminIndexController adminIndexController;
	
	@RequestMapping(value="indexManage")
	public String getIndex(LoginEntity loginEntity,Model model,
			HttpServletRequest request,HttpServletResponse response) {
		String error="";
		Object value=request.getSession().getAttribute("account");
		
		if (value!=null&&value.toString().equals(loginEntity.getAccount())) {
			error="此用户已登陆，不允许重复登陆！！";
			model.addAttribute("userLogin", loginEntity);
		}else {
			if (loginEntity!=null&&loginEntity.getAccount()!=null&&loginEntity.getPassword()!=null) {
				if (loginEntity.getAccount().equals("")&&loginEntity.getPassword().equals("")) {
					error="用户名或密码为空!!!";
				}else if (loginService.login(loginEntity)>0) {
					
					loginEntity.setIdentity(loginService.getIdentity(loginEntity));
					//登陆成功，为页面添加Session记住登陆状态
					request.getSession().setAttribute("account", loginEntity.getAccount());
					
					//为页面添加Cookie-记住账号密码
					String autologin=request.getParameter("remember-me");
					if (autologin!=null) {
						String logininfo=loginEntity.getAccount()+","+loginEntity.getPassword();
						Cookie cookie=new Cookie("login_info", logininfo);
						cookie.setMaxAge(60*60*24*7);
						response.addCookie(cookie);
					}else {
						String logininfo=loginEntity.getAccount()+"#"+loginEntity.getPassword();
						Cookie cookie=new Cookie("login_info", logininfo);
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					/*model.addAttribute("status", 1);
					model.addAttribute("userLogin", userLogin);*/
					//return "StuIndex";
					System.out.println(loginEntity);
					
					if (loginEntity.getIdentity().equals("admin")) {
						return adminIndexController.AdminIndex(model,request);
					}
					
					//判断身份并想要跳转的页面添加信息
					if (loginEntity.getIdentity().equals("teacher")) {
						teaIndexInitialize.setInitialize(model,
								teacherService.getTeacherInfo(loginEntity.getAccount()));
					}else {
						stuIndexInitialize.setInitialize(model, 
								studentservice.getStudentInfo(loginEntity.getAccount()));
					}
					return ((loginEntity.getIdentity().equals("teacher")) ? "Tea" : "Stu")+"Index";
				}else {
					error="用户名或密码为错误!!!";
				}
			}else{
				error="用户名或密码为空";
			}
		}
		model.addAttribute("error", error);
		System.out.println(error);
		return "index";
	}
	
	
}
