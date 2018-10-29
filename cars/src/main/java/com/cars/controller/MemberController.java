package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.dto.LoginDTO;
import com.cars.service.CarService;
import com.cars.service.MemberService;
import com.cars.vo.CarVo;
import com.cars.vo.MemberVo;

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
	public String loginPOST(LoginDTO dto, Model model, HttpServletRequest request) throws Exception {
		List<CarVo> carList = cService.getCar();
		model.addAttribute("carList", carList);
		request.setAttribute("message", "로그인 성공!");
		
		return "/home";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join() {}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVo vo,RedirectAttributes rttr) throws Exception {
		mService.join(vo);
		rttr.addFlashAttribute("message", "회원가입완료");		
		
		return "redirect:/member/login";
	}
	
	
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
