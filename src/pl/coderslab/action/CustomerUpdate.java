package pl.coderslab.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.dao.CustomerDao;

/**
 * Servlet implementation class CustomerUpdate
 */
@WebServlet("/CustomerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String rawId = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		VehicleDao vehicleDao = new VehicleDao();
		request.setAttribute("vehicles", vehicleDao.loadAll());
		
		// ID which we get from table
		rawId = request.getParameter("id");
		int id = Integer.parseInt(rawId);

		CustomerDao customerDao = new CustomerDao();
		List<Customer> list = customerDao.loadAll();
		/*
		 * Find by ID all informations about customer and set those informations into form
		 * in customer_update.jsp"
		 */
		for (Customer customer : list) {
			if (id == customer.getId()) {
				request.setAttribute("first_name", customer.getFirstName());
				request.setAttribute("last_name", customer.getLastName());
				request.setAttribute("email_address", customer.getEmail());
				request.setAttribute("date_of_birth", customer.getDateOfBirth());
			}
		}
		getServletContext().getRequestDispatcher("/WEB-INF/customer_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		/*
		 * Below data was edited by user, we have to update it in DB and print on view
		 */
		Customer customer = new Customer(
			request.getParameter("first_name"), 
			request.getParameter("last_name"),
			request.getParameter("email_address"),
			request.getParameter("date_of_birth"));

		CustomerDao customerDao = new CustomerDao();
		customerDao.update(customer, rawId);

		request.setAttribute("customers", customerDao.loadAll());

		getServletContext().getRequestDispatcher("/WEB-INF/customer_table.jsp").forward(request, response);
	}

}
