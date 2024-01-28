package globalwaves.fileio.input.command.searchbar;

public class PodcastSearchCommandFilter extends SearchCommandFilter {
    private String owner;

    public PodcastSearchCommandFilter() {
        this(null, null);
    }

    public PodcastSearchCommandFilter(String owner) {
        this.owner = owner;
    }

    public PodcastSearchCommandFilter(String name, String owner) {
        super(name);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
