package com.cars.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cars.dao.CarDao;
import com.cars.vo.CarVo;

@Service
public class CarServiceImpl implements CarService{

	@Inject
	CarDao dao;
	
	@Override
	public List<CarVo> getCar() throws Exception {
		return dao.getCar();
	}

	@Override
	public CarVo getCarInfo(int carNo) throws Exception {
		return dao.getCarInfo(carNo);
	}

	@Override
	public List<CarVo> searchComp(String carComp) throws Exception {
		return dao.searchComp(carComp);
	}

	@Override
	public List<CarVo> allCar() throws Exception {
		return dao.allCar();
	}

}
