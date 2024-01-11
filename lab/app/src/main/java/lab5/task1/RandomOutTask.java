package lab5.task1;

public class RandomOutTask implements Task {
    @Override
    public void execute() {
        System.out.println("Random number: " + Main.generator.nextInt());
    }
}
