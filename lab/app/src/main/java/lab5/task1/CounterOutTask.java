package lab5.task1;

public class CounterOutTask implements Task {
    @Override
    public void execute() {
        System.out.println("Counter value: " + ++Main.counter);
    }
}
