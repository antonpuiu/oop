package globalwaves.fileio.output.command.searchbar;

import java.util.ArrayList;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public class SearchCommandOutput extends CommandOutput {
    private String message;
    private ArrayList<String> results;

    public SearchCommandOutput(CommandInput inputCommand, String message) {
        this(inputCommand, message, new ArrayList<String>());
    }

    public SearchCommandOutput(CommandInput inputCommand, String message, ArrayList<String> results) {
        super(inputCommand);

        this.message = message;
        this.results = results;
    }

    public SearchCommandOutput(String command, String user, int timestamp, String message) {
        super(command, user, timestamp);

        this.message = message;
    }

    public SearchCommandOutput(String command, String user, int timestamp, String message, ArrayList<String> results) {
        super(command, user, timestamp);

        this.message = message;
        this.results = results;
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
