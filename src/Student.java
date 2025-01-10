package src;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String studentID;

    public Student(String name, int age, double grade, String studentID) {
        if (age <= 0 || grade < 0.0 || grade > 100.0 || studentID.isEmpty()) {
            throw new IllegalArgumentException("Invalid student data");
        }
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentID = studentID;
    }

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
        if (age <= 0) throw new IllegalArgumentException("Age must be positive");
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade < 0.0 || grade > 100.0) throw new IllegalArgumentException("Grade must be between 0 and 100");
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}
