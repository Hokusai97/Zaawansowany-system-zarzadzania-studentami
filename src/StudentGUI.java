package src;

import javax.swing.*;
import java.awt.*;

public class StudentGUI {
    private final StudentManagerImpl manager = new StudentManagerImpl();

    public StudentGUI() {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        frame.add(panel, BorderLayout.CENTER);

        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();

        JButton addButton = new JButton("Add Student");
        JButton displayButton = new JButton("Display All Students");

        JTextArea outputArea = new JTextArea();
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            try {
                String id = idField.getText();
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double grade = Double.parseDouble(gradeField.getText());
                manager.addStudent(new Student(name, age, grade, id));
                outputArea.setText("Student added successfully.");
            } catch (Exception ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });

        displayButton.addActionListener(e -> {
            outputArea.setText("");
            for (Student s : manager.displayAllStudents()) {
                outputArea.append(s.getStudentID() + ": " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade() + "\n");
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(addButton);
        panel.add(displayButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGUI::new);
    }
}
