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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.service.AdminService;
import com.cars.vo.D3Data;
import com.cars.vo.FuelAndSizeVo;
import com.cars.vo.MemberVo;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Inject
	AdminService service;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void admin() {}
	
	@RequestMapping(value="/memberManagement", method=RequestMethod.GET)
	public void memberManagement(Model model,HttpSession session) throws Exception {
		System.out.println("회원 관리 페이지");
		//System.out.println(session.getAttribute("loginMember"));
		List<MemberVo> memberList = service.getMemberList();
		model.addAttribute("memberList",memberList);		
	}
	
	@RequestMapping(value="/modifyMemberPOST", method=RequestMethod.POST)
	public String modifyMemberPOST(@RequestParam("mNo")int mNo,
								@RequestParam("mGrade")int mGrade,RedirectAttributes rttr
								/*,MemberVo memberVo*/) throws Exception {
		System.out.println("mno : "+mNo+" mGrade : "+mGrade);
		MemberVo memberVo = new MemberVo();
		memberVo.setmGrade(mGrade);
		memberVo.setmNo(mNo);
		service.modifyMember(memberVo);
		rttr.addFlashAttribute("message", "등급 수정 완료");
		return "redirect:/admin/memberManagement";
	}	
	
	/*@RequestMapping(value="/modifyMember", method=RequestMethod.GET)
	public String modifyMember(Model model,MemberVo memberVo) throws Exception {
		System.out.println("컨트롤러 테스트 : " + memberVo);
		service.modifyMember(memberVo);
		model.addAttribute("message", "등급 수정 완료");
		return "redirect:/admin/memberManagement";
	}*/
	
	@RequestMapping(value="/statistic")
	public void statistic(Model model,@RequestParam("comp") String comp) {
		model.addAttribute("comp", comp);
	}
	
	
	@RequestMapping(value="/statisticList")
	@ResponseBody
	public List<D3Data> statisticList() throws Exception{
		List<D3Data> list = service.getD3Data();
		return list;
	}
	
	@RequestMapping(value="/topByGenders")
	public void topByGenders() throws Exception{
		service.topByGenders();
	}
	
	@RequestMapping(value="/fuelAndSize", method=RequestMethod.GET)
	public void fuelAndSize() {}
	
	@RequestMapping(value="/getCountByFuel")
	@ResponseBody
	public List<FuelAndSizeVo> getCountByFuel() throws Exception{
		List<FuelAndSizeVo> fas = service.getCountByFuel();
		return fas;
	}
	
	@RequestMapping(value="/getCountBySize")
	@ResponseBody
	public List<FuelAndSizeVo> getCountBySize() throws Exception{
		List<FuelAndSizeVo> fas = service.getCountBySize();
		return fas;
	}
	
	@RequestMapping(value="/statisticBySize")
	public void statisticBySize() throws Exception{}
	
	@RequestMapping(value="/getCountByEff")
	@ResponseBody
	public List<FuelAndSizeVo> getCountByEff() throws Exception{
		List<FuelAndSizeVo> fas = service.getCountByEff();
		return fas;
	}
	
	@RequestMapping(value="/getCountByLook")
	@ResponseBody
	public List<FuelAndSizeVo> getCountByLook() throws Exception{
		List<FuelAndSizeVo> fas = service.getCountByLook();
		return fas;
	}
	
	@RequestMapping(value="/sales", method=RequestMethod.GET)
	public void sales(HttpServletRequest request) throws Exception{
		int totalSales = service.getTotalSales();
		System.out.println(totalSales);
		request.setAttribute("totalSales",totalSales);
	}
	
	@RequestMapping(value="/getSales")
	@ResponseBody
	public List<FuelAndSizeVo> getSales(HttpSession session) throws Exception{
		List<FuelAndSizeVo> fas = service.getSales(session);
		return fas;
	}
	
}
