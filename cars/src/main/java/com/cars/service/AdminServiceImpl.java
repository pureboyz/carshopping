package com.cars.service;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
		
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<FuelAndSizeVo> getCountByFuel() throws Exception {
		List<FuelAndSizeVo> fasList = new ArrayList<>();
		
		FuelAndSizeVo fasDiesel = new FuelAndSizeVo();
		FuelAndSizeVo fasGasoline = new FuelAndSizeVo();
		FuelAndSizeVo fasHy = new FuelAndSizeVo();
		FuelAndSizeVo fasEtc = new FuelAndSizeVo();
		
		int allCount = aDao.allCount();
		System.out.println("allCount : "+allCount);
		int dieselCount = aDao.getCountByFuel("디젤");
		System.out.println(dieselCount);
		int gasolineCount = aDao.getCountByFuel("가솔린");
		System.out.println(gasolineCount);
		int hyCount = aDao.getCountByFuel("하이브리드");
		System.out.println(hyCount);
		int etcCount = allCount - dieselCount - gasolineCount - hyCount;
		System.out.println(etcCount);
		
		fasDiesel.setName("경유");
		fasDiesel.setCount(dieselCount);
		fasGasoline.setName("휘발유");
		fasGasoline.setCount(gasolineCount);
		fasHy.setName("하이브리드");
		fasHy.setCount(hyCount);
		fasEtc.setName("기타");
		fasEtc.setCount(etcCount);
		
		fasList.add(fasGasoline);
		fasList.add(fasDiesel);
		fasList.add(fasHy);
		fasList.add(fasEtc);
		
		System.out.println(fasList.size());
		
		return fasList;
	}

}
