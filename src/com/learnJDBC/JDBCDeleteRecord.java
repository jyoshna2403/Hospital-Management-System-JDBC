package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBCDeleteRecord {

    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;

        String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
        String Username = "root";
        String Password = "HappyLearning";
        String DeleteRecord = "DELETE FROM students WHERE id=2";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        try {
            con = DriverManager.getConnection(URL, Username, Password);
            stmt = con.createStatement();
            stmt.execute(DeleteRecord);
            System.out.println("Successfully deleted");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("Terminated Successfully");
            } catch (Exception e) {
                System.out.println("Oops! Some serious issue: " + e.getMessage());
            }
        }
    }
}
