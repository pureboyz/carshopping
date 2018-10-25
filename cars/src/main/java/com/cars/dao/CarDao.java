package com.cars.dao;

import java.util.List;

import com.cars.vo.CarVo;

public interface CarDao {

	List<CarVo> getCar() throws Exception;

	CarVo getCarInfo(int carNo) throws Exception;

	List<CarVo> searchComp(String carComp) throws Exception;

}
