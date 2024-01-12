package lab8;

import lab8.task1.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.*;

public class Main extends LabUnitTask {
    public static ArrayList<Student> students;
    public static List<Student> copyStudents;
    public static List<Student> anotherCopyStudents;
    public static List<Integer> numbers;
    public static ArrayList<String> subjects;
    public static Random random;

    static {
        students = new ArrayList<>() {{
            add(new Student("Maria", "Popescu", 3, 8.5));
            add(new Student("Ion", "Grigorescu", 2, 8));
            add(new Student("Ana", "Enescu", 7, 7));
            add(new Student("Mihai", "Eminovici", 1, 4.45));
            add(new Student("Andrei", "Radu", 12, 2));
        }};

        copyStudents = new ArrayList<>(students);
        anotherCopyStudents = new ArrayList<>(students);

        numbers = List.of(10, 20, 5, 243, 5556, 312, 566, 245, 122, 5556, 5, 10, 20, 122);
        subjects = new ArrayList<>(List.of("PP", "PA", "PCOM", "IOCLA", "AA",
                "SO", "CPL", "EP", "RL", "LFA"));

        random = new Random(12);
    }

    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab8.task1.Main(),
            new lab8.task2.Main(),
            new lab8.task3.Main(),
            new lab8.task4.Main(),
            new lab8.task5.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 8;
    }
}
