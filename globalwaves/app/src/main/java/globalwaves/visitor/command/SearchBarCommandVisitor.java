package globalwaves.visitor.command;

import globalwaves.fileio.input.command.searchbar.PlaylistSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.PodcastSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.input.command.searchbar.SongSearchCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface SearchBarCommandVisitor {
    CommandOutput visit(SongSearchCommandInput command);

    CommandOutput visit(PodcastSearchCommandInput command);

    CommandOutput visit(PlaylistSearchCommandInput command);

    CommandOutput visit(SearchCommandInput command);

    CommandOutput visit(SelectCommandInput command);
}
