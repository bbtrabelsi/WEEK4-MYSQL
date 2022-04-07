package com.bileltrabelsi.week4;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private Scanner scanner = new Scanner (System.in);
	private VehiclesDao vehiclesDao = new VehiclesDao();
	private List<String> options = Arrays.asList(
			"DISPLAY VEHICLES",
			"UPDATE VEHICLES",
			"ADD VEHICLE",
			"DELETE VEHICLE");
		
	
	public void start(){
		String selection = "";
			do {
				printMenu();
				selection = scanner.nextLine();
				try {
					if (selection.equals("1")) {
						displayVehicles();
					}else if ( selection.equals("2")) {
						updateVehicles();
					} else if ( selection.equals("3")) {
						addVehicle();
					} else if (selection.equals("4")) {
						deleteVehicle();
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.out.println("Press enter to continue ...");
				scanner.nextLine();
			
			}while (! selection.equals("-1"));
	}
		

	private void  printMenu() {
		System.out.println("Select Options :\n===========================");
		
		for (int i = 0; i < options.size(); i++ ) {
			System.out.println((i+1)+ ") " + options.get(i));
		   }
	}
	
	private void displayVehicles() throws SQLException {
		List<Vehicle> vehicles = vehiclesDao.getVehicles();
		for (Vehicle vehicle : vehicles ) {
			System.out.println(vehicle.getVehicleId() + ": " + vehicle.getBrand() + " " +vehicle.getModel());
		}
	}
	
	private void updateVehicles() throws SQLException {
		System.out.println("Enter vehicle id: ");
		int vehicleId= Integer.parseInt(scanner.nextLine());
		System.out.println("Enter vehicle Brand: ");
		String vehicleBrand = scanner.nextLine();
		System.out.println("Enter vehicle Model: ");
		String vehicleModel = scanner.nextLine();
		vehiclesDao.updateVehicle(vehicleId, vehicleBrand, vehicleModel);
	}
	
	private void addVehicle() throws SQLException {
		System.out.println("Enter vehicle brand: ");
		String vehicleBrand = scanner.nextLine();
		System.out.println("Enter vehicle model: ");
		String vehicleModel = scanner.nextLine();
		vehiclesDao.addNewVehicle(vehicleBrand, vehicleModel);
	}
	
	private void deleteVehicle() throws SQLException {
		System.out.println("Enter vehicle ID: ");
		int vehicleId = Integer.parseInt(scanner.nextLine());
		
		vehiclesDao.deleteFromVehicle(vehicleId);
		
	}
	
}
