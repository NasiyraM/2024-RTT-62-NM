package org.example;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExamplePrepareStat {
    public static void main(String[] args) throws Exception {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection details
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        final String user = "root";
        final String password = "Mccorkle#1";

        // Establishing the connection
        Connection conn = DriverManager.getConnection(dburl, user, password);

        // SQL query
        String SelectSQL = "SELECT * FROM employees WHERE id = ?";

        // Create the PreparedStatement
        PreparedStatement mystmt = conn.prepareStatement(SelectSQL);
        mystmt.setInt(1, 1002);

        // Execute the query
        ResultSet result = mystmt.executeQuery();

        // Process the result set
        while (result.next()) {
            String name = result.getString("firstName");
            String email = result.getString("email");
            System.out.println(name + " | " + email);
        }

        // Close resources
        result.close();
        mystmt.close();
        conn.close();
    }
}