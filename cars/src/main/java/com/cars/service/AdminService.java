package com.cars.service;

import java.util.List;

import com.cars.vo.D3Data;
import com.cars.vo.FuelAndSizeVo;
import com.cars.vo.MemberVo;

public interface AdminService {

	List<MemberVo> getMemberList() throws Exception;

	void modifyMember(MemberVo memberVo) throws Exception;

	List<D3Data> getD3Data() throws Exception;

	void topByGenders() throws Exception;

	List<FuelAndSizeVo> getCountByFuel() throws Exception;

}
