package com.cars.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cars.dao.MemberDao;
import com.cars.dto.LoginDTO;
import com.cars.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDao dao;
	
	@Override
	public MemberVo login(LoginDTO loginDTO) throws Exception {
		
		return dao.login(loginDTO);
	}
	
	@Override
	public MemberVo getUser(String uid) throws Exception {
		
		return dao.getUser(uid);
	}
	
}
