public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManagerImpl();

        // Dodaj studentów
        manager.addStudent(new Student("Alice", 20, 85.5, "S001"));
        manager.addStudent(new Student("Bob", 22, 90.0, "S002"));

        // Wyświetl studentów
        for (Student student : manager.displayAllStudents()) {
            student.displayInfo();
            System.out.println();
        }

        // Oblicz średnią ocen
        System.out.println("Średnia ocen: " + manager.calculateAverageGrade());
    }
}
