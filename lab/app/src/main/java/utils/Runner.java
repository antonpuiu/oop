package utils;

public abstract class Runner implements MainTask {
    @Override
    public void main() {
        MainTask[] tasks = getTasks();

        for (int i = 0; i < tasks.length; i++) {
            System.out.printf("Executing %s %d...\n", getUnit(), tasks[i].getId());
            tasks[i].main();
            System.out.println();
        }
    }

    public abstract MainTask[] getTasks();
    public abstract String getUnit();
}
