package lab10;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab10.task1.Main(),
            new lab10.task2.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 10;
    }
}
