package com.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
		
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join() {
		
	}
	
	@RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
	public void memberInfo() {
		
	}
}