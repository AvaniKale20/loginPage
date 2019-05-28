package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.DBConnection;
import com.sun.tools.javac.code.Scope.WriteableScope;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter out = null;
	String sql = "select * from student where email=? and password=?";
	Connection connection = null;

	@Override
	public void init() throws ServletException 
	{
		System.out.println("LoginServlet.init()::Data BAse con");
		connection = DBConnection.getDBConnection();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("LoginServlet.doPost()");
		out = resp.getWriter();
		resp.setContentType("text/html");
		String userName = req.getParameter("username");
		String password = req.getParameter("pass");
		HttpSession session = req.getSession();
		try 
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
				
			
			
			while (resultSet.next()) 
			{
				session.setAttribute("uname", userName);
				Cookie ck = new Cookie("userName", userName);
				System.out.println("name added:" + userName);
				resp.addCookie(ck);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Success.jsp");
				dispatcher.forward(req, resp);
			}
			

		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
