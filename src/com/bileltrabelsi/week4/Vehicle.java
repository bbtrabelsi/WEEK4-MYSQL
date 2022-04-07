package com.bileltrabelsi.week4;

public class Vehicle {

	private int vehicleId;
	private String brand;
	private String model;
	
	
	public Vehicle  (int vehicleId, String brand, String model) {
		this.setVehicleId(vehicleId);
		this.setBrand(brand);
		this.setModel(model);
		
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
