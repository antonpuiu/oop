package globalwaves.fileio.output.command;

import globalwaves.fileio.input.command.CommandInput;

public class CommandOutput {
    private String command;
    private String user;
    private int timestamp;
    private String message;

    public CommandOutput(CommandInput inputCommand, String message) {
        command = inputCommand.getCommand();
        user = inputCommand.getUsername();
        timestamp = inputCommand.getTimestamp();

        this.message = message;
    }

    public CommandOutput(String command, String user, int timestamp, String message) {
        this.command = command;
        this.user = user;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
