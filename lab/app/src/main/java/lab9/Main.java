package lab9;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab9.task1.Main(),
            new lab9.task2.Main(),
            new lab9.task3.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 9;
    }
}
