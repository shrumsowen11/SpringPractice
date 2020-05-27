package com.shrums.main;

import com.shrums.Car;

public class CarMain {
	public static void main(String[] args) {
		
		Car car = new Car();
		car.setName("Honda");
		car.setColor("Silver");
		car.setMake("Civic");
		car.setPrice(16000.00);
		
		car.run();
		System.out.println(car);
		
	}

}
