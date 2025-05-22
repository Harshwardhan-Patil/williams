package slip11;

import java.sql.*;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Oracle JDBC connection details
        String url = "jdbc:oracle:thin:@localhost:1521:XE";  // For Oracle 10g XE
        String user = "system";
        String password = "system";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Load Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.print("Enter Roll No to search: ");
            int rollNo = sc.nextInt();

            String query = "SELECT * FROM STUDENT WHERE roll_no = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, rollNo);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("\nStudent Details:");
                    System.out.println("Roll No: " + rs.getInt("roll_no"));
                    System.out.println("Name   : " + rs.getString("name"));
                    System.out.println("Class  : " + rs.getString("class"));
                    System.out.println("DOB    : " + rs.getDate("dob"));
                } else {
                    System.out.println("\nNo student found with Roll No: " + rollNo);
                }
            }

            System.out.println("\nAll Student Records:");
            String allQuery = "SELECT * FROM STUDENT";
            try (Statement stmt = conn.createStatement();
                 ResultSet rsAll = stmt.executeQuery(allQuery)) {

                System.out.printf("%-10s %-20s %-10s %-15s\n", "Roll No", "Name", "Class", "DOB");
                System.out.println("-------------------------------------------------------------");

                while (rsAll.next()) {
                    System.out.printf("%-10d %-20s %-10s %-15s\n",
                            rsAll.getInt("roll_no"),
                            rsAll.getString("name"),
                            rsAll.getString("class"),
                            rsAll.getDate("dob"));
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
