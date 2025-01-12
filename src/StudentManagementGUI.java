package src;

import javax.swing.*;
import java.awt.*;

public class StudentManagementGUI {
    private final StudentManagerImpl studentManager;

    // Konstruktor który inicjalizuje GUI z menedżerem studentów.
    public StudentManagementGUI(StudentManagerImpl studentManager) {
        this.studentManager = studentManager;
    }

    public void show() {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 900);

        // Panel na górze programu i tworzenie etykiet, pola tekstowe dla danych studenta
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        frame.add(inputPanel, BorderLayout.NORTH);

        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();


        // Dodawanie komponentów do panelu wejściowego
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);


        // Panel przycisków na dole, dodawanie przycisków z nazwami i dodawanie przycisków do panelu
        JPanel buttonPanel = new JPanel(new GridLayout(1, 6, 10, 10));
        frame.add(buttonPanel, BorderLayout.SOUTH);



        JButton addButton = createSmallButton("Add student");
        JButton updateButton = createSmallButton("Update student");
        JButton removeButton = createSmallButton("Remove student");
        JButton displayButton = createSmallButton("Display all students");
        JButton avgButton = createSmallButton("Calculate average grade");
        JButton helpButton = createSmallButton("Instrucion");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(avgButton);
        buttonPanel.add(helpButton);



        // Obszar wyświetlania informacji
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);


        // Wyświetlanie informacji o tym jak uzywac programu na starcie wlaczenia
        JOptionPane.showMessageDialog(frame,
                "How to use?\n"
                + "- Student ID: 1,2,3,4,5 - unical positive number.\n"
                + "- Name: Max units 50.\n"
                + "- Age: have to be positive number .\n"
                + "- Remove: you can remove student by only Student ID .\n"
                + "- Grade: 0.0 - 100.0.",
                "Instruction",
                JOptionPane.INFORMATION_MESSAGE);


        // Obsługa wszystkich przycisków
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


        helpButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "How to use?\n"
                    + "- Student ID: 1,2,3,4,5 - unical positive number.\n"
                    + "- Name: Max units 50.\n"
                    + "- Age: have to be positive number .\n"
                    + "- Remove: you can remove student by only Student ID .\n"
                    + "- Grade: 0.0 - 100.0.",
                    "Instruction",
                    JOptionPane.INFORMATION_MESSAGE);
        });


        frame.setVisible(true);
    }


    // Metoda tworzeąca przycisk z określonym tesktem i rozmiarem
    private JButton createSmallButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 40)); 
        return button;
    }
}
