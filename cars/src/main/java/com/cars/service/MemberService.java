package com.cars.service;

import com.cars.dto.LoginDTO;
import com.cars.vo.MemberVo;

public interface MemberService {

	MemberVo login(LoginDTO loginDTO) throws Exception;

	MemberVo getUser(String uid) throws Exception;
}
