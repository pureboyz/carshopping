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

public class BadInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	MemberService service;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo) session.getAttribute("loginMember");
		if(vo.getmGrade()==0) {
			System.out.println("BadInterceptor : " + vo);
			RequestDispatcher rd = request.getRequestDispatcher("/");
			request.setAttribute("message", vo.getmName() + "님은 불량회원으로 사용이 제한되었습니다.");
			rd.forward(request, response);			
		}
		
		
	}
	
	

}
