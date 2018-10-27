package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.cars.service.MemberService;
import com.cars.vo.MemberVo;

public class CookieInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	MemberService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			return true;
		}
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			String mId = loginCookie.getValue();
			MemberVo vo = service.getUser(mId);
			if(vo != null) {
				session.setAttribute("loginMember", vo);
			}
		}
		return true;
	}
	
	

}
