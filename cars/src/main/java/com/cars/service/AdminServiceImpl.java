package com.cars.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cars.dao.MemberDao;
import com.cars.vo.MemberVo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	MemberDao dao;
	
	@Override
	public List<MemberVo> getMemberList() throws Exception{
		
		return dao.getMemberList();
	}

	
}
