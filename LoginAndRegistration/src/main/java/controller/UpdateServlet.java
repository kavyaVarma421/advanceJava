package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		PersonDetails details = new PersonDetails();
		details.setuName(request.getParameter("UserName"));
		details.setfName(request.getParameter("firstName"));
		details.setlName(request.getParameter("lname"));
		details.setEmailId(request.getParameter("mailId"));
		details.setPhnNum(request.getParameter("mobileNo"));

		if (UpdateConnection.update(details) > 0) {
			System.out.println("Succcc");
		} else {
			System.out.println("fillllllllllll");
		}

	}
}
