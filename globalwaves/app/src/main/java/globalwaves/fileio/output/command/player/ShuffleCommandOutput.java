package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class ShuffleCommandOutput extends CommandOutput {
    public ShuffleCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        ACTIVE {
            @Override
            public String getResult(String arg) {
                return "Shuffle function activated successfully.";
            }
        },

        INACTIVE {
            @Override
            public String getResult(String arg) {
                return "Shuffle function deactivated successfully.";
            }
        },

        SOURCE_NO_PLAYLIST {
            @Override
            public String getResult(String arg) {
                return "The loaded source is not a playlist.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please load a source before using the shuffle function.";
            }
        }
    }
}
