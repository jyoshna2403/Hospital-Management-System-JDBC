package com.learnJDBC;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCMySQL","root","HappyLearning");
		Statement stat=con.createStatement();
		
		ResultSet rs=stat.executeQuery("select * from students");
		
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
	}

}
