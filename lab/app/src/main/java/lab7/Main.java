package lab7;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab7.task1.Main(),
            new lab7.task2.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 7;
    }
}
