package com.cars.service;

import java.util.List;

import com.cars.vo.MemberVo;

public interface AdminService {

	List<MemberVo> getMemberList() throws Exception;

}
