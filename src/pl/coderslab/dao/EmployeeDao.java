package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.MySQLHelper;
import pl.coderslab.model.Employee;

public class EmployeeDao {

	private final String tableName = "employee";

	public EmployeeDao() {
	}

	public Connection getConn() throws SQLException {
		Connection conn = DbUtil.getConn();
		return conn;
	}

	public void create(Employee employee) {
		final String SQL = "INSERT INTO " + tableName
			+ " (first_name, last_name, address, telephone, note, cost_of_one_hour) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				employee.getFirstName(),
				employee.getLastName(),
				employee.getAddress(),
				Integer.toString(employee.getTelephone()),
				employee.getNote(),
				Double.toString(employee.getCostOfOneHour()));
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void update(Employee employee, String id) {
		final String SQL = "UPDATE " + tableName
			+ " SET first_name=?, last_name=?, address=?, telephone=?, note=?, cost_of_one_hour=?  WHERE id=?";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				employee.getFirstName(),
				employee.getLastName(),
				employee.getAddress(),
				Integer.toString(employee.getTelephone()),
				employee.getNote(),
				Double.toString(employee.getCostOfOneHour()), id);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<Employee> loadLastEmployee() {
		final String SQL = "SELECT * FROM " + tableName + " ORDER BY id DESC LIMIT 1";
		List<Employee> employeeList = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Employee employee = new Employee(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("address"),
					rs.getInt("telephone"),
					rs.getString("note"),
					rs.getDouble("cost_of_one_hour"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return employeeList;
	}
	
	public List<Employee> loadAll() {
		final String SQL = "SELECT * FROM " + tableName;
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Employee employee = new Employee(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("address"),
					rs.getInt("telephone"),
					rs.getString("note"),
					rs.getDouble("cost_of_one_hour"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return employees;
	}
	
	public List<Employee> loadById(String id) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE id=?";
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, id);
			while (rs.next()) {
				Employee employee = new Employee(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("address"),
					rs.getInt("telephone"),
					rs.getString("note"),
					rs.getDouble("cost_of_one_hour"));
					employees.add(employee);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return employees;
	}
	
	public Employee loadByIdGetObject(String id) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE id=?";
		Employee employee = new Employee();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, id);
			while (rs.next()) {
				employee = new Employee(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("address"),
					rs.getInt("telephone"),
					rs.getString("note"),
					rs.getDouble("cost_of_one_hour"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return employee;
	}
	
	public Double costOfOneHourWork(String id) {
		final String SQL = "SELECT cost_of_one_hour FROM " + tableName + " WHERE id=?";
		Double costOfOneHour = 0.0;
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, id);
			while (rs.next()) {
				costOfOneHour = rs.getDouble("cost_of_one_hour");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return costOfOneHour;
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
