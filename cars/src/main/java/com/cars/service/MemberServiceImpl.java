package com.cars.service;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.util.WebUtils;

import com.cars.dao.MemberDao;
import com.cars.dto.LoginDTO;
import com.cars.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDao dao;
	
	@Override
	public MemberVo login(LoginDTO LoginDTO) throws Exception {
		return dao.login(LoginDTO);
	}

	@Override
	public MemberVo getUser(String mId) throws Exception {
		return dao.getUser(mId);
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			session.removeAttribute("loginMember");
			session.invalidate();
		}
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			Cookie cookie = new Cookie("loginCookie", "");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}

	@Override
	public void join(MemberVo vo) throws Exception {
		dao.join(vo);		
	}

	@Override
	public void modify(MemberVo memberVo) throws Exception {
		dao.modify(memberVo);		
	}
	
	
	
}
