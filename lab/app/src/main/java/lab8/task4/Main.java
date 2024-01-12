package lab8.task4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import lab8.task1.Student;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Map<Student, LinkedList<String>> studentMap = new HashMap<>();
        lab8.Main.students.forEach(s -> studentMap.putIfAbsent(s, new LinkedList<>()));

        for (var list : studentMap.values())
            for (int i = 0; i < 4; i++)
                list.addFirst(lab8.Main.subjects.get(lab8.Main.random.nextInt(lab8.Main.subjects.size() - 1)));

        System.out.println(studentMap);
    }

    @Override
    public int getId() {
        return 4;
    }
}
