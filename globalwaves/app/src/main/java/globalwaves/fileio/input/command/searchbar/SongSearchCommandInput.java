package globalwaves.fileio.input.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.input.command.searchbar.filter.SongSearchCommandFilter;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public class SongSearchCommandInput extends CommandInput {
    private String type;
    private SongSearchCommandFilter songFilter;

    public SongSearchCommandInput(SearchCommandInput input) {
        super(input);

        type = input.getType();
        songFilter = new SongSearchCommandFilter(input.getFilters());
    }

    public SongSearchCommandFilter getSongFilter() {
        return songFilter;
    }

    public void setSongFilter(SongSearchCommandFilter songFilter) {
        this.songFilter = songFilter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public CommandOutput accept(CommandVisitor visitor) {
        return visitor.visit(this);
    }
}
