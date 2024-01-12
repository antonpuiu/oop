package lab1;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab1.task1.Main(),
            new lab1.task2.Main(),
            new lab1.task3.Main(),
            new lab1.task4.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 1;
    }
}
