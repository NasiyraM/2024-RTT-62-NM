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

        // Update the employee's first and last name
        SelectSQL = "update employees set firstName=? , lastName=? where id=?";
        mystmt = conn.prepareStatement(SelectSQL);
        mystmt.setString(1, "Gary");
        mystmt.setString(2, "Larson");
        mystmt.setLong  (3, 1002);
        mystmt.executeUpdate();


        // Verify the update
        String selectSQL = "SELECT firstName, lastName FROM employees WHERE id = ?";
        mystmt = conn.prepareStatement(selectSQL);
        mystmt.setInt(1, 1002);
        result = mystmt.executeQuery();

        while (result.next()) {
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            System.out.println("Updated Employee: " + firstName + " " + lastName);
        }

        // Close resources
        result.close();
        mystmt.close();
        conn.close();
    }
}