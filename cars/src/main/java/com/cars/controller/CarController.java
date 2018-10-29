package com.cars.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cars.service.CarService;
import com.cars.vo.CarVo;

@Controller
@RequestMapping("/car/*")
public class CarController {
	
	@Inject
	CarService service;
	
	@RequestMapping(value="/carInfo", method=RequestMethod.GET)
	public void carInfo(@RequestParam("carNo") int carNo, Model model) throws Exception{
		CarVo carVo = service.getCarInfo(carNo);
		model.addAttribute("car",carVo);
	}
	
	@RequestMapping(value="/searchComp", method=RequestMethod.GET)
	public String searchComp(@RequestParam("carComp") String carComp, Model model) throws Exception{
		List<CarVo> listLambo = service.searchComp(carComp);
		model.addAttribute("carList",listLambo);
		return "home";
	}
	
	@RequestMapping(value="/allCar", method=RequestMethod.GET)
	public String allCar(Model model) throws Exception{
		List<CarVo> listLambo = service.allCar();
		model.addAttribute("carList",listLambo);
		return "home";
	}

}


