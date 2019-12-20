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
import model.PersonDetails;
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

    	PersonDetails result = LoginConnection.checkingDetails(ld);
    	if(result!=null) {
    	HttpSession session = request.getSession(true);
    	session.setAttribute("name",username);
    	request.setAttribute("detail", result);
    	RequestDispatcher rs = request.getRequestDispatcher("userDetails.jsp");
    	rs.forward(request, response);
    		} 
          
    		}
     
	}

