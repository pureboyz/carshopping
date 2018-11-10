package com.cars.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cars.vo.MemberVo;

public class NotLoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo) session.getAttribute("loginMember");
		
		if(vo == null) {
			RequestDispatcher rd =request.getRequestDispatcher("/member/login");
			request.setAttribute("message", "로그인이 필요합니다.");
			rd.forward(request, response);
			return false;
		}
		
		return true;
	}
	
	

}
