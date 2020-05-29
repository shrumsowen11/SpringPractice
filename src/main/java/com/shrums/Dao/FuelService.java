package com.shrums.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.shrums.entity.FuelType;


@Service("fuelService")
@Scope("singleton")
public class FuelService {
	
	
	@Autowired
	//@Qualifier("fuelTypeDao")   
	// This Qualifier takes the reference of the FueltypeDao, which I normally set the similar name
	
	private FuelTypeDao fuelTypeDao;

	public FuelTypeDao getFuelTypeDao() {
		return fuelTypeDao;
	}

	public void setFuelTypeDao(FuelTypeDao fuelTypeDao) {
		this.fuelTypeDao = fuelTypeDao;
	}

	
	
	public void save(String gas,int gallons) {
		FuelType fuelType =new FuelType();
		fuelType.setGas(gas);
		fuelType.setGallons(gallons);
		fuelTypeDao.save(fuelType);
	}
	
	public List<FuelType> findAll() {
		return fuelTypeDao.findAll();
	}
	
	public int findCount() {
		return fuelTypeDao.findCount();
	}
	
	public void deleteById(int fid) {
		fuelTypeDao.deleteById(fid);
	}

}