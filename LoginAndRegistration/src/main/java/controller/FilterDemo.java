package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
*//**
	 * Servlet Filter implementation class FilterDemo
	 *//*
		 * @WebFilter("/LoginServlet") public class FilterDemo implements Filter {
		 * 
		 * public void destroy() {
		 * 
		 * }
		 * 
		 * @SuppressWarnings("null") public void doFilter(ServletRequest request,
		 * ServletResponse response, FilterChain chain) throws IOException,
		 * ServletException { HttpServletRequest req = (HttpServletRequest) request;
		 * HttpServletResponse res = (HttpServletResponse) response; HttpSession session
		 * = req.getSession(false);
		 * 
		 * if (session != null || session.getAttribute("name") != null) {
		 * chain.doFilter(req, res); // Logged-in user found, so just continue request.
		 * 
		 * } else { res.sendRedirect("index.jsp");// No logged-in user found, so
		 * redirect to login page.
		 * 
		 * } }
		 * 
		 * public void init(FilterConfig fConfig) throws ServletException {
		 * 
		 * }
		 * 
		 * }
		 */