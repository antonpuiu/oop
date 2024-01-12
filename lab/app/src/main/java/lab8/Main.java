package lab8;

import utils.*;

public class Main extends LabUnitTask {
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
