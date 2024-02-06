package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class RepeatCommandOutput extends CommandOutput {
    public RepeatCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Repeat mode changed to " + arg + ".";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please load a source before setting the repeat status.";
            }
        }
    }
}
