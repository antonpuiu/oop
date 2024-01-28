package globalwaves.visitor;

import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface PlaylistCommandVisitor {
    public CommandOutput visit(CreatePlaylistCommandInput command);

    public CommandOutput visit(SwitchVisibilityCommandInput command);

    public CommandOutput visit(FollowPlaylistCommandInput command);

    public CommandOutput visit(ShowPlaylistsCommandInput command);
}
