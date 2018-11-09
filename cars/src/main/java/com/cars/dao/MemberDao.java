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

	MemberVo getMember(int mNo) throws Exception;

	void modifyMember(MemberVo memberVo) throws Exception;//관리자의 회원등급수정
	//void modifyMember(int mNo, int mGrade) throws Exception;

	
	
}
