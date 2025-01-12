package src;

import javax.swing.*;
import java.awt.*;

public class StudentGUI {
    // Instancja implementacji menedżera studentów do zarządzania danymi
    private final StudentManagerImpl manager = new StudentManagerImpl();


    // Konstruktor klasy GUI
    public StudentGUI() {
        // Tworzenie głównego okna programu, przycisków, etykiet, pól tekstowych i układ
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamyka aplikację po zamknięciu okna
        frame.setSize(500, 400); // Ustawia rozmiar okna


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

        // Obszar wyjściowy do wyświetlania informacji
        JTextArea outputArea = new JTextArea();
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH); 


        // Obsługa akcji dla przycisku dodawania studenta
        addButton.addActionListener(e -> {
            try {
                // Pobieranie danych z pól tekstowych
                String id = idField.getText();
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double grade = Double.parseDouble(gradeField.getText());
                
                // Dodawanie studenta za pomocą menedżera
                manager.addStudent(new Student(name, age, grade, id));
                
                // Informacja zwrotna w obszarze wyjściowym i obsługa błędu i wyświetlanie komunikatu o błędzie
                outputArea.setText("Student added successfully.");
            } catch (Exception ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });


        // Obsługa akcji dla przycisku wyświetlania wszystkich studentów, czyszczenie i wyświetlanie
        displayButton.addActionListener(e -> {
            outputArea.setText(""); 
            for (Student s : manager.displayAllStudents()) {
                outputArea.append(s.getStudentID() + ": " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade() + "\n");
            }
        });


        // Dodawanie komponentów do panelu głównego
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


    // Metoda główna do uruchamiania GUI 
    public static void main(String[] args) {
        // uruchumienie GUI w oddzielnym wątku Swing
        SwingUtilities.invokeLater(StudentGUI::new);
    }
}
