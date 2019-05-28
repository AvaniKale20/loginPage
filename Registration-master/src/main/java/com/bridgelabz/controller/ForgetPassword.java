package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.DBConnection;

/**
 * Servlet implementation class ForgetPassword
 */
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;

	@Override
	public void init() throws ServletException 
	{
		connection = DBConnection.getDBConnection();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PreparedStatement statement = null;
		String sql = "update student set password=? where email=?";
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

	
		String emailId = req.getParameter("email");
		String newPassword = req.getParameter("pass");
		String confirmPassword = req.getParameter("cpass");

		if (!emailId.equals("")) 
		{

			{
				if (newPassword.equals(confirmPassword))
				{
					try 
					{
						statement = connection.prepareStatement(sql);
						statement.setString(1, newPassword);
						statement.setString(2, emailId);

						int transaction = statement.executeUpdate();
						if (transaction > 0) 
						{
							//out.println("<div  style=\"background-image: url('images/1.jpg');\">");
							out.println("<h1 style='color:red; text-align=center'>");
							out.println("Password updated SuccessFully</h1>");
							out.print("<a href='log.jsp'>Login Page</a>");
							//out.println("</div>");

						}
					} 
					catch (Exception e)
					{
						e.printStackTrace();
						// TODO: handle exception
					}
				}
			}
		}
	}
}
