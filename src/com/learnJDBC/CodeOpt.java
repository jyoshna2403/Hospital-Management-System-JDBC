package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class CodeOpt {

	public static void main(String[] args) {
		Connection con=null;
		Statement stat=null;
		ResultSet rs=null;
		// TODO Auto-generated method stub
		String URL="jdbc:mysql://localhost:3306/JDBCMySQL";
		
		String Username = "root";
	    String Password = "HappyLearning";

	    // Query that we want to execute
	    String query = "select * from Students";

	    try {
	    	con=DriverManager.getConnection(URL,Username,Password);
			stat=con.createStatement();
			rs=stat.executeQuery("select * from students");
			while(rs.next())
			{
				System.out.println("________________________________");
				
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String dept=rs.getString("dept");
				
				System.out.println("Student ID:"+id);
				System.out.println("Student name:"+name);
				System.out.println("Student Department:"+dept);
				
				System.out.println("________________________________");
			}
			rs.close();
			stat.close();
			con.close();
			
	    } catch(SQLException e) {
	        System.out.println("In catch" + e.getMessage());
	    }
	        finally
	        {
	        if (con != null)
	        {
	        try {
	            rs.close();
	            stat.close();
	            con.close();

	            System.out.println("Terminated Successfully");
	        }
	        catch(Exception e)
	        {
	            System.out.println("Oops ! some serious issue");
	        }
	    }
	    }
	}
}



