package com.shrums.mainWithAnno;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shrums.dao.FuelService;

public class FindCount {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("anno-fuel-dao.xml");
		/* 
		 * the ClassPathXmlApplicationContext() ->> goes into the .xml file, if it finds the 
		 * <context:component-scan base-package = "packageName"/>
		 * then, it will go in search of the Annotations in the .java files, and starts creating the 
		 * beans in the .xml file automatically where ever it finds the @Annotations
		 *  
		 *  */
		FuelService fuelService = (FuelService) applicationContext.getBean("fuelService");
		

		int count = fuelService.findCount();
		
		System.out.println("\n\n\n************************ "+ count + " As shown below: ************************");
		fuelService.findAll().forEach(System.out::println);
	
	
	}

}
