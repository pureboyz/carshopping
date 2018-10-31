package com.cars.service;

import java.util.List;

import com.cars.vo.BuyInfoVo;
import com.cars.vo.BuyVo;
import com.cars.vo.CarVo;

public interface CarService {

	List<CarVo> getCar() throws Exception;

	CarVo getCarInfo(int carNo) throws Exception;

	List<CarVo> searchComp(String carComp) throws Exception;

	List<CarVo> allCar() throws Exception;

	int buyCar(int carNo, int mNo) throws Exception;

	List<BuyInfoVo> getBuyCar(int mno) throws Exception;

	List<CarVo> searchCar(String keyword) throws Exception;

	int deleteBuy(BuyVo buyVo) throws Exception;

}
