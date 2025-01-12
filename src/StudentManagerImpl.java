package src;

import java.sql.*;
import java.util.ArrayList;

// Implementacja interfejsu StudentManager oraz obliczenia na danych studentów w bazie SQLite
public class StudentManagerImpl implements StudentManager {
    private final String url = "jdbc:sqlite:database/students.db"; // Ścieżka do pliku bazy danych SQLite

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url); // Tworzy połączenie z bazą danych
    }


    // SQL do wstawienia nowego rekordu studenta do tabeli "students" i obsługa błędu
    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age, grade, studentID) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setDouble(3, student.getGrade());
            pstmt.setString(4, student.getStudentID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }


    // SQL do usunięcia studenta na podstawie jego unikalnego identyfikatora (studentID) i obsługa błędu
    @Override
    public void removeStudent(String studentID) {
        String sql = "DELETE FROM students WHERE studentID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentID);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new IllegalArgumentException("Student ID not found");
            }
        } catch (SQLException e) {
            System.err.println("Error removing student: " + e.getMessage());
        }
    }

        // SQL do aktualizacji rekordu studenta na podstawie jego unikalnego identyfikatora (studentID) i obsługa błędu
    @Override
    public void updateStudent(String studentID, Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, grade = ? WHERE studentID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setDouble(3, student.getGrade());
            pstmt.setString(4, studentID);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new IllegalArgumentException("Student ID not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error while updating student: " + e.getMessage());
            throw new RuntimeException(e); 
        }
    }

    @Override
    public ArrayList<Student> displayAllStudents() {
        // Tworzenie listy do przechowywania obiektów student i obsługa błędu
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students"; // SQL do pobrania wszystkiego z tabeli students

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getDouble("grade"),
                    rs.getString("studentID")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }

        return students;
    }

    @Override
    public double calculateAverageGrade() {
        // SQL do obliczenia średniej ocen w tabeli "students" i obsługa błędu 
        String sql = "SELECT AVG(grade) AS averageGrade FROM students";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getDouble("averageGrade");
        } catch (SQLException e) {
            System.err.println("Error calculating average grade: " + e.getMessage());
        }

        return 0.0;
    }
}
