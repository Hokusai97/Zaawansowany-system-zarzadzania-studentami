package src;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentManager {
    void addStudent(Student student) throws SQLException;

    void removeStudent(String studentID) throws SQLException;

    void updateStudent(String studentID, Student student) throws SQLException;

    ArrayList<Student> displayAllStudents() throws SQLException;

    double calculateAverageGrade() throws SQLException;
}
