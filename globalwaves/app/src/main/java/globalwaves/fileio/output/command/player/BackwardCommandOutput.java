package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class BackwardCommandOutput extends CommandOutput {
    public BackwardCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Rewound successfully.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please select a source before rewinding.";
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
