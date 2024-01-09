package lab1.task4;

import java.util.Random;

public class Internship {
    private String name;
    private String minGrade;
    private Student[] students;

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
            if (student.getGrade() >= Double.valueOf(minGrade))
                System.out.printf("Candidate %s got a phone interview at %s\n", student.getName(), name);
    }
}
