package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class ForwardCommandOutput extends CommandOutput {
    public ForwardCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Skipped forward successfully.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please load a source before skipping forward.";
            }
        },

        SOURCE_NO_PODCAST {
            @Override
            public String getResult(String arg) {
                return "The loaded source is not a podcast.";
            }
        }
    }
}
