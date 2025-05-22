package oracle;

import java.sql.*;

public class FirstJdbc {

    public static void main(String[] args) {
        // Database credentials and URL
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "system";
        String password = "system";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to the database
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to Oracle DB.");

            // SQL insert statement
            String insertSQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";

            // Prepare the statement
            pstmt = conn.prepareStatement(insertSQL);

            // Set values
            pstmt.setInt(1, 2);
            pstmt.setString(2, "amol");
            pstmt.setString(3, "amol123@gmail.com");

            // Execute the insert
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
