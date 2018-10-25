package com.cars.service;

import java.util.List;

import com.cars.vo.CarVo;

public interface CarService {

	List<CarVo> getCar() throws Exception;

	CarVo getCarInfo(int carNo) throws Exception;

	List<CarVo> searchComp(String carComp) throws Exception;

}
