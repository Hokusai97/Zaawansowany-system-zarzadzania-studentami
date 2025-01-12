package src;

import java.sql.*;
import java.util.ArrayList;

// Ścieżka do bazy danych i połączenie 
public class StudentManagerImpl implements StudentManager {
    private final String url = "jdbc:sqlite:database/students.db";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url);
    }

  
    // Konstruktor klasy
    public StudentManagerImpl() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            // Tworzenie tabeli, jeśli nie istnieje
            String sql = "CREATE TABLE IF NOT EXISTS students (" +
                         "name TEXT, age INTEGER, grade REAL, studentID TEXT PRIMARY KEY)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

  
    @Override
    public void addStudent(Student student) {
        // dodaje studenta do bazy danych
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



    @Override
    public void removeStudent(String studentID) {
        // Usuwa studenta z bazy danyhc
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



    @Override
    public void updateStudent(String studentID, Student student) {
        // Aktualizuje studenta z bazy danych
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
        // Pobiera liste wszystkich studentwó z bazy danych
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
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
        // Oblicza średnią ocenę studentów
        String sql = "SELECT AVG(grade) AS averageGrade FROM students";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getDouble("averageGrade");
        } catch (SQLException e) {
            System.err.println("Error calculating average grade: " + e.getMessage());
        }
        return 0.0;
    }
}
