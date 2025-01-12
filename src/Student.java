package src;

// Klasa reprezentująca studenta
public class Student {
    // Pola przechowujące dane studenta
    private String name;
    private int age;
    private double grade;
    private String studentID;

    // Konstruktor inicjalizujący obiekt studenta z walidacją danych
    public Student(String name, int age, double grade, String studentID) {
        // Walidacja danych wejściowych
        if (age <= 0 || grade < 0.0 || grade > 100.0 || studentID.isEmpty()) {
            throw new IllegalArgumentException("Student not added - invalid student data. Age must be a positive number and grade have to bet between 0 - 100.");
        }
        this.name = name; // Ustawia imię studenta
        this.age = age;   // Ustawia wiek studenta
        this.grade = grade; // Ustawia ocenę studenta
        this.studentID = studentID; // Ustawia unikalny ID studenta
    }


    // Getter dla imienia studenta
    public String getName() {
        return name;
    }


    // Setter dla imienia studenta
    public void setName(String name) {
        this.name = name;
    }


    // Getter dla wieku studenta
    public int getAge() {
        return age;
    }


    // Setter dla wieku studenta z walidacją
    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be positive");
        this.age = age;
    }


    // Getter dla oceny studenta
    public double getGrade() {
        return grade;
    }


    // Setter dla oceny studenta z walidacją
    public void setGrade(double grade) {
        if (grade < 0.0 || grade > 100.0) throw new IllegalArgumentException("Grade have to be between 0 - 100");
        this.grade = grade;
    }


    // Getter dla ID studenta
    public String getStudentID() {
        return studentID;
    }

    
    // Metoda wyświetlająca informacje o studencie
    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}
