package com.cars.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cars.service.AdminService;
import com.cars.vo.CarVo;
import com.cars.vo.MemberVo;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Inject
	AdminService service;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void admin() {}
	
	@RequestMapping(value="/memberManagement", method=RequestMethod.GET)
	public void memberManagement(Model model) throws Exception {
		System.out.println("회원 관리 페이지");
		List<MemberVo> memberList = service.getMemberList();
		model.addAttribute("memberList",memberList);		
	}
	
	@RequestMapping(value="/modifyMember", method=RequestMethod.GET)
	public String modifyMember(Model model,MemberVo memberVo) throws Exception {
		System.out.println("컨트롤러 테스트 : " + memberVo);
		service.modifyMember(memberVo);
		model.addAttribute("message", "등급 수정 완료");
		return "redirect:/admin/memberManagement";
	}
	
}
