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
import service.DeleteDetails;

/**
 * Servlet implementation class DeleteServlet
 */
@SuppressWarnings("serial")
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	static Connection con = null;
	static PreparedStatement st = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("name");

		System.out.println(name);
		
		PersonDetails pd = new PersonDetails();
		
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver class loaded & registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");
			String query = "Select * from LoginAndRegistration where UserName= '"+name+"'";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {				
				pd.setfName(rs.getString("FirstName"));
				pd.setlName(rs.getString("LastName"));
				pd.setuName(rs.getString("UserName"));
				pd.setPassword(rs.getString("Password"));
				pd.setEmailId(rs.getString("EmailId"));
				pd.setPhnNum(rs.getString("MobileNumber"));
				System.out.println(pd);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		DeleteDetails.delete(pd);
		PrintWriter pw = response.getWriter();
		pw.print("successfully deleted...");
	    RequestDispatcher rs = request.getRequestDispatcher("userDetails.jsp");
		rs.forward(request, response);
		
	}

	}


