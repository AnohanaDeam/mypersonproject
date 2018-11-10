package com.EMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面跳转
 * 
 * @author JTXY
 *
 */
@Controller
public class PageJumpController {

	@RequestMapping(value = "/goBackend-home", method = RequestMethod.GET)
	public String goBackendHome() {
		return "backend-home";
	}
	
	@RequestMapping(value = "/loginPage",method=RequestMethod.GET)
	public String loginPage(){
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value = "Admin/info", method = RequestMethod.GET)
	public String goInfo(){
		return "info";
	}
	/**
	 * 跳转用户首页
	 */
	@RequestMapping(value="/goHome", method = RequestMethod.GET)
	public String goHome(){
		return "../../index";
	}
	
	@RequestMapping(value="/message",method = RequestMethod.GET)
	public String message(){
		return "message";
	}

}
