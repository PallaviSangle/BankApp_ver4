package com.bv.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.bv.connection.DBConnect;

public class SPDemo {

	public static void  callSp()
	{
		String sql="{call fetchdetails(?,?,?)}";
		Connection connection=DBConnect.getConnection();
		try
		{
		CallableStatement callableStatement=connection.prepareCall(sql);

		callableStatement.setInt(1, 103);
		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
		
		callableStatement.execute();
		String username=callableStatement.getString(2);
		String password=callableStatement.getString(3);
		System.out.println(username+" "+password);
		
		}
		catch(SQLException e) {
			e.printStackTrace();
	}
	}
	
}
