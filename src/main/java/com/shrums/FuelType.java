package com.shrums;

public class FuelType {
	private String gas;
	private int gallons;
	public String getGas() {
		return gas;
	}
	public void setGas(String gas) {
		this.gas = gas;
	}
	public int getGallons() {
		return gallons;
	}
	public void setGallons(int gallons) {
		this.gallons = gallons;
	}
	@Override
	public String toString() {
		return "FuelType [gas=" + gas + ", gallons=" + gallons + "]";
	}
	
	
	
}
