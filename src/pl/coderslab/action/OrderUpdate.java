package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;

/**
 * Servlet implementation class OrderEdit
 */
@WebServlet("/OrderUpdate")
public class OrderUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String id = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		EmployeeDao employeeDao = new EmployeeDao();
		request.setAttribute("employees", employeeDao.loadAll());
		
		VehicleDao vehicleDao = new VehicleDao();
		request.setAttribute("vehicles", vehicleDao.loadAll());
		
		// ID which we get from table
		id = request.getParameter("id");
		OrderDao orderDao = new OrderDao();
		Order order = orderDao.loadById(id);
		
		/*
		 * setStatus fo get name of this status id in form - selected option
		 */
		Status status = new Status();
		status.setStatus(order.getStatus());
		String statusStr = status.getStatus();
		request.setAttribute("statusStr", statusStr);
		
		/*
		 * set all old informations into form "order_update.jsp"
		 */
//		request.setAttribute("id", order.getId());
		request.setAttribute("order_date", order.getOrderDate());
		request.setAttribute("planned_service_start", order.getPlannedServiceStart());
		request.setAttribute("service_start_date", order.getServiceStartDate());
		request.setAttribute("service_end_date", order.getServiceEndDate());
		request.setAttribute("employee_id", order.getEmployeeId());
		request.setAttribute("description_of_problem", order.getDescriptionOfProblem());
		request.setAttribute("description_of_repair", order.getDescriptionOfRepair());
		request.setAttribute("status", order.getStatus());
		request.setAttribute("vehicle_id", order.getVehicleId());
		request.setAttribute("cost_for_customer", order.getCostForCustomer());
		request.setAttribute("cost_of_spare_parts", order.getCostOfSpareParts());
		request.setAttribute("cost_of_one_hour", order.getCostOfOneHour());
		request.setAttribute("repair_time", order.getRepairTime());

		getServletContext().getRequestDispatcher("/WEB-INF/order_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		/*
		 * Below data was edited by user, we have to update it in DB and print on view
		 *
		 * check if employee was choosed, if no, then id = 0 and create new object Order without seting parametr employee_id
		 */
		String rawId = request.getParameter("employee_id");
		int employeeId = Integer.parseInt(rawId);
		
		/*
		 * get costOfOneHourWork of this employee and set into DB in this order
		 */
		EmployeeDao employeeDao = new EmployeeDao();
		// set into order value of 0.0 because is needed for create object
		Double costOfOneHourWork = 0.0;
		

		Order order = new Order();
		OrderDao orderDao = new OrderDao();
		if (employeeId == 0) {
			// without employee ID
			order = new Order(
				request.getParameter("order_date"), 
				request.getParameter("planned_service_start"),
				request.getParameter("service_start_date"),
				request.getParameter("service_end_date"),
				request.getParameter("description_of_problem"),
				request.getParameter("description_of_repair"),
				request.getParameter("status"),
				Integer.parseInt(request.getParameter("vehicle_id")),
				Double.parseDouble(request.getParameter("cost_for_customer")),
				Double.parseDouble(request.getParameter("cost_of_spare_parts")),
				costOfOneHourWork,
				Double.parseDouble(request.getParameter("repair_time")));
		} else {
			// with employee ID

			costOfOneHourWork = employeeDao.costOfOneHourWork(rawId);
			
			order = new Order(
				request.getParameter("order_date"), 
				request.getParameter("planned_service_start"),
				request.getParameter("service_start_date"),
				request.getParameter("service_end_date"),
				employeeId,
				request.getParameter("description_of_problem"),
				request.getParameter("description_of_repair"),
				request.getParameter("status"),
				Integer.parseInt(request.getParameter("vehicle_id")),
				Double.parseDouble(request.getParameter("cost_for_customer")),
				Double.parseDouble(request.getParameter("cost_of_spare_parts")),
				costOfOneHourWork,
				Double.parseDouble(request.getParameter("repair_time")));
		}
		orderDao.update(order, id);

		request.setAttribute("orders", orderDao.loadAll());
		
		request.setAttribute("employees", employeeDao.loadAll());
		
		VehicleDao vehicleDao = new VehicleDao();
		request.setAttribute("vehicles", vehicleDao.loadAll());

		getServletContext().getRequestDispatcher("/WEB-INF/order_table.jsp").forward(request, response);
	}

}
