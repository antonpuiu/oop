package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public class PlayerCommandOutput extends CommandOutput {
    private String message;

    public PlayerCommandOutput(CommandInput inputCommand, String message) {
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
