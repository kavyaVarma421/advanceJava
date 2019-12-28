package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PersonDetails;
import service.UpdateConnection;

/**
 * Servlet implementation class UpdateServlet
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	static Connection con = null;
	static PreparedStatement st = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PersonDetails pd = new PersonDetails();
		/*PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver class loaded & registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");*/
			pd.setfName(request.getParameter("firstName"));
			pd.setlName(request.getParameter("lastName"));
			pd.setEmailId(request.getParameter("email"));
			pd.setPhnNum(request.getParameter("MobileNo"));
			pd.setuName(request.getParameter("UserName"));
			request.setAttribute("detail", pd);
			if (UpdateConnection.update(pd) > 0) {
				System.out.println("Succcc");
				session.setAttribute("name", pd.getuName());
				request.getRequestDispatcher("userDetails.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
			
		/*
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}
}
