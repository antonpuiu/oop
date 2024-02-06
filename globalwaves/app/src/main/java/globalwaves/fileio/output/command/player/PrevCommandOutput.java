package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class PrevCommandOutput extends CommandOutput {
    public PrevCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Returned to previous track successfully. The current track is " + arg + ".";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please load a source before returning to the previous track.";
            }
        }
    }
}
