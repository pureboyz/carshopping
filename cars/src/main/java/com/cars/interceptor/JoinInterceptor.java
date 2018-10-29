package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cars.service.MemberService;
import com.cars.vo.MemberVo;

public class JoinInterceptor extends HandlerInterceptorAdapter{

	@Inject
	MemberService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String mId = request.getParameter("mId");
		
		MemberVo vo = service.getUser(mId);
		
		if(vo!=null) {
			System.out.println("JoinInterceptor : " + vo);
			RequestDispatcher rd = request.getRequestDispatcher("/member/login");
			request.setAttribute("message", mId + "는 이미 존재합니다.");
			rd.forward(request, response);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	
	
}
