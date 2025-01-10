package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StudentManagementGUI {
    private final StudentManagerImpl studentManager;

    public StudentManagementGUI(StudentManagerImpl studentManager) {
        this.studentManager = studentManager;
    }

    public void show() {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        frame.add(inputPanel, BorderLayout.NORTH);

        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        frame.add(buttonPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update Student");
        JButton removeButton = new JButton("Remove Student");
        JButton displayButton = new JButton("Display All");
        JButton avgButton = new JButton("Calculate Average");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(avgButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            try {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                double grade = Double.parseDouble(gradeField.getText().trim());

                Student student = new Student(name, age, grade, id);
                studentManager.addStudent(student);
                outputArea.append("Student added successfully!\n");
            } catch (Exception ex) {
                outputArea.append("Error: " + ex.getMessage() + "\n");
            }
        });

        updateButton.addActionListener(e -> {
            try {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                double grade = Double.parseDouble(gradeField.getText().trim());

                Student student = new Student(name, age, grade, id);
                studentManager.updateStudent(id, student);
                outputArea.append("Student updated successfully!\n");
            } catch (Exception ex) {
                outputArea.append("Error: " + ex.getMessage() + "\n");
            }
        });

        removeButton.addActionListener(e -> {
            try {
                String id = idField.getText().trim();
                studentManager.removeStudent(id);
                outputArea.append("Student removed successfully!\n");
            } catch (Exception ex) {
                outputArea.append("Error: " + ex.getMessage() + "\n");
            }
        });

        displayButton.addActionListener(e -> {
            try {
                outputArea.setText("");
                for (Student student : studentManager.displayAllStudents()) {
                    outputArea.append(student.getStudentID() + ": " + student.getName() +
                            ", Age: " + student.getAge() + ", Grade: " + student.getGrade() + "\n");
                }
            } catch (Exception ex) {
                outputArea.append("Error: " + ex.getMessage() + "\n");
            }
        });

        avgButton.addActionListener(e -> {
            try {
                double avgGrade = studentManager.calculateAverageGrade();
                outputArea.append("Average Grade: " + avgGrade + "\n");
            } catch (Exception ex) {
                outputArea.append("Error: " + ex.getMessage() + "\n");
            }
        });

        frame.setVisible(true);
    }
}
