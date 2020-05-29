package com.shrums.entity;

import java.sql.Timestamp;

public class FuelType {
	private int FID;
	private String gas;
	private int gallons;
	private Timestamp createDate; 
	
	
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}
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
	
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "FuelType [FID=" + FID + ", gas=" + gas + ", gallons=" + gallons + ", createDate=" + createDate + "]";
	}
	
	
	
	
	
	
	
}
