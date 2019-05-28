package com.bridgelabz.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection
{
	private static Connection connection;

	private DBConnection()
	{

	}

	static 
	{

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DBConnection.");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "avani");
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			// TODO: handle exception
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static Connection getDBConnection() 
	{

		return connection;
	}

}