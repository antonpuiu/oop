package lab3;

import utils.*;

public class Main extends Runner
{
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab3.task1.Main(),
            new lab3.task2.Main(),
            new lab3.task3.Main(),
            new lab3.task4.Main(),
            new lab3.task5.Main(),
            new lab3.task6.Main()
        };

        return tasks;
    }

    @Override
    public String getUnit() {
        return "task";
    }

    @Override
    public int getId() {
        return 3;
    }
}
