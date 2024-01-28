package globalwaves.fileio.output.command;

import java.util.ArrayList;

import globalwaves.fileio.input.command.CommandInput;

public class CommandOutput {
    private String command;
    private String user;
    private int timestamp;
    private String message;
    private ArrayList<String> results;

    public CommandOutput(CommandInput inputCommand, String message) {
        this(inputCommand, message, null);
    }

    public CommandOutput(CommandInput inputCommand, String message, ArrayList<String> results) {
        command = inputCommand.getCommand();
        user = inputCommand.getUsername();
        timestamp = inputCommand.getTimestamp();

        this.message = message;
        this.results = results;
    }

    public CommandOutput(String command, String user, int timestamp, String message) {
        this.command = command;
        this.user = user;
        this.timestamp = timestamp;
        this.message = message;
    }

    public CommandOutput(ArrayList<String> results, String command, String user, int timestamp, String message) {
        this.results = results;
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

    public ArrayList<String> getResults() {
        return results;
    }

    public void setResults(ArrayList<String> results) {
        this.results = results;
    }
}
