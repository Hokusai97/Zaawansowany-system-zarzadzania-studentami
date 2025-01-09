package src;

import java.sql.*;
import java.util.ArrayList;

public class StudentManagerImpl implements StudentManager {
    private Connection connection;

    public StudentManagerImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, age, grade, studentID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setDouble(3, student.getGrade());
            stmt.setString(4, student.getStudentID());
            stmt.executeUpdate();
        }
    }

    @Override
    public void removeStudent(String studentID) throws SQLException {
        String query = "DELETE FROM students WHERE studentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, studentID);
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateStudent(String studentID, Student student) throws SQLException {
        String query = "UPDATE students SET name = ?, age = ?, grade = ? WHERE studentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setDouble(3, student.getGrade());
            stmt.setString(4, studentID);
            stmt.executeUpdate();
        }
    }

    @Override
    public ArrayList<Student> displayAllStudents() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                students.add(new Student(
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getDouble("grade"),
                    rs.getString("studentID")
                ));
            }
        }
        return students;
    }

    @Override
    public double calculateAverageGrade() throws SQLException {
        String query = "SELECT AVG(grade) AS averageGrade FROM students";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getDouble("averageGrade");
            }
        }
        return 0.0;
    }
}
