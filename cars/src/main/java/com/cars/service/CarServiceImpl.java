package com.cars.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cars.dao.CarDao;
import com.cars.dao.ReplyDao;
import com.cars.vo.BuyInfoVo;
import com.cars.vo.BuyVo;
import com.cars.vo.CarVo;
import com.cars.vo.MemberVo;
import com.cars.vo.PageMaker;

@Service
public class CarServiceImpl implements CarService{

	@Inject
	CarDao dao;
	@Inject
	ReplyDao replyDao;
	
	@Override
	public List<CarVo> getCar() throws Exception {
		return dao.getCar();
	}

	@Override
	public CarVo getCarInfo(int carNo) throws Exception {
		return dao.getCarInfo(carNo);
	}

	@Override
	public List<CarVo> searchComp(String carComp) throws Exception {
		return dao.searchComp(carComp);
	}

	@Override
	public List<CarVo> allCar() throws Exception {
		return dao.allCar();
	}

	@Override
	public int buyCar(int carNo, int mNo) throws Exception {
		Map<String,Integer> map = new HashMap<>();
		map.put("mNo", mNo);
		map.put("carNo", carNo);
		
		int success = dao.buyCar(map);
		dao.saleCountUp(carNo);
		
		return success;
	}

	@Override
	public List<BuyInfoVo> getBuyCar(PageMaker pageMaker) throws Exception {
		return dao.getBuyInfo(pageMaker);
	}

	@Override
	public List<CarVo> searchCar(String keyword) throws Exception {
		if(keyword.equals("람보르기니")) {
			keyword = "lamborghini";
		}else if(keyword.equals("벤츠")) {
			keyword = "benz";
		}else if(keyword.equals("아우디")) {
			keyword = "audi";
		}else if(keyword.equals("도요타")) {
			keyword = "toyota";
		}else if(keyword.equals("현대")) {
			keyword = "hyundai";
		}
		System.out.println(keyword);
		return dao.searchCar(keyword);
	}

	@Override
	public int deleteBuy(BuyVo buyVo) throws Exception {
		int success = dao.deleteBuy(buyVo);
		return success;
	}

	@Override
	public PageMaker getPageMaker(int currentPage, int countPerPage, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("loginMember");
		int mno = vo.getmNo();
		
		int cno = 0;
		if(request.getAttribute("carNo") != null) {
			cno = (int) request.getAttribute("carNo");
		}
		
		int displayPageNum = 10;
		
		PageMaker pageMaker = new PageMaker();
		
		
		int totalCount = 0;
		if(cno == 0) {
			totalCount = dao.getTotalCount(mno);
			pageMaker.setTotalCount(totalCount);
		}else{
			totalCount = replyDao.getTotalCount(cno);
			pageMaker.setTotalCount(totalCount);
		}
		System.out.println("cno : "+cno + "mno : "+mno);
		
		pageMaker.setCountPerPage(countPerPage);
		pageMaker.setCurrentPage(currentPage);
		
		int startPage = ((currentPage-1)/displayPageNum*displayPageNum)+1;
		pageMaker.setStartPage(startPage);
		
		int endPage = startPage+displayPageNum-1;
		if(endPage >= (((totalCount-1)/countPerPage)+1)) {
			pageMaker.setEndPage(((totalCount-1)/countPerPage)+1);
		}else {
			pageMaker.setEndPage(startPage+displayPageNum-1);
		}
		
		int start = ((currentPage-1)*countPerPage);
		pageMaker.setStart(start);
		
		pageMaker.setDisplayPageNum(displayPageNum);
		
		if(1 < currentPage) {
			pageMaker.setPrev(true);
		}else {
			pageMaker.setPrev(false);
		}
		
		if(currentPage < pageMaker.getEndPage()) {
			pageMaker.setNext(true);
		}else {
			pageMaker.setNext(false);
		}
		
		return pageMaker;
	}

}
