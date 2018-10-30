package com.cars.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.cars.dto.LoginDTO;
import com.cars.vo.MemberVo;

public interface MemberService {

	MemberVo login(LoginDTO LoginDTO) throws Exception;

	MemberVo getUser(String mId) throws Exception;

	void logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

	void join(MemberVo vo) throws Exception;

	void modify(MemberVo memberVo) throws Exception;

}
