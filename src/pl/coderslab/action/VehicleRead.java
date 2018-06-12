package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;

/**
 * Servlet implementation class VehicleRead
 */
@WebServlet("/VehicleRead")
public class VehicleRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleRead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VehicleDao vehicleDao = new VehicleDao();
		
		CustomerDao customerDao = new CustomerDao();
		request.setAttribute("customers", customerDao.loadAll());

		/*
		 * All information about car with this ID
		 */
		if (request.getParameter("id") != null) {
			String id = request.getParameter("id");
			request.setAttribute("message", "Szczegóły samochodu: ");
			request.setAttribute("vehicles", vehicleDao.loadById(id));
			
		/*
		 * Get list of all cars in DB
		 */
		} else {

			request.setAttribute("vehicles", vehicleDao.loadAll());
		}

		getServletContext().getRequestDispatcher("/WEB-INF/vehicle_table.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
