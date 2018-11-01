package com.cars.vo;

import java.util.Date;

public class BuyInfoVo {

	int orderNo;
	int carNo;
	String carName;
	int carPrice;
	String carComp;
	int carCC;
	double carEff;
	String carSize;
	String carFuel;
	int carsale;
	Date orderDate;
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "BuyInfoVo [orderNo=" + orderNo + ", carNo=" + carNo + ", carName=" + carName + ", carPrice=" + carPrice
				+ ", carComp=" + carComp + ", carCC=" + carCC + ", carEff=" + carEff + ", carSize=" + carSize
				+ ", carFuel=" + carFuel + ", carsale=" + carsale + ", orderDate=" + orderDate + "]";
	}
	
	
}
