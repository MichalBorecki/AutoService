package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

/**
 * Servlet implementation class MechanicEdit
 */
@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeUpdate() {
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
		id = request.getParameter("id");
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.loadByIdGetObject(id);
		request.setAttribute("first_name", employee.getFirstName());
		request.setAttribute("last_name", employee.getLastName());
		request.setAttribute("address", employee.getAddress());
		request.setAttribute("telephone", employee.getTelephone());
		request.setAttribute("note", employee.getNote());
		request.setAttribute("cost_of_one_hour", employee.getCostOfOneHour());
		getServletContext().getRequestDispatcher("/WEB-INF/employee_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		Employee employee = new Employee(
			request.getParameter("first_name"),
			request.getParameter("last_name"),
			request.getParameter("address"),
			Integer.parseInt(request.getParameter("telephone")),
			request.getParameter("note"),
			Double.parseDouble(request.getParameter("cost_of_one_hour")));
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.update(employee, id);

		request.setAttribute("employees", employeeDao.loadAll());

		getServletContext().getRequestDispatcher("/WEB-INF/employee_table.jsp").forward(request, response);
	}

}
