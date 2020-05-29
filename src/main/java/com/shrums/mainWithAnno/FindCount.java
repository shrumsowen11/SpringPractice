package com.shrums.mainWithAnno;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shrums.Dao.FuelService;

public class FindCount {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("anno-fuel-dao.xml");
		FuelService fuelService = (FuelService) applicationContext.getBean("fuelService");
		

		int count = fuelService.findCount();
		
		System.out.println("\n\n\n************************ "+ count + " As shown below: ************************");
		fuelService.findAll().forEach(System.out::println);
	
	
	}

}
