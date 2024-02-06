package globalwaves.fileio.output.command.playlist;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class FollowPlaylistCommandOutput extends CommandOutput {
    public FollowPlaylistCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        FOLLOW {
            @Override
            public String getResult(String arg) {
                return "Playlist followed successfully.";
            }
        },

        UNFOLLOW {
            @Override
            public String getResult(String arg) {
                return "Playlist unfollowed successfully.";
            }
        },

        SOURCE_NO_PLAYLIST {
            @Override
            public String getResult(String arg) {
                return "The selected source is not a playlist.";
            }
        },

        NO_SOURCE {
            @Override
            public String getResult(String arg) {
                return "Please select a source before following or unfollowing.";
            }
        },

        OWNERSHIP {
            @Override
            public String getResult(String arg) {
                return "You cannot follow or unfollow your own playlist.";
            }
        }
    }
}
