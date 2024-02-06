package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandResult;

public class LoadCommandOutput extends PlayerCommandOutput {
    public LoadCommandOutput(CommandInput inputCommand, Result result) {
        super(inputCommand, result.getResult(null));
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Playback loaded successfully.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please select a source before attempting to load.";
            }
        },

        EMPTY_COLLECTION {
            @Override
            public String getResult(String arg) {
                return "You can't load an empty audio collection!";
            }
        }
    }
}
