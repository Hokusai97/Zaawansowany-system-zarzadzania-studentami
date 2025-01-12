package src;

import java.util.ArrayList;

// Interfejs operacji zarządzania studentami (dodaje, usuwa, aktualizuje, wpobiera liste, oblicza średnią ocen wszystkich studentów z bazy danych)
public interface StudentManager {
    void addStudent(Student student);
    void removeStudent(String studentID);
    void updateStudent(String studentID, Student student);
    ArrayList<Student> displayAllStudents();
    double calculateAverageGrade();
}
