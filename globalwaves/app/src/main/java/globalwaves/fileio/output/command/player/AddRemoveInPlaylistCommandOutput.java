package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandResult;

public class AddRemoveInPlaylistCommandOutput extends PlayerCommandOutput {
    public AddRemoveInPlaylistCommandOutput(CommandInput inputCommand, Result result) {
        super(inputCommand, result.getResult(null));
    }

    public enum Result implements CommandResult {
        ADD {
            @Override
            public String getResult(String arg) {
                return "Successfully added to playlist.";
            }
        },

        REMOVE {
            @Override
            public String getResult(String arg) {
                return "Successfully removed from playlist.";
            }
        },

        SOURCE_NO_SONG {
            @Override
            public String getResult(String arg) {
                return "The loaded source is not a song.";
            }
        },

        NO_PLAYLIST {
            @Override
            public String getResult(String arg) {
                return "The specified playlist does not exist.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please load a source before adding to or removing from the playlist.";
            }
        },

        NULL_SONG {
            @Override
            public String getResult(String arg) {
                return "Null song";
            }
        }
    }
}
