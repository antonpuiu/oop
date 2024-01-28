package globalwaves.player;

import globalwaves.fileio.input.command.searchbar.PlaylistSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.PodcastSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.input.command.searchbar.SongSearchCommandInput;
import globalwaves.fileio.input.library.LibraryInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.CommandVisitor;

public class Player implements CommandVisitor {
    public void loadLibrary(LibraryInput libraryInput) {
    }

    @Override
    public CommandOutput visit(SongSearchCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(PodcastSearchCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(PlaylistSearchCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(SelectCommandInput command) {
        return null;
    }
}
