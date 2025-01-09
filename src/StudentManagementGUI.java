package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentManagementGUI {
    private JFrame frame;
    private JTextField studentIdField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField gradeField;
    private JTextArea outputArea;
    private StudentManager studentManager;

    public StudentManagementGUI(StudentManager studentManager) {
        this.studentManager = studentManager;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Student Management System");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Panel wejściowy
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        inputPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        inputPanel.add(studentIdField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Grade:"));
        gradeField = new JTextField();
        inputPanel.add(gradeField);

        // Panel przycisków
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Student");
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove Student");
        buttonPanel.add(removeButton);

        JButton updateButton = new JButton("Update Student");
        buttonPanel.add(updateButton);

        JButton displayButton = new JButton("Display All Students");
        buttonPanel.add(displayButton);

        JButton averageButton = new JButton("Calculate Average");
        buttonPanel.add(averageButton);

        // Obszar wyjściowy
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);

        // Obsługa zdarzeń
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = studentIdField.getText();
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    double grade = Double.parseDouble(gradeField.getText());

                    if (age <= 0 || grade < 0.0 || grade > 100.0) {
                        throw new IllegalArgumentException("Invalid age or grade.");
                    }

                    Student student = new Student(name, age, grade, id);
                    studentManager.addStudent(student);
                    outputArea.append("Student added successfully!\n");
                } catch (Exception ex) {
                    outputArea.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = studentIdField.getText();
                    studentManager.removeStudent(id);
                    outputArea.append("Student removed successfully!\n");
                } catch (Exception ex) {
                    outputArea.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = studentIdField.getText();
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    double grade = Double.parseDouble(gradeField.getText());

                    if (age <= 0 || grade < 0.0 || grade > 100.0) {
                        throw new IllegalArgumentException("Invalid age or grade.");
                    }

                    Student student = new Student(name, age, grade, id);
                    studentManager.updateStudent(id, student);
                    outputArea.append("Student updated successfully!\n");
                } catch (Exception ex) {
                    outputArea.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Student> students = studentManager.displayAllStudents();
                    outputArea.append("Students:\n");
                    for (Student s : students) {
                        outputArea.append(s.getName() + "\n");
                    }
                } catch (Exception ex) {
                    outputArea.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });

        averageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double average = studentManager.calculateAverageGrade();
                    outputArea.append("Average Grade: " + average + "\n");
                } catch (Exception ex) {
                    outputArea.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }
}
