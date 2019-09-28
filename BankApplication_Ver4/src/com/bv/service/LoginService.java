package com.bv.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.connection.DBConnect;

public class LoginService {

	public static void getDetails() {
		try {

			/*
			 * String sql="select * from loginDetails"; Connection
			 * connection=DBConnect.getConnection(); //createStatement():Takes the query
			 * towards the database through network Statement
			 * statement=connection.createStatement(); ResultSet
			 * resultSet=statement.executeQuery(sql); while(resultSet.next())
			 * 
			 * System.out.println(resultSet.getInt(1) + " " +resultSet.getString(2)
			 * +" "+resultSet.getString(3));
			
			*/
			//For fetch the data for a particular acc_no 
			String sql = "select * from logindetails where acc_no=? ";
			Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 101);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())

				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
		}
		
	

		catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static boolean validateUser(int acc_no, String password)
	{
		boolean status = false;
		String sql = "select * from account "
				+ "where acc_no = ? and password = ?";
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acc_no);
			pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		status = true;
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
		
	public static boolean validateUser(String username, String password)
	{
		boolean status = false;
		String sql = "select * from logindetails "
				+ "where username = ? and password = ?";
		Connection con = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		status = true;
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
}
