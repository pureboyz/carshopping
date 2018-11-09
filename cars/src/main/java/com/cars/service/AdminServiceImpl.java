package com.cars.service;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cars.dao.AdminDao;
import com.cars.dao.MemberDao;
import com.cars.vo.CarVo;
import com.cars.vo.D3Data;
import com.cars.vo.FreqData;
import com.cars.vo.FuelAndSizeVo;
import com.cars.vo.MemberVo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	MemberDao dao;
	@Inject
	AdminDao aDao;
	
	@Override
	public List<MemberVo> getMemberList() throws Exception{
		
		return dao.getMemberList();
	}

	@Override
	public void modifyMember(MemberVo memberVo) throws Exception {
		dao.modifyMember(memberVo);		
	}

	@Override
	public List<D3Data> getD3Data() throws Exception {
		ArrayList<D3Data> list = new ArrayList<>();
		D3Data lamborghini = new D3Data();
		D3Data benz = new D3Data();
		D3Data audi = new D3Data();
		D3Data bmw = new D3Data();
		D3Data toyota = new D3Data();
		D3Data hyundai = new D3Data();
		
		FreqData freqLam = new FreqData();
		FreqData freqBenz = new FreqData();
		FreqData freqAudi = new FreqData();
		FreqData freqBMW = new FreqData();
		FreqData freqTo = new FreqData();
		FreqData freqHyun = new FreqData();
		
		for(int i=2; i<=5; i++) {
			if(i == 2) {
				freqLam.setTwenties(aDao.lamborghiniByAges(i));
				freqBenz.setTwenties(aDao.benzByAges(i));
				freqAudi.setTwenties(aDao.audiByAges(i));
				freqBMW.setTwenties(aDao.bmwByAges(i));
				freqTo.setTwenties(aDao.toyotaByAges(i));
				freqHyun.setTwenties(aDao.hyundaiByAges(i));
			}else if(i == 3) {
				freqLam.setThirties(aDao.lamborghiniByAges(i));
				freqBenz.setThirties(aDao.benzByAges(i));
				freqAudi.setThirties(aDao.audiByAges(i));
				freqBMW.setThirties(aDao.bmwByAges(i));
				freqTo.setThirties(aDao.toyotaByAges(i));
				freqHyun.setThirties(aDao.hyundaiByAges(i));
			}else if(i == 4) {
				freqLam.setForties(aDao.lamborghiniByAges(i));
				freqBenz.setForties(aDao.benzByAges(i));
				freqAudi.setForties(aDao.audiByAges(i));
				freqBMW.setForties(aDao.bmwByAges(i));
				freqTo.setForties(aDao.toyotaByAges(i));
				freqHyun.setForties(aDao.hyundaiByAges(i));
			}else if(i == 5) {
				freqLam.setFifties(aDao.lamborghiniByAges(i));
				freqBenz.setFifties(aDao.benzByAges(i));
				freqAudi.setFifties(aDao.audiByAges(i));
				freqBMW.setFifties(aDao.bmwByAges(i));
				freqTo.setFifties(aDao.toyotaByAges(i));
				freqHyun.setFifties(aDao.hyundaiByAges(i));
			}
		}
		
		int overSixtyLam = aDao.lambirghiniTotal() - (freqLam.getTwenties()+freqLam.getThirties()+freqLam.getForties()+freqLam.getFifties());
		int overSixtyBenz = aDao.benzTotal() - (freqBenz.getTwenties()+freqBenz.getThirties()+freqBenz.getForties()+freqBenz.getFifties());
		int overSixtyAudi = aDao.audiTotal() - (freqAudi.getTwenties()+freqAudi.getThirties()+freqAudi.getForties()+freqAudi.getFifties());
		int overSixtyBMW = aDao.bmwTotal() - (freqBMW.getTwenties()+freqBMW.getThirties()+freqBMW.getForties()+freqBMW.getFifties());
		int overSixtyTo = aDao.toyotaTotal() - (freqTo.getTwenties()+freqTo.getThirties()+freqTo.getForties()+freqTo.getFifties());
		int overSixtyHyun = aDao.hyundaiTotal() - (freqHyun.getTwenties()+freqHyun.getThirties()+freqHyun.getForties()+freqHyun.getFifties());
		freqLam.setOverSixty(overSixtyLam);
		freqBenz.setOverSixty(overSixtyBenz);
		freqAudi.setOverSixty(overSixtyAudi);
		freqBMW.setOverSixty(overSixtyBMW);
		freqTo.setOverSixty(overSixtyTo);
		freqHyun.setOverSixty(overSixtyHyun);
		
		lamborghini.setFreq(freqLam);
		lamborghini.setState("LAMBORGHINI");
		benz.setFreq(freqBenz);
		benz.setState("BENZ");
		audi.setFreq(freqAudi);
		audi.setState("AUDI");
		bmw.setFreq(freqBMW);
		bmw.setState("BMW");
		toyota.setFreq(freqTo);
		toyota.setState("TOYOTA");
		hyundai.setFreq(freqHyun);
		hyundai.setState("HYUNDAI");
		
		list.add(0, lamborghini);
		list.add(1, benz);
		list.add(2, audi);
		list.add(3, bmw);
		list.add(4, toyota);
		list.add(5, hyundai);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		return list;
	}
	

	@Override
	public void topByGenders() throws Exception {
		List<CarVo> cv1 = new ArrayList<>();
		List<CarVo> cv2 = new ArrayList<>();
		
		for(int i=1; i<=2; i++) {
			if(i == 1) {
				cv1 = aDao.genderCompany(i);
				System.out.println(cv1);
			}else if(i == 2){
				cv2 = aDao.genderCompany(i);
				System.out.println(cv2);
			}
		}
		
		FileOutputStream fos;
		PrintStream ps;
		
		fos = new FileOutputStream("C:\\Users\\user\\git\\carshopping\\cars\\src\\main\\webapp\\resources\\data\\topByGenders.tsv");
		ps = new PrintStream(fos);
		ps.println("name\tvalue");
		ps.println(cv1.get(0).getCarName()+"\t"+((-1)*cv1.get(0).getCarsale()));
		ps.println(cv1.get(1).getCarName()+"\t"+((-1)*cv1.get(1).getCarsale()));
		ps.println(cv1.get(2).getCarName()+"\t"+((-1)*cv1.get(2).getCarsale()));
		ps.println(cv1.get(3).getCarName()+"\t"+((-1)*cv1.get(3).getCarsale()));
		ps.println(cv2.get(0).getCarName()+"\t"+(cv2.get(0).getCarsale()));
		ps.println(cv2.get(1).getCarName()+"\t"+(cv2.get(1).getCarsale()));
		ps.println(cv2.get(2).getCarName()+"\t"+(cv2.get(2).getCarsale()));
		ps.println(cv2.get(3).getCarName()+"\t"+(cv2.get(3).getCarsale()));
		
		ps.close();
		fos.close();
		
	}

	@Override
	public List<FuelAndSizeVo> getCountByFuel() throws Exception {
		List<FuelAndSizeVo> fasList = new ArrayList<>();
		
		fasList.add(getFasByFuel("디젤"));
		fasList.add(getFasByFuel("휘발유"));
		fasList.add(getFasByFuel("하이브리드"));
		
		FuelAndSizeVo fasEtc = new FuelAndSizeVo();
		int allCount = aDao.allCount();
		int etcCount = allCount - fasList.get(0).getCount() - fasList.get(1).getCount() - fasList.get(2).getCount();
		fasEtc.setName("기타");
		fasEtc.setCount(etcCount);
		fasList.add(fasEtc);
		
		return fasList;
	}
	
	public FuelAndSizeVo getFasByFuel(String str) throws Exception{
		FuelAndSizeVo fas = new FuelAndSizeVo();
		fas.setName(str);
		fas.setCount(aDao.getCountByFuel(str));
		return fas;
	}

	@Override
	public List<FuelAndSizeVo> getCountBySize() throws Exception {
		List<FuelAndSizeVo> fasList = new ArrayList<>();
		
		fasList.add(getFasBySize("대"));
		fasList.add(getFasBySize("중"));
		fasList.add(getFasBySize("소"));
		fasList.add(getFasBySize("스포츠"));
		
		return fasList;
	}
	
	public FuelAndSizeVo getFasBySize(String str) throws Exception{
		FuelAndSizeVo fas = new FuelAndSizeVo();
		fas.setName(str+"형");
		fas.setCount(aDao.getCountBySize(str));
		return fas;
	}

	@Override
	public List<FuelAndSizeVo> getCountByEff() throws Exception {
		List<FuelAndSizeVo> fasList = new ArrayList<>();
		
		FuelAndSizeVo fasTen = new FuelAndSizeVo();
		FuelAndSizeVo fasFif = new FuelAndSizeVo();
		FuelAndSizeVo fasTwen = new FuelAndSizeVo();
		FuelAndSizeVo fasOverTwen = new FuelAndSizeVo();
		
		int allCount = aDao.allCount();
		int tenCount = aDao.getCountByEff(10.0);
		int fifCount = aDao.getCountByEff(15.0) - tenCount;
		int twenCount = aDao.getCountByEff(20.0) - fifCount - tenCount;
		int overTwenCount = allCount - twenCount  - fifCount - tenCount;
		
		fasTen.setName("연비 5이하");
		fasTen.setCount(tenCount);
		fasFif.setName("연비 10~15");
		fasFif.setCount(fifCount);
		fasTwen.setName("연비 15~20");
		fasTwen.setCount(twenCount);
		fasOverTwen.setName("연비 20이상");
		fasOverTwen.setCount(overTwenCount);
		
		fasList.add(fasTen);
		fasList.add(fasFif);
		fasList.add(fasTwen);
		fasList.add(fasOverTwen);
		
		return fasList;
	}

	@Override
	public List<FuelAndSizeVo> getCountByLook() throws Exception {
		List<FuelAndSizeVo> fasList = new ArrayList<>();
		
		fasList.add(getFasByLook("세단"));
		fasList.add(getFasByLook("SUV"));
		fasList.add(getFasByLook("스포츠카"));
		
		return fasList;
	}
	
	public FuelAndSizeVo getFasByLook(String str) throws Exception{
		FuelAndSizeVo fas = new FuelAndSizeVo();
		fas.setName(str);
		fas.setCount(aDao.getCountByLook(str));
		return fas;
	}

	@Override
 	public List<FuelAndSizeVo> getSales(HttpSession session) throws Exception {
		List<FuelAndSizeVo> fas = new ArrayList<FuelAndSizeVo>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		
		boolean isToday = false;
		for(int i=18;; i++) {
			for(int j=1; j<=12; j++) {
				for(int k=1; k<=31; k++) {
					if(j < 10 && 10 <= k) {
						isToday = isToday(today, i+"-0"+j+"-"+k);
						FuelAndSizeVo fasVo = getFasVo("20"+i+"-0"+j+"-"+k);
						if(fasVo != null) {
							fas.add(fasVo);
						}
					}else if(10 <= j && k < 10) {
						isToday = isToday(today, i+"-"+j+"-0"+k);
						FuelAndSizeVo fasVo = getFasVo("20"+i+"-"+j+"-0"+k);
						if(fasVo != null) {
							fas.add(fasVo);
						}
					}else if(j < 10 && k < 10) {
						isToday = isToday(today, i+"-0"+j+"-0"+k);
						FuelAndSizeVo fasVo = getFasVo("20"+i+"-0"+j+"-0"+k);
						if(fasVo != null) {
							fas.add(fasVo);
						}
					}else if(10 <= j && 10 <= k){
						isToday = isToday(today, i+"-"+j+"-"+k);
						FuelAndSizeVo fasVo = getFasVo("20"+i+"-"+j+"-"+k);
						if(fasVo != null) {
							fas.add(fasVo);
						}
					}
					
					if(isToday == true) {
						break;
					}
				}
				
				if(isToday == true) {
					break;
				}
			}
			
			if(isToday == true) {
				break;
			}
		}
		
		return fas;
	}
	
	public FuelAndSizeVo getFasVo(String str) throws Exception{
		FuelAndSizeVo fasVo = new FuelAndSizeVo();
		String sales = aDao.getSales(str);
		if(sales != null && sales != "") {
			fasVo.setName(str);
			fasVo.setCount(Integer.parseInt(sales)/10);
			return fasVo;
		}
		return null;
	}
	
	public boolean isToday(String today, String str) {
		if((str).equals(today)) {
			return true;
		}
		return false;
	}

	@Override
	public int getTotalSales() throws Exception {
		return aDao.getTotalSales();
	}

}
