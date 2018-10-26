package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cars.dto.LoginDTO;
import com.cars.service.MemberService;
import com.cars.vo.MemberVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private String login = "login";
	
	@Inject
	MemberService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute(login)!=null) {
			session.removeAttribute(login);
		}
		
		System.out.println("Interceptor");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		LoginDTO loginDTO = (LoginDTO)modelMap.get("loginDTO");
		
		MemberVo vo = service.login(loginDTO);
		
		if(vo != null) {
			session.setAttribute("login", vo);
			
			if(loginDTO.isUseCookie()) {
				Cookie cookie = new Cookie("loginCookie", vo.getmId());
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
		}else {
			response.sendRedirect("/member/login");
		}
			
		Object dest = session.getAttribute("dest");
		response.sendRedirect(dest != null ? (String)dest : "/");
			
	}
	
	
	
	
	
}
