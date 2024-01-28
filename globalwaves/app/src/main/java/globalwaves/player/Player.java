package globalwaves.player;

import globalwaves.fileio.input.command.general.GetTop5PlaylistsCommandInput;
import globalwaves.fileio.input.command.general.GetTop5SongsCommandInput;
import globalwaves.fileio.input.command.player.AddRemoveInPlaylistCommandInput;
import globalwaves.fileio.input.command.player.BackwardCommandInput;
import globalwaves.fileio.input.command.player.ForwardCommandInput;
import globalwaves.fileio.input.command.player.LikeCommandInput;
import globalwaves.fileio.input.command.player.LoadCommandInput;
import globalwaves.fileio.input.command.player.NextCommandInput;
import globalwaves.fileio.input.command.player.PlayPauseCommandInput;
import globalwaves.fileio.input.command.player.PrevCommandInput;
import globalwaves.fileio.input.command.player.RepeatCommandInput;
import globalwaves.fileio.input.command.player.ShuffleCommandInput;
import globalwaves.fileio.input.command.player.StatusCommandInput;
import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.input.library.LibraryInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.CommandVisitor;

public class Player implements CommandVisitor {
    public void loadLibrary(LibraryInput libraryInput) {
    }

    @Override
    public CommandOutput visit(SearchCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(SelectCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(PlayPauseCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(RepeatCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ShuffleCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ForwardCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(BackwardCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(LikeCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(NextCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(PrevCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(AddRemoveInPlaylistCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(StatusCommandInput command) {
        // TODO Auto-generated method stub
        return null;
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

    @Override
    public CommandOutput visit(ShowPreferredSongsCommandInput visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(GetTop5SongsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(GetTop5PlaylistsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }
}
