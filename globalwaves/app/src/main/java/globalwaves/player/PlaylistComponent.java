package globalwaves.player;

import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.PlaylistCommandVisitor;

public class PlaylistComponent implements PlaylistCommandVisitor {

    public PlaylistComponent() {
    }

    @Override
    public CommandOutput visit(CreatePlaylistCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(SwitchVisibilityCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(FollowPlaylistCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ShowPlaylistsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }
}
