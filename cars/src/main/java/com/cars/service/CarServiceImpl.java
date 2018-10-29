package com.cars.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void buyCar(int carNo, int mNo) throws Exception {
		System.out.println(carNo);
		System.out.println(mNo);
		Map<String,Integer> map = new HashMap<>();
		map.put("mNo", mNo);
		map.put("carNo", carNo);
		System.out.println("map의 mno : "+map.get("mNo"));
		System.out.println("map의 carno : "+map.get("carNo"));
		dao.buyCar(map);
		
	}

}
