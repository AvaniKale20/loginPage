package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgelabz.model.*;
import com.bridgelabz.dao.DBConnection;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter writer = null;
	// Connection connection=null;
	Connection connection = null;
	PreparedStatement statement = null;
	String sql = "insert into student values(default,?,?,?)";
	
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException 
	{
		connection = DBConnection.getDBConnection();
		System.out.println("RegisterServlet.init()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RegisterServlet.doPost()");
		writer = resp.getWriter();
		resp.setContentType("text/html");

		String userName = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		User user=new User(userName,email,password);
	
		
		try 
		{
			statement = connection.prepareStatement(sql);
		
			statement.setString(1,user.getUname());
			statement.setString(2,user.getEmail());
			statement.setString(3,user.getPassword());
		
			int val = statement.executeUpdate();
			if (val > 0) {
				writer.println("Registration Successful");
				RequestDispatcher dispatcher = req.getRequestDispatcher("log.jsp");
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


