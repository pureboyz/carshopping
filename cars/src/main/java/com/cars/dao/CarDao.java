package com.cars.dao;

import java.util.List;
import java.util.Map;

import com.cars.vo.BuyInfoVo;
import com.cars.vo.BuyVo;
import com.cars.vo.CarVo;
import com.cars.vo.PageMaker;

public interface CarDao {

	List<CarVo> getCar() throws Exception;

	CarVo getCarInfo(int carNo) throws Exception;

	List<CarVo> searchComp(String carComp) throws Exception;

	List<CarVo> allCar() throws Exception;

	int buyCar(Map<String, Integer> map) throws Exception;

	void saleCountUp(int carNo) throws Exception;

	List<BuyInfoVo> getBuyInfo(PageMaker pageMaker) throws Exception;

	List<CarVo> searchCar(String keyword) throws Exception;

	int deleteBuy(int orderNo) throws Exception;

	int getTotalCount(int mno) throws Exception;

	int basketCar(BuyVo buyVo) throws Exception;

	List<BuyInfoVo> getBasketCar(PageMaker pageMaker) throws Exception;

	int basketToBuy(int orderNo) throws Exception;

	int deleteBasket(int orderNo) throws Exception;

	int getBasketTotalCount(int mno) throws Exception;
	
	
}
