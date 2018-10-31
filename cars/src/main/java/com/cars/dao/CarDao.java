package com.cars.dao;

import java.util.List;
import java.util.Map;

import com.cars.vo.BuyInfoVo;
import com.cars.vo.BuyVo;
import com.cars.vo.CarVo;

public interface CarDao {

	List<CarVo> getCar() throws Exception;

	CarVo getCarInfo(int carNo) throws Exception;

	List<CarVo> searchComp(String carComp) throws Exception;

	List<CarVo> allCar() throws Exception;

	int buyCar(Map<String, Integer> map) throws Exception;

	void saleCountUp(int carNo) throws Exception;

	List<BuyInfoVo> getBuyInfo(int mno) throws Exception;

	List<CarVo> searchCar(String keyword) throws Exception;

	int deleteBuy(BuyVo buyVo) throws Exception;


}
