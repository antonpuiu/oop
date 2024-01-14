package lab12.task3.logger;

public class ConsoleLogger extends Logger {
    public ConsoleLogger() {
        super(LogLevel.all());
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Console] " + message);
    }
}
