package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

/**
 * Servlet implementation class VehicleUpdate
 */
@WebServlet("/VehicleUpdate")
public class VehicleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleUpdate() {
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
		
		CustomerDao customerDao = new CustomerDao();
		request.setAttribute("customers", customerDao.loadAll());
		
		id = request.getParameter("id");
		VehicleDao vehicleDao = new VehicleDao();
		Vehicle vehicle = vehicleDao.loadById(id);
		request.setAttribute("model", vehicle.getModel());
		request.setAttribute("manufacturer", vehicle.getManufacturer());
		request.setAttribute("year", vehicle.getYear());
		request.setAttribute("registration_no", vehicle.getRegistrationNo());
		request.setAttribute("customer_id", vehicle.getCustomerId());
		request.setAttribute("next_servicing_date", vehicle.getNextServicingDate());
		getServletContext().getRequestDispatcher("/WEB-INF/vehicle_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		Vehicle vehicle = new Vehicle(
			request.getParameter("model"),
			request.getParameter("manufacturer"),
			Integer.parseInt(request.getParameter("year")),
			request.getParameter("registration_no"),
			Integer.parseInt(request.getParameter("customer_id")),
			request.getParameter("next_servicing_date"));
		VehicleDao vehicleDao = new VehicleDao();
		vehicleDao.update(vehicle, id);

		CustomerDao customerDao = new CustomerDao();
		request.setAttribute("customers", customerDao.loadAll());
		
		request.setAttribute("vehicles", vehicleDao.loadAll());

		getServletContext().getRequestDispatcher("/WEB-INF/vehicle_table.jsp").forward(request, response);
	}

}
