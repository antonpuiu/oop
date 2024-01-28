package globalwaves.fileio.input.command.searchbar.filter;

public final class PodcastSearchCommandFilter extends SearchCommandFilter {
    private String owner;

    public PodcastSearchCommandFilter() {
        this(null, null);
    }

    public PodcastSearchCommandFilter(final String owner) {
        this.owner = owner;
    }

    public PodcastSearchCommandFilter(final String name, final String owner) {
        super(name);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return super.toString() + "PodcastSearchCommandFilter [owner=" + owner + "]";
    }
}
