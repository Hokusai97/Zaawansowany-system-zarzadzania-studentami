import java.util.ArrayList;

public class StudentManagerImpl implements StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(String studentID) {
        students.removeIf(student -> student.getStudentID().equals(studentID));
    }

    @Override
    public void updateStudent(String studentID) {
        // Placeholder - szczegóły implementacji w kolejnych punktach
    }

    @Override
    public ArrayList<Student> displayAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public double calculateAverageGrade() {
        return students.stream().mapToDouble(Student::getGrade).average().orElse(0.0);
    }
}
