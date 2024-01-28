package globalwaves.visitor.command;

import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface PlaylistCommandVisitor {
    CommandOutput visit(CreatePlaylistCommandInput command);

    CommandOutput visit(SwitchVisibilityCommandInput command);

    CommandOutput visit(FollowPlaylistCommandInput command);

    CommandOutput visit(ShowPlaylistsCommandInput command);
}
