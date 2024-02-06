package globalwaves.fileio.output.command.playlist;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public class ModifyPlaylistCommandOutput extends CommandOutput {
    private String message;

    protected ModifyPlaylistCommandOutput(CommandInput inputCommand, String message) {
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
