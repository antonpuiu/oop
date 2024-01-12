package lab1.task3;

import lab1.task2.Student;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Student student = new Student("A", 5.4);
        Student copy = new Student(student);

        System.out.printf("Result of equals: %b\n", student.equals(copy));
    }

    @Override
    public int getId() {
        return 3;
    }
}
