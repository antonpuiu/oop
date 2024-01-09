package lab1.task4;

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student(Student student) {
        name = student.name;
        grade = student.grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            return false;

        Student student = (Student) obj;

        return name.equals(student.name) && grade == student.grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}
