package pl.coderslab.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;

/**
 * Servlet implementation class CustomerRead
 */
@WebServlet("/CustomerRead")
public class CustomerRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		CustomerDao customerDao = new CustomerDao();
		
		if (request.getParameter("id") != null) {
			// ID which we get from table
			String id = request.getParameter("id");
			
			request.setAttribute("message", "Klient: ");
			request.setAttribute("customers", customerDao.loadById(id));

		} else {
			
			request.setAttribute("customers", customerDao.loadAll());
		}


		getServletContext().getRequestDispatcher("/WEB-INF/customer_table.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
