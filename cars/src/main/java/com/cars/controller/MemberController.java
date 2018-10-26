package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cars.dto.LoginDTO;
import com.cars.service.CarService;
import com.cars.vo.CarVo;
import com.cars.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	CarService service;
	
	@RequestMapping(value = "/login")
	public void login() {
		
	}
	
	@RequestMapping(value = "/loginPost",method=RequestMethod.POST)
	public String loginPOST(LoginDTO dto, Model model) throws Exception {
		List<CarVo> carList = service.getCar();
		model.addAttribute("carList", carList);
		System.out.println(dto);
		model.addAttribute("loginDTO",dto);
		
		
		return "/home";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join() {
		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public void joinPOST() {
		
	}
	
	
	@RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
	public void memberInfo() {
		
	}
}
