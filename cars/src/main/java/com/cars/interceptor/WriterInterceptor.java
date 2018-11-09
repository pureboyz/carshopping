package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cars.service.BoardService;
import com.cars.service.MemberService;
import com.cars.vo.BoardVo;
import com.cars.vo.MemberVo;

public class WriterInterceptor extends HandlerInterceptorAdapter{

	@Inject
	MemberService mService;
	BoardService bService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("loginMember");
		System.out.println(memberVo);
		
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		System.out.println("작성자인터셉터 : " + bNo);
		BoardVo boardVo = bService.readPage(bNo);
		System.out.println(boardVo);		
		
		if(memberVo.getmGrade()<2) {
			if(memberVo.getmNo()!=boardVo.getmNo()) {
				System.out.println(memberVo);
				System.out.println(boardVo);
				
				RequestDispatcher rd = request.getRequestDispatcher("/board/readPage?bNo="+bNo);
				request.setAttribute("message", "작성자가 아니면 수정과 삭제가 불가능합니다.");
				rd.forward(request, response);
				return false;
			}	
		}			
		
		request.setAttribute("bNo", bNo);
		return true;
		
	}
	
	

}
