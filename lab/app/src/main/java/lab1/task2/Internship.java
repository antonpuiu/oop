package lab1.task2;

import java.util.Random;

public class Internship {
    String name;
    String minGrade;
    Student[] students;

    public Internship(String name, String minGrade, Student[] students) {
        this.name = name;
        this.minGrade = minGrade;
        this.students = students;
    }

    public Student chooseCandidateRandomly() {
        return students[new Random().nextInt(students.length)];
    }

    public void chooseCandidatesForInterview() {
        for (Student student : students)
            if (student.grade >= Double.valueOf(minGrade))
                System.out.printf("Candidate %s got a phone interview at %s\n", student.name, name);
    }
}
