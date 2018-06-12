package pl.coderslab.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Order;

/**
 * Servlet implementation class VehiclesInRepair
 */
@WebServlet("/VehiclesInRepair")
public class VehiclesInRepair extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehiclesInRepair() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String tableHeader = "			<tr>\n" +
			"				<th style=\"width: 150px\"></th>\n" +
			"				<th>Data przyjęcia do naprawy</th>\n" +
			"				<th>Planowana data rozpoczęcia naprawy</th>\n" +
			"				<th>Data rozpoczęcia naprawy</th>\n" +
			"				<th>Mechanik</th>\n" +
			"				<th>Problem</th>\n" +
			"				<th>Opis naprawy</th>\n" +
			"				<th>Status</th>\n" +
			"				<th>Samochód</th>\n" +
			"				<th>Koszt naprawy dla klienta</th>\n" +
			"				<th>Koszt wykorzystanych części</th>\n" +
			"				<th>Koszt roboczogodziny</th>\n" +
			"				<th>Ilość roboczogodzin</th>\n" +
			"			</tr>";

		OrderDao ordersDAO = new OrderDao();

		EmployeeDao employeeDao = new EmployeeDao();
		request.setAttribute("employees", employeeDao.loadAll());

		VehicleDao vehicleDao = new VehicleDao();
		request.setAttribute("vehicles", vehicleDao.loadAll());

		String id = request.getParameter("id");

		List<Order> orders = new ArrayList<>();
		List<Order> ordersEmpty = new ArrayList<>();

		 if (id != null) {
			orders = ordersDAO.loadAllInProgressByEmployee(id);
			/*
			 * Create two new objects List<Order> - one is empty, second is equals to
			 * loadAllInProgress. If loadAllInProgress is empty send message "Brak zleceń"
			 */

			request.setAttribute("orders", orders);
			if (orders.equals(ordersEmpty)) {
				request.setAttribute("message", "Brak zleceń");
			} else {
				request.setAttribute("tableHeader", tableHeader);
				request.setAttribute("message", "Zlecenia danego mechanika: ");
			}
		} else {
				orders = ordersDAO.loadAllInProgress();
				request.setAttribute("orders", orders);

				if (orders.equals(ordersEmpty)) {
					request.setAttribute("message", "Brak zleceń");
				} else {
					request.setAttribute("tableHeader", tableHeader);
					request.setAttribute("message", "Wszystkie zlecenia w trakcie realizacji: ");
				}
		}

		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		doGet(request, response);
	}

}
