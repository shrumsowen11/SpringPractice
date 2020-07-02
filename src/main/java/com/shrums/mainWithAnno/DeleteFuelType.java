package com.shrums.mainWithAnno;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shrums.dao.FuelService;


public class DeleteFuelType {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("anno-fuel-dao.xml");
		FuelService fuelService = (FuelService) applicationContext.getBean("fuelService");
		/*
		 * get a list of the fid's in the database --> for this create a function in
		 * the FuelService and also in FuelTypeDao which gets a list of the 
		 * Fid's which are present in the database and make user choose in between 
		 * those fid's only
		 * After which, we will be able to send that fid to the method delete() in
		 * the FuelService
		 * 
		 * */

		//fuelService.delete();
		
		//System.out.println("\n\n\n************************ "+ count + " As shown below: ************************");
		fuelService.findAll().forEach(System.out::println);
	
	
		
		
	}

}
