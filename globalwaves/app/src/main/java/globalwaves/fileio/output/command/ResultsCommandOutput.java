package globalwaves.fileio.output.command;

import java.util.ArrayList;

import globalwaves.fileio.input.command.CommandInput;

public class ResultsCommandOutput extends CommandOutput {
    private ArrayList<String> results;

    public ResultsCommandOutput(CommandInput inputCommand, String message) {
        this(inputCommand, message, new ArrayList<String>());
    }

    public ResultsCommandOutput(CommandInput inputCommand, String message, ArrayList<String> results) {
        super(inputCommand, message);

        this.results = results;
    }

    public ResultsCommandOutput(String command, String user, int timestamp, String message) {
        super(command, user, timestamp, message);
    }

    public ResultsCommandOutput(String command, String user, int timestamp, String message, ArrayList<String> results) {
        super(command, user, timestamp, message);

        this.results = results;
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public void setResults(ArrayList<String> results) {
        this.results = results;
    }
}
