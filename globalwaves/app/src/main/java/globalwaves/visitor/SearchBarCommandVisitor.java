package globalwaves.visitor;

import globalwaves.fileio.input.command.searchbar.PlaylistSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.PodcastSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.input.command.searchbar.SongSearchCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface SearchBarCommandVisitor {
    public CommandOutput visit(SongSearchCommandInput command);

    public CommandOutput visit(PodcastSearchCommandInput command);

    public CommandOutput visit(PlaylistSearchCommandInput command);

    public CommandOutput visit(SelectCommandInput command);
}
