package com.cars.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cars.vo.D3Data;
import com.cars.vo.FuelAndSizeVo;
import com.cars.vo.MemberVo;

public interface AdminService {

	List<MemberVo> getMemberList() throws Exception;

	void modifyMember(MemberVo memberVo) throws Exception;

	List<D3Data> getD3Data() throws Exception;

	void statisticByGenders() throws Exception;

	List<FuelAndSizeVo> getCountByFuel() throws Exception;

	List<FuelAndSizeVo> getCountBySize() throws Exception;

	List<FuelAndSizeVo> getCountByEff() throws Exception;

	List<FuelAndSizeVo> getCountByLook() throws Exception;

	List<FuelAndSizeVo> getSales(HttpSession session) throws Exception;

	int getTotalSales() throws Exception;

}
