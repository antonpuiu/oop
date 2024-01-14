package lab11;

import utils.*;

public class Main extends LabUnitTask {
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab11.kotlin.Main(),
            new lab11.entities.Main()
        };

        return tasks;
    }

    @Override
    public int getId() {
        return 11;
    }
}
