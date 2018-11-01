package com.cars.vo;

import java.util.Date;

public class BuyVo {
	
	int orderNo;
	int carNo;
	int mNo;
	Date orderDate;
	int isBuy;
	
	public int getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(int isBuy) {
		this.isBuy = isBuy;
	}
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
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "BuyVo [orderNo=" + orderNo + ", carNo=" + carNo + ", mNo=" + mNo + ", orderDate=" + orderDate
				+ ", isBuy=" + isBuy + "]";
	}
	
	
}
