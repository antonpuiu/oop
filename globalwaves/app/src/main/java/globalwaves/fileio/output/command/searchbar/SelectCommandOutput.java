package globalwaves.fileio.output.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public class SelectCommandOutput extends CommandOutput {
    private String message;

    public SelectCommandOutput(CommandInput inputCommand, String message) {
        super(inputCommand);

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
