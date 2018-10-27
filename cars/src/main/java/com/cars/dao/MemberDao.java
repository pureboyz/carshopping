package com.cars.dao;

import com.cars.dto.LoginDTO;
import com.cars.vo.MemberVo;

public interface MemberDao {

	MemberVo login(LoginDTO LoginDTO)throws Exception;

	MemberVo getUser(String mId) throws Exception;
	
	
	
}
