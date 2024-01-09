package lab1;

import lab1.task1.VeterinaryTest;
import lab1.task3.EqualsCheck;

import utils.*;

public class Main extends Runner {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new VeterinaryTest(),
            new lab1.task2.JobMarket(),
            new EqualsCheck(),
            new lab1.task4.JobMarket()
        };

        return tasks;
    }

    @Override
    public String getUnit() {
        return "task";
    }

    @Override
    public int getId() {
        return 1;
    }
}
