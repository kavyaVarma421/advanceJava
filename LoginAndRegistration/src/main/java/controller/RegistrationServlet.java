package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonDetails;
import service.RegisterConnect;
/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        PersonDetails details =new PersonDetails();
	        
	        details.setfName(request.getParameter("fName"));
	        details.setlName(request.getParameter("lName"));
	        details.setuName(request.getParameter("uName"));
	        details.setPassword(request.getParameter("password"));
	        details.setCnformPass(request.getParameter("cnformPass"));
	        details.setEmailId(request.getParameter("emailId"));
	        details.setPhnNum(request.getParameter("phnNum"));
	        
	        System.out.println(details);
	        
	     RegisterConnect.registeringDetails(details);
	        if(details!=null) {
	        	RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
	        	 rd.include(request, response);
	        }
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        
	    }		
	}


