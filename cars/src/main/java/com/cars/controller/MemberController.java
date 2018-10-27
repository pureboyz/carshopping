package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cars.dto.LoginDTO;
import com.cars.service.CarService;
import com.cars.service.MemberService;
import com.cars.vo.CarVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	CarService cService;
	@Inject
	MemberService mService;
	
	@RequestMapping(value = "/login")
	public void login() {}
	
	@RequestMapping(value = "/loginPost",method=RequestMethod.POST)
	public String loginPOST(LoginDTO dto, Model model) throws Exception {
		List<CarVo> carList = cService.getCar();
		model.addAttribute("carList", carList);
		
		return "/home";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join() {}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public void joinPOST() {}
	
	
	@RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
	public void memberInfo() {}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		mService.logout(request, response);
		
		List<CarVo> carList = cService.getCar();
		model.addAttribute("carList", carList);
		
		return "home";
	}
}
