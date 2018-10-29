package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value="/buyCar", method=RequestMethod.GET)
	public String buyCar(@RequestParam("carNo") int carNo, @RequestParam("mNo") int mNo, HttpServletRequest request, Model model) throws Exception{
		
		System.out.println("buyCar");
		System.out.println(carNo);
		System.out.println(mNo);
		service.buyCar(carNo,mNo);
		
		request.setAttribute("message", "구매 완료!!!");
		
		List<CarVo> list = service.getCar();
		model.addAttribute("carList",list);
		
		return "home";
	}

}


