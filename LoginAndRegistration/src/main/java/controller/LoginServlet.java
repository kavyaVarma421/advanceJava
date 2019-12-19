package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginDetails;
import service.LoginConnection;
/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public final class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/javascript");
    PrintWriter pw = response.getWriter();
     String username = request.getParameter("username");
     LoginDetails ld = new LoginDetails();
    ld.setuName(username);
    ld.setPassword(request.getParameter("passwrd"));
    try {
    	boolean result = LoginConnection.checkingDetails(ld);
    	if(result) {
    	request.setAttribute("User",username );
    	HttpSession session = request.getSession();
    	session.setAttribute("name",username);
    	RequestDispatcher rs = request.getRequestDispatcher("userDetails.jsp");
    	rs.forward(request, response);
    		} else {
       
    		response.sendRedirect("index.jsp");
    		}
    }catch(Exception e) {
    	e.printStackTrace();
    }
     
	}

}
