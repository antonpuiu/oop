package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandResult;

public class PlayPauseCommandOutput extends PlayerCommandOutput {
    public PlayPauseCommandOutput(CommandInput inputCommand, Result result) {
        super(inputCommand, result.getResult(null));
    }

    public enum Result implements CommandResult {
        PAUSE {
            @Override
            public String getResult(String arg) {
                return "Playback paused successfully.";
            }
        },

        RESUME {
            @Override
            public String getResult(String arg) {
                return "Playback resumed successfully.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please load a source before attempting to pause or resume playback.";
            }
        }
    }
}
