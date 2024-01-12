package lab6;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab6.task1.Main(),
            new lab6.task2.Main(),
            new lab6.task3.Main(),
            new lab6.task4.Main(),
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 6;
    }
}
