package utils;

public abstract class Runner implements MainTask {
    @Override
    public void main() {
        MainTask[] tasks = getTasks();

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getId() == 0)
                System.out.printf("Executing %s...\n", tasks[i].getUnit(), tasks[i].getId());
            else
                System.out.printf("Executing %s %d...\n", tasks[i].getUnit(), tasks[i].getId());

            tasks[i].main();
            System.out.println();
        }
    }

    public abstract MainTask[] getTasks();
}
