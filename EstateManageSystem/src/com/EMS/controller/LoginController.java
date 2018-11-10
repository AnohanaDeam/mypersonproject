package com.EMS.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EMS.model.service.LoginsService;
import com.EMS.model.vo.LoginVo;

@Controller
public class LoginController {
	
	@Autowired
	private LoginsService loginsservice;
	
	@Autowired
	private HttpSession session;
	
	private ServletContext app;
	
	/**
	 * �����֤������¼��̨
	 * @return ��ת��ҳ��
	 */
	@RequestMapping(value = "Admin/service", method = RequestMethod.GET)
	public String login(Model model,String user_name) {
		if (session!= null) {
			model.addAttribute("msg", "��½�ɹ��װ���"+user_name);
			return "service";
		} else {
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping(value="Admin/logout")
	public String logout(HttpServletRequest request) {
		session.removeAttribute("user");
		app = request.getServletContext();
		app.removeAttribute(session.getId());
		return "redirect:index.jsp";
	}
	
	/**
	 * �첽�����֤
	 * @param loginVo
	 * @return
	 */
	@RequestMapping(value = "/logincheck",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkLogin(String user_name,String user_pass,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		LoginVo user1=new LoginVo(user_name, user_pass);
		LoginVo user = loginsservice.login(user1);
		app = request.getServletContext();
		
		if (user!= null) {
			Map<String,String> map2 = new HashMap<>();
			map2.put("IP", request.getRemoteAddr());
			map2.put("username",user_name);
			SimpleDateFormat dd=new SimpleDateFormat("yyyyMMddHHmm");
			map2.put("time", dd.format(new Date()));
			System.out.println(dd.format(new Date()));
			app.setAttribute(user_name, map2);
			System.out.println(app.getAttribute(user_name));
			session.setAttribute("user", user);
			map.put("state", "��¼�ɹ�");
		} else {
			map.put("state", "�˺Ż��������");
		}
		return map;
	}
	
	
}
