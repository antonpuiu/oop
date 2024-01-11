package lab5.task1;

import java.util.Random;

import utils.MainTask;

public class Main implements MainTask {
    public static Random generator = new Random(12345);
    public static int counter = 0;
    public static Task[] tasks = {
            new OutTask("First message task"),
            new RandomOutTask(),
            new CounterOutTask(),
            new OutTask("Second message task"),
            new CounterOutTask(),
            new RandomOutTask()
        };

    @Override
    public void main() {
        for (Task task : tasks)
            task.execute();
    }

    @Override
    public int getId() {
        return 1;
    }
}
