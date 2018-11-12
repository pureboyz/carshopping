package com.cars.interceptor;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cars.service.BoardService;
import com.cars.service.MemberService;
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
		int bGrade = Integer.parseInt(request.getParameter("bGrade"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		int mNo = Integer.parseInt(request.getParameter("mNo"));
		
		if(memberVo == null) {
			RequestDispatcher rd =request.getRequestDispatcher("/member/login");
			request.setAttribute("message", "로그인이 필요합니다.");
			rd.forward(request, response);
		}else {
			if(memberVo.getmGrade() !=2) {//관리자가 아닐때
				if(bGrade==2) {//공지
					RequestDispatcher rd = request.getRequestDispatcher("/board/readPage?bno="+bNo);
					request.setAttribute("message", "공지사항은 관리자만 수정과 삭제가 가능합니다.");
					rd.forward(request, response);
					return false;
				}else if(bGrade!=2){//일반글
					if(memberVo.getmNo() != mNo) {//사용자와 작성자 불일치
						RequestDispatcher rd = request.getRequestDispatcher("/board/readPage?bno="+bNo);
						request.setAttribute("message", "작성자가 아니면 수정과 삭제가 불가능합니다.");
						rd.forward(request, response);
						return false;
					}					
				}
			}
			/*if(memberVo.getmGrade() != 2 && bGrade == 2) {
				RequestDispatcher rd = request.getRequestDispatcher("/board/readPage?bno="+bNo);
				request.setAttribute("message", "관리자가 아니면 수정과 삭제가 불가능합니다.");
				rd.forward(request, response);
				return false;
			}else{
			 	if(memberVo.getmNo() != mNo && memberVo.getmGrade() !=2) {
					RequestDispatcher rd = request.getRequestDispatcher("/board/readPage?bno="+bNo);
					request.setAttribute("message", "작성자가 아니면 수정과 삭제가 불가능합니다.");
					rd.forward(request, response);
					return false;
				}
			}*/
		}
		
		request.setAttribute("bNo", bNo);
		return true;
		
		/*HttpSession session = request.getSession();
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
		return true;*/
		
	}
	
	

}
