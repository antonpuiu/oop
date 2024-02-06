package globalwaves.fileio.output.command;

import globalwaves.fileio.input.command.CommandInput;

public abstract class CommandOutput {
    private String command;
    private String user;
    private int timestamp;

    public CommandOutput(CommandInput inputCommand) {
        command = inputCommand.getCommand();
        user = inputCommand.getUsername();
        timestamp = inputCommand.getTimestamp();
    }

    public CommandOutput(String command, String user, int timestamp) {
        this.command = command;
        this.user = user;
        this.timestamp = timestamp;
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
}
