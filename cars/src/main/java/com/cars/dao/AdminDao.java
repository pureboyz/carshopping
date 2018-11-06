package com.cars.dao;

import java.util.List;

import com.cars.vo.CarVo;

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

}