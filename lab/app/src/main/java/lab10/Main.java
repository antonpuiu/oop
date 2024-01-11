package lab10;

import utils.*;

public class Main extends Runner
{
    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
        };

        return tasks;
    }

    @Override
    public String getUnit() {
        return "task";
    }

    @Override
    public int getId() {
        return 10;
    }
}
