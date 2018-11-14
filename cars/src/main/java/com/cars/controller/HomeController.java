package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cars.service.CarService;
import com.cars.vo.CarVo;

@Controller
public class HomeController {

	@Inject
	CarService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest request) throws Exception{
		/*String path = request.getServletContext().getRealPath("/");
		System.out.println("path : "+path);*/
		List<CarVo> carList = service.getCar();
		model.addAttribute("carList",carList);
		return "home";
	}
	
	
	
}
