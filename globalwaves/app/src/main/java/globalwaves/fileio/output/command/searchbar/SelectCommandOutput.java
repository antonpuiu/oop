package globalwaves.fileio.output.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class SelectCommandOutput extends CommandOutput {
    private String message;

    public SelectCommandOutput(CommandInput inputCommand, Result result, String arg) {
        super(inputCommand);

        this.message = result.getResult(arg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Successfully selected " + arg + ".";
            }
        },

        NO_SEARCH {
            @Override
            public String getResult(String arg) {
                return "Please conduct a search before making a selection.";
            }
        },

        OUT_OF_BOUNDS {
            @Override
            public String getResult(String arg) {
                return "The selected ID is too high.";
            }
        }
    }
}
