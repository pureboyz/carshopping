package com.cars.dao;

import java.util.List;

import com.cars.vo.CarVo;
import com.cars.vo.SearchVo;

public interface AdminDao {

	int lamborghiniByAges(int i) throws Exception;

	int lambirghiniTotal() throws Exception;

	int benzByAges(int i) throws Exception;

	int audiByAges(int i) throws Exception;

	int bmwByAges(int i) throws Exception;

	int toyotaByAges(int i) throws Exception;

	int hyundaiByAges(int i) throws Exception;

	int benzTotal() throws Exception;

	int audiTotal() throws Exception;

	int bmwTotal() throws Exception;

	int toyotaTotal() throws Exception;

	int hyundaiTotal() throws Exception;

	List<CarVo> genderCompany(int i) throws Exception;

	int allCount() throws Exception;

	int getCountByFuel(String s) throws Exception;

	int getCountBySize(String s) throws Exception;

	int getCountByLook(String s) throws Exception;

	int getCountByEff(double i) throws Exception;

	String getSales(String string) throws Exception;

	int getTotalSales() throws Exception;

	int companyTotal(String company) throws Exception;

	int countBySearchVo(SearchVo searchVo) throws Exception;

}
