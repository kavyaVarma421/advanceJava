package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonDetails;
import service.UpdateConnection;
@WebServlet("/Update")
public class UpdatePageNav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDetails pd= UpdateConnection.getData(Integer.parseInt((String) request.getParameter("id")));
		request.setAttribute("detail", pd);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
