package com.bridgelabz.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bridgelabz.dao.DBConnection;
public class LogoutServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		int i = 0;
		String name = "";
		//String emailID = "";
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		// String name=(String)session.getAttribute("userName");

		Cookie ck[] = request.getCookies();

		for (Cookie cookies : ck)
		{
			name = cookies.getValue();
			System.out.println(cookies.getName());
			System.out.println(cookies.getValue());

		}
		
		try 
		{
			session.removeAttribute("uname");
			session.invalidate();
			System.out.println("LogoutServlet.doPost()::name" + name);
			
			for (Cookie cookie : request.getCookies()) {
			    cookie.setValue("");
			    cookie.setMaxAge(0);
			    cookie.setPath("/");

			    response.addCookie(cookie);
			}
			
			out.print("Welcome : " + name);
			out.print("<br><br>");

			
			session.setAttribute("uname",null);
			out.print("you are successfully logged out!");
			out.print("<br><br>");
			String userName = (String) session.getAttribute("uname");
			if (null == userName) {
			   request.setAttribute("Error", "Session has ended.  Please login.");
			   RequestDispatcher rd = request.getRequestDispatcher("log.jsp");
			   rd.forward(request, response);
			}
			//...
			//Allow the rest of the dynamic content in this JSP to be served to the browser
			//...
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
