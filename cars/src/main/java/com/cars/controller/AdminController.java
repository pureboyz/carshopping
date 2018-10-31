package com.cars.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		List<MemberVo> memberList = service.getMemberList();
		model.addAttribute("memberList",memberList);		
	}
	
	@RequestMapping(value="/modifyMember", method=RequestMethod.POST)
	public void modifymMember() {
		
	}
	
}
