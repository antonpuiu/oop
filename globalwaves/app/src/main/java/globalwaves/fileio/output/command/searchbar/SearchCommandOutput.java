package globalwaves.fileio.output.command.searchbar;

import java.util.List;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class SearchCommandOutput extends CommandOutput {
    private String message;
    private List<String> results;

    public SearchCommandOutput(CommandInput inputCommand,
            CommandResult result,
            String arg,
            List<String> results) {
        super(inputCommand);

        this.message = result.getResult(arg);
        this.results = results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public enum Result implements CommandResult {
        DEFAULT {
            @Override
            public String getResult(String arg) {
                return "Search returned " + arg + " results";
            }
        };
    }
}
