package globalwaves.fileio.input.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.input.command.searchbar.filter.PodcastSearchCommandFilter;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public class PodcastSearchCommandInput extends CommandInput {
    private String type;
    private PodcastSearchCommandFilter podcastFilter;

    public PodcastSearchCommandInput(SearchCommandInput input) {
        super(input);

        type = input.getType();
        podcastFilter = new PodcastSearchCommandFilter(input.getFilters());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PodcastSearchCommandFilter getPodcastFilter() {
        return podcastFilter;
    }

    public void setPodcastFilter(PodcastSearchCommandFilter podcastFilter) {
        this.podcastFilter = podcastFilter;
    }

    @Override
    public CommandOutput accept(CommandVisitor visitor) {
        return visitor.visit(this);
    }
}
