package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;

/**
 * Servlet implementation class MechanicMenager
 */
@WebServlet("/EmployeeRead")
public class EmployeeRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRead() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		EmployeeDao employeeDao = new EmployeeDao();

		if (request.getParameter("id") != null) {
			// ID which we get from table
			String id = request.getParameter("id");

			request.setAttribute("message", "Mechanik: ");
			request.setAttribute("employees", employeeDao.loadById(id));
		} else {

			request.setAttribute("employees", employeeDao.loadAll());
		}
		getServletContext().getRequestDispatcher("/WEB-INF/employee_table.jsp").forward(request, response);

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
