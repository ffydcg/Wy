package com.em.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		//获取请求url
		String url = request.getRequestURI();
		//判断是否为公开地址（实际使用时将公开地址配置到配置文件中）
		//这里公开地址是登录提交的地址
		if(url.indexOf("login.do")>=0||url.indexOf("logout.do")>=0){
			//如果进行登录提交，放行
			return true;
		}
		//判断session
		HttpSession session = request.getSession();
		//从session中取出用户身份信息
         if(session.getAttribute("userInfo")!=null){
        	 return true;
         }
         response.sendRedirect(request.getContextPath() + "/index.jsp"); 
         return false;
	}

}
