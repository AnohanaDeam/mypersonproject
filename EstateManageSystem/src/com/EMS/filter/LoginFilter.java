package com.EMS.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.EMS.model.vo.LoginVo;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/Admin/*")
public class LoginFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("过滤器运行");
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		ServletContext app = req.getServletContext();
		
		try {
			LoginVo loginVo = (LoginVo) req.getSession().getAttribute("user");
			@SuppressWarnings("unchecked")
			Map<String, String> map = (Map<String, String>) app.getAttribute(loginVo.getUser_name());
			System.out.println(map);
			System.out.println(loginVo);
			SimpleDateFormat dd=new SimpleDateFormat("yyyyMMddHHmm");
			System.out.println(dd.format(new Date()));
			if (Double.parseDouble(dd.format(new Date()))-Double.parseDouble(map.get("time"))>30) {
				app.removeAttribute(loginVo.getUser_name());
				req.setAttribute("msg", "登陆超时，请重新登陆");
				req.getRequestDispatcher("info").forward(req, resp);
			} else {
				if (map.get("username").equals((loginVo.getUser_name()))) {
					if (map.get("IP").equals(req.getRemoteAddr())) {
						System.out.println(map.get("IP") + "in LoginFilter");
						map.put("time", dd.format(new Date()));
						app.setAttribute(loginVo.getUser_name(), map);
					} else {
						app.removeAttribute(loginVo.getUser_name());
						req.setAttribute("msg", "该账号已从别处登陆，请重新登陆");
						req.getRequestDispatcher("info").forward(req, resp);
					}
					arg2.doFilter(req, resp);
				} else {
					map.put("time", dd.format(new Date()));
					app.setAttribute(loginVo.getUser_name(), map);
					arg2.doFilter(req, resp);
				}
			}	
		}catch (NullPointerException e) {
			e.printStackTrace();
			req.setAttribute("msg", "o（＾∀＾）o 你下线了(T＿T)/~~");
			req.getRequestDispatcher("info").forward(req, resp);
			arg2.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
