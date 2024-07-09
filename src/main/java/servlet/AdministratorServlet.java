package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountData;

@WebServlet("/Administrator")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Object object = session.getAttribute("AccountData");
		
		if (object != null) {
			
			if ( object instanceof AccountData) {
				AccountData AccountData = (AccountData)session.getAttribute("AccountData");
				if (AccountData.getIsAdmin()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/administrator.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
		
		response.sendRedirect("GeneralServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
