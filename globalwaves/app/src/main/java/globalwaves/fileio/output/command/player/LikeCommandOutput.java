package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class LikeCommandOutput extends CommandOutput {
    public LikeCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        LIKE {
            @Override
            public String getResult(String arg) {
                return "Like registered successfully.";
            }
        },

        UNLIKE {
            @Override
            public String getResult(String arg) {
                return "Unlike registered successfully.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please load a source before liking or unliking.";
            }
        },

        SOURCE_NO_SONG {
            @Override
            public String getResult(String arg) {
                return "Loaded source is not a song.";
            }
        }
    }
}
