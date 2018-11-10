package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cars.service.MemberService;
import com.cars.vo.MemberVo;

public class JoinInterceptor extends HandlerInterceptorAdapter{

	@Inject
	MemberService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				
		String id = request.getParameter("mId");
		String pass = request.getParameter("mPass");
		String name = request.getParameter("mName");
		int gender = Integer.parseInt(request.getParameter("mGender"));
		
		MemberVo vo = service.getUser(id);
		if(vo != null) {
			/*System.out.println("JoinInterceptor : " + vo);*/
			RequestDispatcher rd = request.getRequestDispatcher("/member/join");
			request.setAttribute("message", id + "는 이미 존재합니다.");
			rd.forward(request, response);
			return false;
		}else {
			MemberVo memberVo = new MemberVo();
			memberVo.setmId(id);
			memberVo.setmPass(pass);
			memberVo.setmName(name);
			memberVo.setmAge(Integer.parseInt(request.getParameter("mAge")));
			memberVo.setmGender(gender);
			request.setAttribute("member", memberVo);
			return true;
		}
		
	}
		
}
