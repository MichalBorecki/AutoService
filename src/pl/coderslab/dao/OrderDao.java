package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.MySQLHelper;
import pl.coderslab.model.Order;

public class OrderDao {

	private final String tableName = "service_order";

	public OrderDao() {
	}

	public Connection getConn() throws SQLException {
		Connection conn = DbUtil.getConn();
		return conn;
	}

	public void create(Order order) {
		final String SQL = "INSERT INTO " + tableName
			+ " (order_date, planned_service_start, service_start_date, service_end_date, employee_id, description_of_problem, description_of_repair, status, vehicle_id, "
			+ "cost_for_customer, cost_of_spare_parts, cost_of_one_hour, repair_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				order.getOrderDate(),
				order.getPlannedServiceStart(),
				order.getServiceStartDate(),
				order.getServiceEndDate(),
				Integer.toString(order.getEmployeeId()),
				order.getDescriptionOfProblem(),
				order.getDescriptionOfRepair(),
				order.getStatus(),
				Integer.toString(order.getVehicleId()),
				Double.toString(order.getCostForCustomer()),
				Double.toString(order.getCostOfSpareParts()),
				Double.toString(order.getCostOfOneHour()),
				Double.toString(order.getRepairTime()));
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void update(Order order, String id) {
		final String SQL = "UPDATE " + tableName
			+ " SET order_date=?, planned_service_start=?, service_start_date=?, service_end_date=?, employee_id=?, description_of_problem=?, description_of_repair=?, status=?, vehicle_id=?, "
			+ "cost_for_customer=?, cost_of_spare_parts=?, cost_of_one_hour=?, repair_time=?   WHERE id=?";
		try (Connection conn = getConn()) {
			MySQLHelper.executeUpdate(conn, SQL,
				order.getOrderDate(),
				order.getPlannedServiceStart(),
				order.getServiceStartDate(),
				order.getServiceEndDate(),
				Integer.toString(order.getEmployeeId()),
				order.getDescriptionOfProblem(),
				order.getDescriptionOfRepair(),
				order.getStatus(),
				Integer.toString(order.getVehicleId()),
				Double.toString(order.getCostForCustomer()),
				Double.toString(order.getCostOfSpareParts()),
				Double.toString(order.getCostOfOneHour()),
				Double.toString(order.getRepairTime()),
				id);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public Order loadLastOrder() {
		final String SQL = "SELECT * FROM " + tableName + " ORDER BY id DESC LIMIT 1";
		Order order = new Order();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				order = new Order(
					rs.getInt("id"),
					rs.getString("order_date"),
					rs.getString("planned_service_start"),
					rs.getString("service_start_date"),
					rs.getString("service_end_date"),
					rs.getInt("employee_id"),
					rs.getString("description_of_problem"),
					rs.getString("description_of_repair"),
					rs.getString("status"),
					rs.getInt("vehicle_id"),
					rs.getDouble("cost_for_customer"),
					rs.getDouble("cost_of_spare_parts"),
					rs.getDouble("cost_of_one_hour"),
					rs.getDouble("repair_time"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return order;
	}
	
	public Order loadById(String id) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE id=?";
		Order order = new Order();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, id);
			while (rs.next()) {
				order = new Order(
					rs.getInt("id"),
					rs.getString("order_date"),
					rs.getString("planned_service_start"),
					rs.getString("service_start_date"),
					rs.getString("service_end_date"),
					rs.getInt("employee_id"),
					rs.getString("description_of_problem"),
					rs.getString("description_of_repair"),
					rs.getString("status"),
					rs.getInt("vehicle_id"),
					rs.getDouble("cost_for_customer"),
					rs.getDouble("cost_of_spare_parts"),
					rs.getDouble("cost_of_one_hour"),
					rs.getDouble("repair_time"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return order;
	}

	public List<Order> loadAll() {
		final String SQL = "SELECT * FROM " + tableName + " ORDER BY order_date";
		List<Order> orders = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Order order = new Order(
					rs.getInt("id"),
					rs.getString("order_date"),
					rs.getString("planned_service_start"),
					rs.getString("service_start_date"),
					rs.getString("service_end_date"),
					rs.getInt("employee_id"),
					rs.getString("description_of_problem"),
					rs.getString("description_of_repair"),
					rs.getString("status"),
					rs.getInt("vehicle_id"),
					rs.getDouble("cost_for_customer"),
					rs.getDouble("cost_of_spare_parts"),
					rs.getDouble("cost_of_one_hour"),
					rs.getDouble("repair_time"));
				orders.add(order);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return orders;
	}
	
	public List<Order> loadAllInProgressByEmployee(String employeeId) {
		final String SQL = "SELECT * FROM " + tableName + " WHERE status=3 AND employee_id=?";
		List<Order> orders = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, employeeId);
			while (rs.next()) {
				Order order = new Order(
					rs.getString("order_date"),
					rs.getString("planned_service_start"),
					rs.getString("service_start_date"),
					rs.getString("service_end_date"),
					rs.getInt("employee_id"),
					rs.getString("description_of_problem"),
					rs.getString("description_of_repair"),
					rs.getString("status"),
					rs.getInt("vehicle_id"),
					rs.getDouble("cost_for_customer"),
					rs.getDouble("cost_of_spare_parts"),
					rs.getDouble("cost_of_one_hour"),
					rs.getDouble("repair_time"));
				orders.add(order);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return orders;
	}
	
	public List<Order> loadAllInProgress() {
		final String SQL = "SELECT * FROM " + tableName + " WHERE status=3 ORDER BY employee_id";
		List<Order> orders = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL);
			while (rs.next()) {
				Order order = new Order(
					rs.getInt("id"),
					rs.getString("order_date"),
					rs.getString("planned_service_start"),
					rs.getString("service_start_date"),
					rs.getString("service_end_date"),
					rs.getInt("employee_id"),
					rs.getString("description_of_problem"),
					rs.getString("description_of_repair"),
					rs.getString("status"),
					rs.getInt("vehicle_id"),
					rs.getDouble("cost_for_customer"),
					rs.getDouble("cost_of_spare_parts"),
					rs.getDouble("cost_of_one_hour"),
					rs.getDouble("repair_time"));
				orders.add(order);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return orders;
	}	
	
	public List<Order> loadByVehicleId(String vehicle_id) {
		final String SQL = "SELECT id, service_start_date, description_of_repair FROM " + tableName + " WHERE id=? AND service_start_date IS NOT NULL ORDER BY service_start_date";
		List<Order> orders = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, vehicle_id);
			while (rs.next()) {
				Order order = new Order(
					rs.getInt("id"),
					rs.getString("service_start_date"),
					rs.getString("description_of_repair"));
				orders.add(order);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return orders;
	}	
	
	public List<Order> employeeHours(String dateStart, String dateEnd) {
		final String SQL = "SELECT employee_id , SUM(repair_time) AS repair_time FROM " + tableName + " WHERE service_start_date BETWEEN ? AND ? GROUP BY employee_id";
		List<Order> employeeHours = new ArrayList<>();
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, dateStart, dateEnd);
			while (rs.next()) {
				Order order = new Order(
					rs.getInt("employee_id"),
					rs.getDouble("repair_time"));
				employeeHours.add(order);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return employeeHours;
	}	
	
	public Double reportOfProfit(String dateStart, String dateEnd) {
		final String SQL = "SELECT SUM(cost_for_customer - cost_of_spare_parts - (cost_of_one_hour * repair_time)) AS profit FROM " + tableName + " WHERE service_end_date BETWEEN ? AND ?";
		Double profit = 0.0;
		try (Connection conn = getConn()) {
			ResultSet rs = MySQLHelper.executeQuery(conn, SQL, dateStart, dateEnd);
			while (rs.next()) {
					profit = rs.getDouble("profit");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return profit;
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
