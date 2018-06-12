package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;

/**
 * Servlet implementation class EmployeeHours
 */
@WebServlet("/EmployeeHours")
public class EmployeeHours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeDao employeeDao = new EmployeeDao();
		request.setAttribute("employees", employeeDao.loadAll());
		
		OrderDao orderDao = new OrderDao();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		if (!(startDate != "" && endDate != "")) {
			request.setAttribute("employeeHours", orderDao.employeeHours(startDate, endDate));
		}
		
		
	getServletContext().getRequestDispatcher("/WEB-INF/employee_hours.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
