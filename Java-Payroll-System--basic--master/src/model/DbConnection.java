package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnection {

    static Connection conn = null;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // Updated driver
    static final String DB_USER_NAME = "root";
    static final String DB_PASSWORD = "root"; // Assuming 'root' as password
    static final String DB_NAME = "payroll";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/" + DB_NAME; // Corrected URL with port

    public static Connection getDbConnection() {

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Driver loaded successfully.");

            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD); // Updated URL and password
            System.out.println("Connection established successfully.");
            return conn;

        } catch (ClassNotFoundException ex1) {
            JOptionPane.showMessageDialog(null, "JDBC Driver not found! Please include the MySQL JDBC driver in your project.\n\n" + ex1.getMessage(), "ERROR", 0);
            ex1.printStackTrace();
            return null;

        } catch (SQLException ex2) {
            JOptionPane.showMessageDialog(null, "SQL Error! Please check your database connection settings.\n\n" + ex2.getMessage(), "ERROR", 0);
            ex2.printStackTrace();
            return null;

        } catch (Exception ex3) {
            JOptionPane.showMessageDialog(null, "Unknown Error! Please check your connection.\n\n" + ex3.getMessage(), "ERROR", 0);
            ex3.printStackTrace();
            return null;
        }
    }
}
