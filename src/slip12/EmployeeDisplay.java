package slip12;

import java.sql.*;

public class EmployeeDisplay {
    public static void main(String[] args) {
        // Oracle DB connection info
        String url = "jdbc:oracle:thin:@localhost:1521:XE";  // For Oracle 10g XE
        String user = "system";
        String password = "system";

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT emp_id, first_name, last_name, age, date_of_joining FROM EMPLOYEE";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-12s %-12s %-5s %-15s\n", "Emp_ID", "First Name", "Last Name", "Age", "Date of Joining");
            System.out.println("-----------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                int age = rs.getInt("age");
                Date doj = rs.getDate("date_of_joining");

                System.out.printf("%-10d %-12s %-12s %-5d %-15s\n", id, fname, lname, age, doj);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
