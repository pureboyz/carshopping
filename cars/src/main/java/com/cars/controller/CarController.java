package com.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/car/*")
public class CarController {
	
	@RequestMapping(value="/carInfo", method=RequestMethod.GET)
	public void carInfo() {}

}
