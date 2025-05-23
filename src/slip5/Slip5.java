import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdmissionEnquiryForm extends JFrame implements ActionListener {

    // Form components
    private JTextField nameField, emailField, phoneField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> courseBox;
    private JButton submitButton;

    public AdmissionEnquiryForm() {
        setTitle("Admission Enquiry Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Form labels and fields
        add(new JLabel("Full Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        ButtonGroup genderGroup = new ButtonGroup();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        add(genderPanel);

        add(new JLabel("Course:"));
        String[] courses = {"B.Sc", "B.Com", "B.A", "M.Sc", "M.Com", "M.A"};
        courseBox = new JComboBox<>(courses);
        add(courseBox);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        // Add empty label for layout spacing
        add(new JLabel());

        setVisible(true);
    }

    // Handle Submit button click
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Not Specified");
        String course = (String) courseBox.getSelectedItem();
        String email = emailField.getText();
        String phone = phoneField.getText();

        String message = "Admission Enquiry Received:\n\n" +
                         "Name: " + name + "\n" +
                         "Gender: " + gender + "\n" +
                         "Course: " + course + "\n" +
                         "Email: " + email + "\n" +
                         "Phone: " + phone;

        JOptionPane.showMessageDialog(this, message, "Enquiry Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new AdmissionEnquiryForm();
    }
}
