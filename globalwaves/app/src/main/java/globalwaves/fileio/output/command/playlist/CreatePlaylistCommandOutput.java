package globalwaves.fileio.output.command.playlist;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandResult;

public class CreatePlaylistCommandOutput extends ModifyPlaylistCommandOutput {
    public CreatePlaylistCommandOutput(CommandInput inputCommand, Result result) {
        super(inputCommand, result.getResult(null));
    }

    public enum Result implements CommandResult {
        SUCCESS {
            @Override
            public String getResult(String arg) {
                return "Playlist created successfully.";
            }
        },

        ALREADY_EXISTS {
            @Override
            public String getResult(String arg) {
                return "A playlist with the same name already exists.";
            }
        }
    }
}
