package lab2;

import utils.*;

public class Main extends Runner
{
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab2.task1.Complex(),
            new lab2.task2.Main(),
            new lab2.task3.Polygon(),
            new lab2.task4.Main()
        };

        return tasks;
    }

    @Override
    public String getUnit() {
        return "task";
    }

    @Override
    public int getId() {
        return 2;
    }
}
