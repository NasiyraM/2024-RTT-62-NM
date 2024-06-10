package GLAB_305_2_1;
import java.sql.*;

public class Insert_preparedSt_Example {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        String user= "root";
        String password = "MYpassword";
        try {
            con = DriverManager.getConnection(dburl, user, password);
            System.out.println("Connection established successfully!");

            // Insert a record using a prepared statement
            String sqlQuery = "INSERT INTO EMPLOYEES (office_id,firstName,lastName,email,extension,reports_to,vacation_hours,id,job_title) VALUES (?,?,?,?,?,?,?,?,?)";
            prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, 6);
            prepStmt.setString(2, "Jamil");
            prepStmt.setString(3, "fink");
            prepStmt.setString(4, "JJJJ@gmail.com");
            prepStmt.setString(5, "2759");
            prepStmt.setInt(6, 1143);
            prepStmt.setInt(7, 9);
            prepStmt.setInt(8, 100444); // Ensure this ID is unique
            prepStmt.setString(9, "Manager");
            int affectedRows = prepStmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected !!");

            // Pull data from the database for the inserted record
            prepStmt = con.prepareStatement("SELECT * FROM employees WHERE id = ?");
            prepStmt.setInt(1, 100444); // Use the same unique ID
            rs = prepStmt.executeQuery();

            // Display the result set
            while (rs.next()) {
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastName"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("office_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (prepStmt != null) prepStmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
