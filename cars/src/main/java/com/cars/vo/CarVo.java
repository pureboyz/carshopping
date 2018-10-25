package com.cars.vo;

public class CarVo {

	int carNo;
	String carName;
	int carPrice;
	String carComp;
	int carCC;
	double carEff;
	String carSize;
	String carFuel;
	int carsale;
	
	public int getCarNo() {
		return carNo;
	}
	
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	
	public String getCarName() {
		return carName;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public int getCarPrice() {
		return carPrice;
	}
	
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	public String getCarComp() {
		return carComp;
	}
	
	public void setCarComp(String carComp) {
		this.carComp = carComp;
	}
	
	public int getCarCC() {
		return carCC;
	}
	
	public void setCarCC(int carCC) {
		this.carCC = carCC;
	}
	
	public double getCarEff() {
		return carEff;
	}
	
	public void setCarEff(double carEff) {
		this.carEff = carEff;
	}
	
	public String getCarSize() {
		return carSize;
	}
	
	public void setCarSize(String carSize) {
		this.carSize = carSize;
	}
	
	public String getCarFuel() {
		return carFuel;
	}
	
	public void setCarFuel(String carFuel) {
		this.carFuel = carFuel;
	}
	
	public int getCarsale() {
		return carsale;
	}
	
	public void setCarsale(int carsale) {
		this.carsale = carsale;
	}

	@Override
	public String toString() {
		return "차정보 [모델번호=" + carNo + ", 모델명=" + carName + ", 모델가격=" + carPrice + ", 모델상표=" + carComp
				+ ", 모델배기량=" + carCC + ", 모델연비=" + carEff + ", 모델크기=" + carSize + ", 모델연료=" + carFuel
				+ ", 모델판매량=" + carsale + "]";
	}

	

}
