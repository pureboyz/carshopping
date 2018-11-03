package com.cars.vo;

public class FreqData {
	
	int twenties;
	int thirties;
	int forties;
	int fifties;
	int overSixty;
	
	public int getTwenties() {
		return twenties;
	}
	public void setTwenties(int twenties) {
		this.twenties = twenties;
	}
	public int getThirties() {
		return thirties;
	}
	public void setThirties(int thirties) {
		this.thirties = thirties;
	}
	public int getForties() {
		return forties;
	}
	public void setForties(int forties) {
		this.forties = forties;
	}
	public int getFifties() {
		return fifties;
	}
	public void setFifties(int fifties) {
		this.fifties = fifties;
	}
	public int getOverSixty() {
		return overSixty;
	}
	public void setOverSixty(int overSixty) {
		this.overSixty = overSixty;
	}
	
	@Override
	public String toString() {
		return "FreqData [twenties=" + twenties + ", thirties=" + thirties + ", forties=" + forties + ", fifties="
				+ fifties + ", overSixty=" + overSixty + "]";
	}
	
}
