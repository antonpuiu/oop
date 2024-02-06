package globalwaves.fileio.output.command.playlist;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class SwitchVisibilityCommandOutput extends CommandOutput {
    public SwitchVisibilityCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Visibility status updated successfully to " + arg + ".";
            }
        },

        OUT_OF_BOUNDS {
            @Override
            public String getResult(String arg) {
                return "The specified playlist ID is too high.";
            }
        }
    }
}
