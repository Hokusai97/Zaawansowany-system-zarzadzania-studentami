package src;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Connection to the database successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }

        // Testowanie funkcji
        StudentManager studentManager = new StudentManagerImpl();
        Student student = new Student("Rafał", 27, 99.9, "S001");
        studentManager.addStudent(student);
        studentManager.displayAllStudents().forEach(s -> System.out.println(s.getName()));
    }
}
