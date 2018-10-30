package com.cars.vo;

public class D3Data {
	String State;
	FreqData freq;
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public FreqData getFreq() {
		return freq;
	}
	public void setFreq(FreqData freq) {
		this.freq = freq;
	}
	@Override
	public String toString() {
		return "D3Data [State=" + State + ", freq=" + freq + "]";
	}
	
	
	
	
}
