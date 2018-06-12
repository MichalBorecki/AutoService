package pl.coderslab.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Order;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;

/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/OrderRead")
public class OrderRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeDao employeeDao = new EmployeeDao();
		request.setAttribute("employees", employeeDao.loadAll());
		
		VehicleDao vehicleDao = new VehicleDao();
		request.setAttribute("vehicles", vehicleDao.loadAll());
		
		OrderDao orderDAO = new OrderDao();
		
		/*
		 * Get list of all orders for this vehicle_id 
		 */
		String id = request.getParameter("id");
		if (id != null) {
			request.setAttribute("message", "Szczegóły zlecenia: ");
			/*
			 * order_table iterate over List of orders so create list with one Order
			 */
			List<Order> orders = new ArrayList<>();
			orders.add(orderDAO.loadById(id));
			request.setAttribute("orders", orders);
		/*
		 * Get list of all orders in DB
		 */
		} else {
			request.setAttribute("orders", orderDAO.loadAll());
		}
		getServletContext().getRequestDispatcher("/WEB-INF/order_table.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
