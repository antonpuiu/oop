package globalwaves.fileio.input.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.input.command.searchbar.filter.PlaylistSearchCommandFilter;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public class PlaylistSearchCommandInput extends CommandInput {
    private String type;
    private PlaylistSearchCommandFilter playlistFilter;

    public PlaylistSearchCommandInput(SearchCommandInput input) {
        super(input);

        type = input.getType();
        playlistFilter = new PlaylistSearchCommandFilter(input.getFilters());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PlaylistSearchCommandFilter getPlaylistFilter() {
        return playlistFilter;
    }

    public void setPlaylistFilter(PlaylistSearchCommandFilter playlistFilter) {
        this.playlistFilter = playlistFilter;
    }

    @Override
    public CommandOutput accept(CommandVisitor visitor) {
        return visitor.visit(this);
    }
}
