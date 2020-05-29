package com.shrums.main;

import com.shrums.entity.Car;

public class OldStyleCarMain {
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
