package slip10;


import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentNavigator extends JFrame {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    JTextField idField, nameField, ageField, courseField;
    JButton btnFirst, btnNext, btnPrevious, btnLast;

    public StudentNavigator() {
        setTitle("Student Record Navigator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("ID:"));
        idField = new JTextField();
        idField.setEditable(false);
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        nameField.setEditable(false);
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        ageField.setEditable(false);
        add(ageField);

        add(new JLabel("Course:"));
        courseField = new JTextField();
        courseField.setEditable(false);
        add(courseField);

        btnFirst = new JButton("First");
        btnPrevious = new JButton("Previous");
        btnNext = new JButton("Next");
        btnLast = new JButton("Last");

        add(btnFirst);
        add(btnPrevious);
        add(btnNext);
        add(btnLast);

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Oracle 10g XE URL format: jdbc:oracle:thin:@hostname:port:SID
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "system"
            );

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM student");

            if (rs.next()) {
                showRecord();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }

        btnFirst.addActionListener(e -> moveToFirst());
        btnPrevious.addActionListener(e -> moveToPrevious());
        btnNext.addActionListener(e -> moveToNext());
        btnLast.addActionListener(e -> moveToLast());

        setVisible(true);
    }

    void showRecord() {
        try {
            idField.setText(String.valueOf(rs.getInt("id")));
            nameField.setText(rs.getString("name"));
            ageField.setText(String.valueOf(rs.getInt("age")));
            courseField.setText(rs.getString("course"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error displaying record.");
        }
    }

    void moveToFirst() {
        try {
            if (rs.first()) showRecord();
        } catch (SQLException e) { }
    }

    void moveToLast() {
        try {
            if (rs.last()) showRecord();
        } catch (SQLException e) { }
    }

    void moveToNext() {
        try {
            if (!rs.isLast() && rs.next()) showRecord();
        } catch (SQLException e) { }
    }

    void moveToPrevious() {
        try {
            if (!rs.isFirst() && rs.previous()) showRecord();
        } catch (SQLException e) { }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentNavigator::new);
    }
}
