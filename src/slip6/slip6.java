package slip6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 class ShapeCalculator extends JFrame {
    JRadioButton circleBtn, rectangleBtn, squareBtn;
    JCheckBox areaCheck, perimeterCheck, circumCheck;
    JTextField radiusField, lengthField, widthField, sideField;
    JTextArea resultArea;
    JButton calculateBtn, exitBtn;
    public ShapeCalculator() {
        setTitle("Shape Calculator");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder("Select Shape"));
        circleBtn = new JRadioButton("Circle");
        rectangleBtn = new JRadioButton("Rectangle");
        squareBtn = new JRadioButton("Square");
        ButtonGroup group = new ButtonGroup();
        group.add(circleBtn);
        group.add(rectangleBtn);
        group.add(squareBtn);
        panel1.add(circleBtn);
        panel1.add(rectangleBtn);
        panel1.add(squareBtn);
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("Select Operations"));
        areaCheck = new JCheckBox("Area");
        perimeterCheck = new JCheckBox("Perimeter");
        circumCheck = new JCheckBox("Circumference");
        panel2.add(areaCheck);
        panel2.add(perimeterCheck);
        panel2.add(circumCheck);
        radiusField = new JTextField(10);
        lengthField = new JTextField(10);
        widthField = new JTextField(10);
        sideField = new JTextField(10);
        add(new JLabel("Radius:")); add(radiusField);
        add(new JLabel("Length:")); add(lengthField);
        add(new JLabel("Width:")); add(widthField);
        add(new JLabel("Side:")); add(sideField);
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        calculateBtn = new JButton("Calculate");
        exitBtn = new JButton("Exit");
        add(panel1);
        add(panel2);
        add(calculateBtn);
        add(exitBtn);
        add(new JScrollPane(resultArea));
        disableAllFields();
        circleBtn.addActionListener(e -> {
            disableAllFields();
            radiusField.setEnabled(true);
            circumCheck.setEnabled(true);
            areaCheck.setEnabled(true);
            perimeterCheck.setEnabled(false);
        });
        rectangleBtn.addActionListener(e -> {
            disableAllFields();
            lengthField.setEnabled(true);
            widthField.setEnabled(true);
            areaCheck.setEnabled(true);
            perimeterCheck.setEnabled(true);
            circumCheck.setEnabled(false);
        });
        squareBtn.addActionListener(e -> {
            disableAllFields();
            sideField.setEnabled(true);
            areaCheck.setEnabled(true);
            perimeterCheck.setEnabled(true);
            circumCheck.setEnabled(false);
        });
        calculateBtn.addActionListener(e -> {
            resultArea.setText("");
            if (circleBtn.isSelected()) {
                double r = Double.parseDouble(radiusField.getText());
                if (areaCheck.isSelected())
                    resultArea.append("Circle Area: " + (Math.PI * r * r) + "\n");
                if (circumCheck.isSelected())
                    resultArea.append("Circle Circumference: " + (2 * Math.PI * r) + "\n");
            } else if (rectangleBtn.isSelected()) {
                double l = Double.parseDouble(lengthField.getText());
                double w = Double.parseDouble(widthField.getText());
                if (areaCheck.isSelected())
                    resultArea.append("Rectangle Area: " + (l * w) + "\n");
                if (perimeterCheck.isSelected())
                    resultArea.append("Rectangle Perimeter: " + (2 * (l + w)) + "\n");
            } else if (squareBtn.isSelected()) {
                double s = Double.parseDouble(sideField.getText());
                if (areaCheck.isSelected())
                    resultArea.append("Square Area: " + (s * s) + "\n");
                if (perimeterCheck.isSelected())
                    resultArea.append("Square Perimeter: " + (4 * s) + "\n");
            } else {
                resultArea.append("Please select a shape.");
            }
        });
        exitBtn.addActionListener(e -> System.exit(0));
        setVisible(true);
    }

    private void disableAllFields() {
        radiusField.setEnabled(false);
        lengthField.setEnabled(false);
        widthField.setEnabled(false);
        sideField.setEnabled(false);
        areaCheck.setEnabled(false);
        perimeterCheck.setEnabled(false);
        circumCheck.setEnabled(false);
        areaCheck.setSelected(false);
        perimeterCheck.setSelected(false);
        circumCheck.setSelected(false);
    }

    }

public class slip6 {
	public static void main(String[] args) {
        new ShapeCalculator();
    }

}
