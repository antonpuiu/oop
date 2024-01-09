package lab1.task2;

import utils.MainTask;

public class JobMarket implements MainTask {
    @Override
    public void main() {
        Student[] students = {
            new Student("Gigel", 8.5),
            new Student("Dorel", 4.0),
            new Student("Marcel", 6.5),
            new Student("Ionel", 7.0)
        };

        Internship[] internships = {
            new Internship("Google", "8.5", students),
            new Internship("Amazon", "6.5", students),
            new Internship("Facebook", "9.0", students),
            new Internship("Microsoft", "10.0", students)
        };

        for (Internship intern : internships)
            intern.chooseCandidatesForInterview();
    }

    @Override
    public int getId() {
        return 2;
    }
}
