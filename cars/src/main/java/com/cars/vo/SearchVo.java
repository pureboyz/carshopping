package com.cars.vo;

public class SearchVo {
	
	String company;
	int ages;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getAges() {
		return ages;
	}
	public void setAges(int ages) {
		this.ages = ages;
	}
	
	@Override
	public String toString() {
		return "SearchVo [company=" + company + ", ages=" + ages + "]";
	}
	
}
