package lab10.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    private Integer testNr = 0;

    private void printTestNr() {
        System.out.println("TEST " + ++testNr + " result:");
    }

    private Student createGenericStudent(final Float grade) {
        return new Student(grade);
    }

    @Override
    public void main() {
        final Tree<Student> tree = new TreeImpl<>();
        final List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            studentList.add(createGenericStudent((float) i));
        }

        printTestNr(); // 1
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 2
        for (int i = 0; i < 5; i++) {
            tree.addValue(createGenericStudent((float) i));
        }
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 3
        tree.addAll(studentList);
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 4
        final Student studentThatPassedExam = new Student(5.0f);
        final Student studentThatWorkedHardToPassTheExam = new Student(10.0f);
        final HashSet<Student> values = tree.getValues(studentThatPassedExam, studentThatWorkedHardToPassTheExam);
        System.out.println(values.size());
        values.stream().sorted().forEach(System.out::println);

        printTestNr(); // 5
        System.out.println(tree);
    }

    @Override
    public int getId() {
        return 2;
    }
}
