package lab8.task3;

import lab8.task1.Student;

import utils.TaskUnitTask;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(Comparator.comparing(Student::getId));

        priorityQueue.addAll(lab8.Main.anotherCopyStudents);

        System.out.println(priorityQueue);
    }

    @Override
    public int getId() {
        return 3;
    }
}
