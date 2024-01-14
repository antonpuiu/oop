package lab12;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab12.task1.Main(),
            new lab12.task2.Main(),
            new lab12.task3.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 12;
    }
}
