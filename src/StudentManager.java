package src;

import java.util.ArrayList;

public interface StudentManager {
    void addStudent(Student student);
    ArrayList<Student> displayAllStudents();
    void updateStudent(String studentID, Student updatedStudent);
    void removeStudent(String studentID);
}
