package lab5;

import utils.*;

public class Main extends Runner
{
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab5.task1.Main(),
            new lab5.task2.Main(),
            new lab5.task3.Main(),
            new lab5.task4.Main()
        };

        return tasks;
    }

    @Override
    public String getUnit() {
        return "task";
    }

    @Override
    public int getId() {
        return 5;
    }
}
