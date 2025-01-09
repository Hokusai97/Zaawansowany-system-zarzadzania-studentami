package src;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String studentID;

    public Student(String name, int age, double grade, String studentID) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be on +.");
        }
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("Grade have to be betoween 0.0 - 100.0.");
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
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
