package com.bileltrabelsi.week4;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class VehiclesDao {

	private Connection connection;
	private final String GET_VEHICLES_QUERY = "SELECT * FROM vehicles";
	private final String ADD_VEHICLE_QUERY = "INSERT INTO vehicles(brand, model) VALUES (? , ?)";
	private final String UPDATE_VEHICLE_QUERY = "UPDATE vehicles SET brand = ?, model= ? WHERE id = ?";
	private final String DELETE_VEHICLE_QUERY = "DELETE FROM vehicles WHERE id = ?";
	
	public VehiclesDao() {
		connection = DBConnection.getConnection();
	}
		
	
	public List<Vehicle> getVehicles() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_VEHICLES_QUERY).executeQuery();
		List <Vehicle> vehicles = new ArrayList<Vehicle>();
		
		while (rs.next()) {
			vehicles.add(addVehicleToList(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return vehicles;
	}

	public void updateVehicle( int vehicleId, String brand, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_VEHICLE_QUERY);
		ps.setInt(3, vehicleId);
		ps.setString(1, brand);
		ps.setString(2, model);
		ps.executeUpdate();
	}
	
	
	public void addNewVehicle (String brand, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_VEHICLE_QUERY);
		ps.setString(1, brand);
		ps.setString(2, model);
		ps.executeUpdate();
	}
	
	public void deleteFromVehicle ( int vehicleId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_VEHICLE_QUERY);
		ps.setInt(1, vehicleId);
		ps.executeUpdate();
	}
	
	private Vehicle addVehicleToList(int id, String brand, String model ) {
		return new Vehicle (id, brand, model);
		
	}
	
}

