package globalwaves.fileio.output.command.playlist;

import java.util.List;

import globalwaves.entity.PlaylistOutput;
import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public class ShowPlaylistsCommandOutput extends CommandOutput {
    private List<PlaylistOutput> result;

    public ShowPlaylistsCommandOutput(CommandInput inputCommand, List<PlaylistOutput> result) {
        super(inputCommand);

        this.result = result;
    }

    public List<PlaylistOutput> getResult() {
        return result;
    }
}
