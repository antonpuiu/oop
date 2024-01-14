package lab12.task3.logger;

import java.util.EnumSet;

public class FileLogger extends Logger {
    public FileLogger() {
        super(EnumSet.of(LogLevel.Warning, LogLevel.Error));
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[File] " + message);
    }
}
