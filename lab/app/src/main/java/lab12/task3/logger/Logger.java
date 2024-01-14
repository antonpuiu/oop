package lab12.task3.logger;

import java.util.EnumSet;

public abstract class Logger {
    private EnumSet<LogLevel> activeLevels;
    private Logger next;

    public Logger(EnumSet<LogLevel> activeLevels) {
        this.activeLevels = activeLevels;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void message(String message, LogLevel severity) {
        if (activeLevels.contains(severity))
            writeMessage(message);

        if (next == null)
            return;

        next.message(message, severity);
    }

    protected abstract void writeMessage(String message);
}
