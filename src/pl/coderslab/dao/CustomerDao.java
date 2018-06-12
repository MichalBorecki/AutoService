package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.MySQLHelper;
import pl.coderslab.model.Customer;

public class CustomerDao {

	private final String tableName = "customer";

	public CustomerDao() {
	}

	public Connection getConn() throws SQLException {
		Connection conn = DbUtil.getConn();
		return conn;
	}

	public void create(Customer customer) {
		final String SQL = "INSERT INTO " + tableName
			+ " (first_name, last_name, email_address, date_of_birth) VALUES (?, ?, ?, ?)";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				customer.getFirstName(),
				customer.getLastName(),
				customer.getEmail(),
				customer.getDateOfBirth());
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void update(Customer customer, String id) {
		final String SQL = "UPDATE " + tableName
			+ " SET first_name=?, last_name=?, email_address=?, date_of_birth=? WHERE id=?";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				customer.getFirstName(),
				customer.getLastName(),
				customer.getEmail(),
				customer.getDateOfBirth(),
				id);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Customer> loadAll() {
		final String SQL = "SELECT * FROM " + tableName;
		List<Customer> customers = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email_address"),
					rs.getString("date_of_birth"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return customers;
	}
	
	public List<Customer> loadLastCustomer() {
		final String SQL = "SELECT * FROM " + tableName + " ORDER BY id DESC LIMIT 1";
		List<Customer> customers = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email_address"),
					rs.getString("date_of_birth"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return customers;
	}
	
	public List<Customer> loadById(String id) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE id=?";
		List<Customer> customer = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, id);
			while (rs.next()) {
				Customer customerWithThisId = new Customer(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email_address"),
					rs.getString("date_of_birth"));
				customer.add(customerWithThisId);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return customer;
	}

	public List<Customer> loadByLastName(String lastName) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE last_name=?";
		List<Customer> customers = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, lastName);
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email_address"),
					rs.getString("date_of_birth"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return customers;
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
