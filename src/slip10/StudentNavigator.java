import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentNavigator extends JFrame implements ActionListener {
    JButton btnFirst, btnNext, btnPrev, btnLast;
    JTextField txtId, txtName, txtAge, txtCourse;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public StudentNavigator() {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("ID:"));
        txtId = new JTextField(); add(txtId);

        add(new JLabel("Name:"));
        txtName = new JTextField(); add(txtName);

        add(new JLabel("Age:"));
        txtAge = new JTextField(); add(txtAge);

        add(new JLabel("Course:"));
        txtCourse = new JTextField(); add(txtCourse);

        btnFirst = new JButton("First"); add(btnFirst);
        btnPrev = new JButton("Previous"); add(btnPrev);
        btnNext = new JButton("Next"); add(btnNext);
        btnLast = new JButton("Last"); add(btnLast);

        btnFirst.addActionListener(this);
        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnLast.addActionListener(this);

        connectToDatabase();
        loadFirstRecord();

        setTitle("Student Navigator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void connectToDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", // Change SID if needed
                "chaitanya", // Replace with your Oracle username
                "chaitanya"  // Replace with your Oracle password
            );
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM STUDENT");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DB Error: " + e.getMessage());
        }
    }

    void loadRecord() {
        try {
            txtId.setText(rs.getString("ID"));
            txtName.setText(rs.getString("NAME"));
            txtAge.setText(rs.getString("AGE"));
            txtCourse.setText(rs.getString("COURSE"));
        } catch (Exception e) {
            System.out.println("Error loading record: " + e.getMessage());
        }
    }

    void loadFirstRecord() {
        try {
            if (rs.first()) loadRecord();
        } catch (Exception e) {}
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == btnFirst) {
                if (rs.first()) loadRecord();
            } else if (ae.getSource() == btnLast) {
                if (rs.last()) loadRecord();
            } else if (ae.getSource() == btnNext) {
                if (!rs.isLast() && rs.next()) loadRecord();
            } else if (ae.getSource() == btnPrev) {
                if (!rs.isFirst() && rs.previous()) loadRecord();
            }
        } catch (Exception e) {
            System.out.println("Navigation Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentNavigator();
    }
}
