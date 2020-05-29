package com.shrums.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shrums.Dao.FuelService;


public class InsertFuelType {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("fuel-dao.xml");
		FuelService fuelService = (FuelService) applicationContext.getBean("fuelService");
		

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the gas type: ");
		String gasType = scan.nextLine();
		
		System.out.println("Enter the num of gallons: ");
		int gallons = scan.nextInt();
		
		System.out.println("**************************** Printing the information *******************************");
		fuelService.save(gasType, gallons);
	scan.close();
	}

}
