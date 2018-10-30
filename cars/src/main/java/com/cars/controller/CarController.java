package com.cars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.service.CarService;
import com.cars.vo.CarVo;
import com.cars.vo.D3Data;
import com.cars.vo.FreqData;

@Controller
@RequestMapping("/car/*")
public class CarController {
	
	@Inject
	CarService service;
	
	@RequestMapping(value="/carInfo", method=RequestMethod.GET)
	public void carInfo(@RequestParam("carNo") int carNo, Model model) throws Exception{
		CarVo carVo = service.getCarInfo(carNo);
		model.addAttribute("car",carVo);
	}
	
	@RequestMapping(value="/searchComp", method=RequestMethod.GET)
	public String searchComp(@RequestParam("carComp") String carComp, Model model) throws Exception{
		List<CarVo> listLambo = service.searchComp(carComp);
		model.addAttribute("carList",listLambo);
		return "home";
	}
	
	@RequestMapping(value="/allCar", method=RequestMethod.GET)
	public String allCar(Model model) throws Exception{
		List<CarVo> listLambo = service.allCar();
		model.addAttribute("carList",listLambo);
		return "home";
	}
	
	
	@RequestMapping(value="/buyCar", method=RequestMethod.GET)
	public String buyCar(@RequestParam("carNo") int carNo, @RequestParam("mNo") int mNo, RedirectAttributes rttr, Model model) throws Exception{
		
		System.out.println("buyCar");
		System.out.println(carNo);
		System.out.println(mNo);
		service.buyCar(carNo,mNo);
		
		rttr.addFlashAttribute("message", "구매 완료!!!");
		
		/*List<CarVo> list = service.getCar();
		rttr.addAttribute("carList",list);*/
		
		return "redirect:/car/buyInfo";
	}
	
	@RequestMapping(value="/buyInfo", method=RequestMethod.GET)
	public void buyInfo() {}
	
	@ResponseBody
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
	}
	

}


