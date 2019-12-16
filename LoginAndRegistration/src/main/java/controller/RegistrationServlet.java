package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonDetails;
/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        PersonDetails details =new PersonDetails();
	        details.setfName(request.getParameter("fName"));
	        details.setfName(request.getParameter("lName"));
	        details.setfName(request.getParameter("uName"));
	        details.setfName(request.getParameter("password"));
	        details.setfName(request.getParameter("cnformPass"));
	        details.setfName(request.getParameter("emailId"));
	        details.setfName(request.getParameter("phnNum"));
	        
	        if(details!=null) {
	        	RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
	        	 rd.include(request, response);
	        }
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        
	    }		
	}


