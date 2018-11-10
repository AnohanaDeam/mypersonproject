package com.EMS.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import com.EMS.model.vo.LoginVo;

@WebFilter(filterName = "acceptBusinessFilter",urlPatterns = "/AcceptBusiness")
public class AcceptBusinessFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("过滤器运行");
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
		LoginVo user = (LoginVo)session.getAttribute("user");
		if (user == null || "".equals(user.getUser_pass())||"前台受理".equals(user.getIdentity())){
			req.getRequestDispatcher("service").forward(req, resp);
			
			return ;
		}
        arg2.doFilter(req, resp);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("111");
	}
}
