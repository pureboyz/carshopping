package com.cars.vo;

public class FreqData {
	
	int low;
	int mid;
	int high;
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	
	@Override
	public String toString() {
		return "FreqData [low=" + low + ", mid=" + mid + ", high=" + high + "]";
	}
	
	
	

}
