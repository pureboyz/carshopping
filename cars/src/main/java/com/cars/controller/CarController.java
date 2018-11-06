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
import com.cars.vo.BuyInfoVo;
import com.cars.vo.BuyVo;
import com.cars.vo.CarVo;
import com.cars.vo.MemberVo;
import com.cars.vo.PageMaker;

@Controller
@RequestMapping("/car/*")
public class CarController {
	
	@Inject
	CarService service;
	
	@RequestMapping(value="/carInfo", method=RequestMethod.GET)
	public void carInfo(@RequestParam("currentPage") int currentPage, @RequestParam("carNo") int carNo, Model model, HttpServletRequest request) throws Exception{
		System.out.println(currentPage);
		int countPerPage = 10;
		request.setAttribute("carNo", carNo);
		PageMaker pageMaker = service.getPageMaker(currentPage,countPerPage,request);
		pageMaker.setCno(carNo);
		System.out.println("replyPageMaker : "+pageMaker);
		HttpSession session = request.getSession();
		session.setAttribute("replyPageMaker", pageMaker);
		
		CarVo carVo = service.getCarInfo(carNo);
		model.addAttribute("car",carVo);
	}
	
	@RequestMapping(value="/searchComp", method=RequestMethod.GET)
	public String searchComp(@RequestParam("carComp") String carComp, Model model) throws Exception{
		List<CarVo> carList = service.searchComp(carComp);
		model.addAttribute("carList",carList);
		return "home";
	}
	
	@RequestMapping(value="/allCar", method=RequestMethod.GET)
	public String allCar(Model model) throws Exception{
		List<CarVo> carList = service.allCar();
		model.addAttribute("carList",carList);
		return "home";
	}
	
	
	@RequestMapping(value="/buyCar", method=RequestMethod.GET)
	public String buyCar(@RequestParam("carNo") int carNo, @RequestParam("mNo") int mNo, RedirectAttributes rttr) throws Exception{
		int success = service.buyCar(carNo,mNo);
		if(success == 1) {
			rttr.addFlashAttribute("message", "구매 완료!!!");
		}
		return "redirect:/car/buyInfo?currentPage=1";
	}
	
	@RequestMapping(value="/basketCar", method=RequestMethod.GET)
	public String basketCar(@RequestParam("carNo") int carNo, @RequestParam("mNo") int mNo, RedirectAttributes rttr) throws Exception {
		BuyVo buyVo = new BuyVo();
		buyVo.setmNo(mNo);
		buyVo.setCarNo(carNo);
		int success = service.basketCar(buyVo);
		if(success == 1) {
			rttr.addFlashAttribute("message", "장바구니에 상품을 담았습니다.");
		}
		return "redirect:/car/buyInfo?currentPage=1";
	}
	
	@RequestMapping(value="/buyInfo", method=RequestMethod.GET)
	public void buyInfo(@RequestParam("currentPage") int currentPage, @RequestParam("basketCurrentPage") int basketCurrentPage, HttpSession session, HttpServletRequest request) throws Exception{
		MemberVo memberVo =  (MemberVo)session.getAttribute("loginMember");
		if(memberVo != null) {
			int mno = memberVo.getmNo();
			int countPerPage = 5;
			
			PageMaker basketPageMaker = service.getBasketPageMaker(basketCurrentPage,countPerPage,request);
			basketPageMaker.setMno(mno);
			List<BuyInfoVo> basketList = service.getBasketCar(basketPageMaker);
			session.setAttribute("basketList", basketList);
			session.setAttribute("basketPageMaker", basketPageMaker);
			
			PageMaker pageMaker = service.getPageMaker(currentPage,countPerPage,request);
			pageMaker.setMno(mno);
			System.out.println("pageMaker : "+pageMaker);
			session.setAttribute("pageMaker", pageMaker);
			List<BuyInfoVo> cList = service.getBuyCar(pageMaker);
			session.setAttribute("cList", cList);
		}
	}
	
	@RequestMapping(value="/basketToBuy", method=RequestMethod.GET)
	public String basketToBuy(@RequestParam("orderNo") int orderNo, RedirectAttributes rttr) throws Exception{
		int success = service.basketToBuy(orderNo);
		if(success == 1) {
			rttr.addFlashAttribute("message", "구매 완료!!!");
		}
		return "redirect:/car/buyInfo?currentPage=1";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@RequestParam("keyword") String keyword, Model model) throws Exception{
		List<CarVo> searchCar = service.searchCar(keyword);
		if(searchCar.size() > 0) {
			model.addAttribute("carList",searchCar);
		}else {
			model.addAttribute("message","검색결과가 없습니다.");
		}
		return "home";
	}
	
	@RequestMapping(value="/deleteBuy", method=RequestMethod.GET)
	public String deleteBuy(@RequestParam("orderNo") int orderNo, RedirectAttributes rttr) throws Exception{
		int success = service.deleteBuy(orderNo);
		if(success == 1) {
			rttr.addFlashAttribute("message","구매내역이 삭제 되었습니다.");
		}
		return "redirect:/car/buyInfo?currentPage=1";
	}
	
	@RequestMapping(value="/deleteBasket", method=RequestMethod.GET)
	public String deleteBasket(@RequestParam("orderNo") int orderNo, RedirectAttributes rttr) throws Exception{
		int success = service.deleteBasket(orderNo);
		if(success == 1) {
			rttr.addFlashAttribute("message", "취소 완료!!!");
		}
		return "redirect:/car/buyInfo?currentPage=1";
	}
	
	/*@ResponseBody
	@RequestMapping("/d3Data")
	public ArrayList<D3Data> testD3(){
		ArrayList<D3Data> list = new ArrayList<>();
		D3Data d3 = new D3Data();
		d3.setState("몰라몰라");
		FreqData data = new FreqData();
		data.setLow(1);
		data.setMid(2);
		data.setHigh(3);
		d3.setFreq(data);
		list.add(d3);
		return list;
	}*/
	

}


