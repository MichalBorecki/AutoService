package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

/**
 * Servlet implementation class ClientMenager
 */
@WebServlet("/CustomerCreate")
public class CustomerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/customer_create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		/*
		 * create new customer from received data
		 */
		Customer customer = new Customer(
			request.getParameter("first_name"), 
			request.getParameter("last_name"),
			request.getParameter("email_address"), 
			request.getParameter("date_of_birth"));
		CustomerDao customerDao = new CustomerDao();
		customerDao.create(customer);
		
		/*
		 * load last customer from DB
		 */
		request.setAttribute("customers", customerDao.loadLastCustomer());
		getServletContext().getRequestDispatcher("/WEB-INF/customer_table.jsp").forward(request, response);
	}

}
