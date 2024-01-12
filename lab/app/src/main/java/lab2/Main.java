package lab2;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab2.task1.Main(),
            new lab2.task2.Main(),
            new lab2.task3.Main(),
            new lab2.task4.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 2;
    }
}
