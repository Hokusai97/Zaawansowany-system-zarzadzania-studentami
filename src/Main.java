package src;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }

        // Testowanie funkcji
        StudentManager studentManager = new StudentManagerImpl();
        Student student = new Student("Alice", 20, 85.5, "S001");
        studentManager.addStudent(student);
        studentManager.displayAllStudents().forEach(s -> System.out.println(s.getName()));
    }
}
