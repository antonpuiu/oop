package lab4;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab4.task1.Main(),
            new lab4.task2.Main(),
            new lab4.task3.Main(),
            new lab4.task4.Main(),
            new lab4.task5.Main(),
            new lab4.task6.Main(),
            new lab4.task7.Main(),
            new lab4.task8.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 4;
    }
}
