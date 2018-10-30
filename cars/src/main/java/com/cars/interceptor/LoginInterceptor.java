package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
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
	
	/*private String login = "login";*/
	
	@Inject
	MemberService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		LoginDTO loginDTO = (LoginDTO)modelMap.get("loginDTO");
		
		if(loginDTO != null){
			MemberVo vo = service.login(loginDTO);
			System.out.println(vo);
			if(vo != null) {
				session.setAttribute("loginMember", vo);
				System.out.println(session.getAttribute("loginMember"));
				if(loginDTO.isUseCookie()) {
					Cookie cookie = new Cookie("loginCookie", vo.getmId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/member/login");
				request.setAttribute("message", "아이디와 패스워드가 일치하지 않습니다.");
				rd.forward(request, response);
			}
		}else {
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			if(loginMember == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/member/login");
				request.setAttribute("message", "로그인이 필요합니다.");
				rd.forward(request, response);
			}
		}
		
		
		
		
			
	}
	
	
	
	
	
}
