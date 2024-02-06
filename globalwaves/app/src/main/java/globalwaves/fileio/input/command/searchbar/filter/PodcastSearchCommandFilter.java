package globalwaves.fileio.input.command.searchbar.filter;

public final class PodcastSearchCommandFilter {
    private String name;
    private String owner;

    public PodcastSearchCommandFilter(SearchCommandFilter filter) {
        name = filter.getName();
        owner = filter.getOwner();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
