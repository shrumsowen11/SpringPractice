package com.shrums.entity;



// TestingMyGitHubUpdating 
// SecondTestingMyGitHubUpdating
// ThirdTestingMyGitHubUpdating 



public class Car {

	private String name;
	private String color;
	private String make;
	private double price;
	private FuelType fuelType;

	public void run() {

		System.out.println(name + " runs...");
	}

	public Car() {
		super();
	}

	public Car(String name, String color, String make, double price, FuelType fuelType) {
		super();
		this.name = name;
		this.color = color;
		this.make = make;
		this.price = price;
		this.fuelType = fuelType;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", make=" + make + ", price=" + price + ", fuelType="
				+ fuelType + "]";
	}

}
