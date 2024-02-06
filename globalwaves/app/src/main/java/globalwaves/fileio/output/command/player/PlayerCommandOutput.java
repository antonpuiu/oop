package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public abstract class PlayerCommandOutput extends CommandOutput {
    private String message;

    protected PlayerCommandOutput(CommandInput inputCommand, String message) {
        super(inputCommand);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
