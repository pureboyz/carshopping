package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cars.service.MemberService;
import com.cars.vo.MemberVo;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	MemberService service;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo) session.getAttribute("loginMember");
		if(vo.getmGrade()<2) {
			System.out.println("AdminInterceptor : " + vo);
			RequestDispatcher rd = request.getRequestDispatcher("/");
			request.setAttribute("message","관리자만 접근 가능한 페이지입니다.");
			rd.forward(request, response);			
		}
	}
	
	

}
