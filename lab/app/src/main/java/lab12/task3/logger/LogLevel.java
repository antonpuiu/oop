package lab12.task3.logger;

import java.util.EnumSet;

public enum LogLevel {
    Info, Debug, Warning, Error, FunctionalMessage, FunctionalError;

    public static EnumSet<LogLevel> all() {
        return EnumSet.allOf(LogLevel.class);
    }
}
