public class Student {
    private String name;       // Imię studenta
    private int age;           // Wiek studenta
    private double grade;      // Ocena studenta
    private String studentID;  // Unikalny identyfikator studenta

    // Konstruktor
    public Student(String name, int age, double grade, String studentID) {
        if (age <= 0) {
            throw new IllegalArgumentException("Wiek musi być dodatni.");
        }
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("Ocena musi być w zakresie od 0.0 do 100.0.");
        }
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentID = studentID;
    }

    // Gettery i Settery
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Wiek musi być dodatni.");
        }
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("Ocena musi być w zakresie od 0.0 do 100.0.");
        }
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Metoda wyświetlająca szczegóły studenta
    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}
