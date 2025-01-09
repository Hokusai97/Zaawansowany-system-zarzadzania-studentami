import java.util.ArrayList;

public interface StudentManager {
    void addStudent(Student student);                // Dodaje nowego studenta
    void removeStudent(String studentID);            // Usuwa studenta po ID
    void updateStudent(String studentID);            // Aktualizuje dane studenta
    ArrayList<Student> displayAllStudents();         // Zwraca listę wszystkich studentów
    double calculateAverageGrade();                  // Oblicza średnią ocen studentów
}
