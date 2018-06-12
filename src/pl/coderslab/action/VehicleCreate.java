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
 * Servlet implementation class CarMenager
 */
@WebServlet("/VehicleCreate")
public class VehicleCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		CustomerDao customerDao = new CustomerDao();
		request.setAttribute("customers", customerDao.loadAll());

		getServletContext().getRequestDispatcher("/WEB-INF/vehicle_create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		/*
		 * create new vehicle from received data
		 */
		Vehicle vehicle = new Vehicle(
			request.getParameter("model"),
			request.getParameter("manufacturer"),
			Integer.parseInt(request.getParameter("year")),
			request.getParameter("registration_no"),
			Integer.parseInt(request.getParameter("customer_id")),
			request.getParameter("next_servicing_date"));
		VehicleDao vehicleDao = new VehicleDao();
		vehicleDao.create(vehicle);
		
		/*
		 * load last vehicle from DB
		 */
		request.setAttribute("vehicles", vehicleDao.loadLastVehicle());
		getServletContext().getRequestDispatcher("/WEB-INF/vehicle_table.jsp").forward(request, response);
	}

}
