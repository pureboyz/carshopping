package com.cars.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cars.dao.CarDao;
import com.cars.vo.BuyInfoVo;
import com.cars.vo.BuyVo;
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
	public int buyCar(int carNo, int mNo) throws Exception {
		Map<String,Integer> map = new HashMap<>();
		map.put("mNo", mNo);
		map.put("carNo", carNo);
		
		int success = dao.buyCar(map);
		dao.saleCountUp(carNo);
		
		return success;
	}

	@Override
	public List<BuyInfoVo> getBuyCar(int mno) throws Exception {
		return dao.getBuyInfo(mno);
	}

	@Override
	public List<CarVo> searchCar(String keyword) throws Exception {
		if(keyword.equals("람보르기니")) {
			keyword = "lamborghini";
		}else if(keyword.equals("벤츠")) {
			keyword = "benz";
		}else if(keyword.equals("아우디")) {
			keyword = "audi";
		}else if(keyword.equals("도요타")) {
			keyword = "toyota";
		}else if(keyword.equals("현대")) {
			keyword = "hyundai";
		}
		System.out.println(keyword);
		return dao.searchCar(keyword);
	}

	@Override
	public int deleteBuy(BuyVo buyVo) throws Exception {
		int success = dao.deleteBuy(buyVo);
		return success;
	}

}
