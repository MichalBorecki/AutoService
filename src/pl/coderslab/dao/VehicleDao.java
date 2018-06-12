package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.MySQLHelper;
import pl.coderslab.model.Vehicle;

public class VehicleDao {

	private final String tableName = "vehicle";

	public VehicleDao() {
	}

	public Connection getConn() throws SQLException {
		Connection conn = DbUtil.getConn();
		return conn;
	}

	public void create(Vehicle vehicle) {
		final String SQL = "INSERT INTO " + tableName
			+ " (model, manufacturer, year, registration_no, customer_id, next_servicing_date) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				vehicle.getModel(),
				vehicle.getManufacturer(),
				Integer.toString(vehicle.getYear()),
				vehicle.getRegistrationNo(),
				Integer.toString(vehicle.getCustomerId()),
				vehicle.getNextServicingDate());
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void update(Vehicle vehicle, String id) {
		final String SQL = "UPDATE " + tableName
			+ " SET model=?, manufacturer=?, year=?, registration_no=?, customer_id=?, next_servicing_date=?  WHERE id=?";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				vehicle.getModel(),
				vehicle.getManufacturer(),
				Integer.toString(vehicle.getYear()),
				vehicle.getRegistrationNo(),
				Integer.toString(vehicle.getCustomerId()),
				vehicle.getNextServicingDate(), 
				id);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Vehicle> loadByCustomerId(String id) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE customer_id=?";
		List<Vehicle> vehicles = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, id);
			while (rs.next()) {
				Vehicle vehicle = new Vehicle(
					rs.getInt("id"),
					rs.getString("model"),
					rs.getString("manufacturer"),
					rs.getInt("year"),
					rs.getString("registration_no"),
					rs.getInt("customer_id"),
					rs.getString("next_servicing_date"));
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vehicles;
	}
	
	public List<Vehicle> loadLastVehicle() {
		final String SQL = "SELECT * FROM " + tableName + " ORDER BY id DESC LIMIT 1";
		List<Vehicle> vehicles = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Vehicle vehicle = new Vehicle(
					rs.getInt("id"),
					rs.getString("model"),
					rs.getString("manufacturer"),
					rs.getInt("year"),
					rs.getString("registration_no"),
					rs.getInt("customer_id"),
					rs.getString("next_servicing_date"));
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vehicles;
	}

	public List<Vehicle> loadAll() {
		final String SQL = "SELECT * FROM " + tableName;
		List<Vehicle> vehicles = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Vehicle vehicle = new Vehicle(
					rs.getInt("id"),
					rs.getString("model"),
					rs.getString("manufacturer"),
					rs.getInt("year"),
					rs.getString("registration_no"),
					rs.getInt("customer_id"),
					rs.getString("next_servicing_date"));
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vehicles;
	}

	public Vehicle loadById(String id) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE id=?";
		Vehicle vehicle = new Vehicle();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, id);
			while (rs.next()) {
				vehicle = new Vehicle(
					rs.getInt("id"),
					rs.getString("model"),
					rs.getString("manufacturer"),
					rs.getInt("year"),
					rs.getString("registration_no"),
					rs.getInt("customer_id"),
					rs.getString("next_servicing_date"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vehicle;
	}
	
	public boolean delete(int id) {
		final String SQL = "DELETE FROM " + tableName + " WHERE id=?";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
