package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrderDao;

/**
 * Servlet implementation class ReportOfProfit
 */
@WebServlet("/ReportOfProfit")
public class ReportOfProfit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportOfProfit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		OrderDao orderDao = new OrderDao();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		if (startDate != null && endDate != null && startDate != "" && endDate != "") {
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("profit", "Zysk za okres " + startDate + " - " + endDate + " wynosi: " + orderDao.reportOfProfit(startDate, endDate) + " zł");
		} else if (startDate != "" || endDate != ""){
			request.setAttribute("profit", "Wprowadź poprawny zakres dat");
		}

		getServletContext().getRequestDispatcher("/WEB-INF/report_of_profit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
