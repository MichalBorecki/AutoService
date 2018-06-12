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
 * Servlet implementation class EmployeeCreate
 */
@WebServlet("/EmployeeCreate")
public class EmployeeCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/employee_create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Employee employee = new Employee(
			request.getParameter("first_name"),
			request.getParameter("last_name"),
			request.getParameter("address"),
			Integer.parseInt(request.getParameter("telephone")),
			request.getParameter("note"),
			Double.parseDouble(request.getParameter("cost_of_one_hour")));
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.create(employee);
		
		request.setAttribute("employees", employeeDao.loadLastEmployee());
		
		getServletContext().getRequestDispatcher("/WEB-INF/employee_table.jsp").forward(request, response);
	}

}
