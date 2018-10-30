package com.cars.dao;

import java.util.List;

import com.cars.dto.LoginDTO;
import com.cars.vo.MemberVo;

public interface MemberDao {

	MemberVo login(LoginDTO LoginDTO)throws Exception;

	MemberVo getUser(String mId) throws Exception;

	void join(MemberVo vo) throws Exception;

	List<MemberVo> getMemberList() throws Exception;

	void modify(MemberVo memberVo) throws Exception;

	
	
}
