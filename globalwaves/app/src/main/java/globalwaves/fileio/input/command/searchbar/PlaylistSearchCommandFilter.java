package globalwaves.fileio.input.command.searchbar;

public class PlaylistSearchCommandFilter extends SearchCommandFilter {
    private String owner;

    public PlaylistSearchCommandFilter() {
        this(null, null);
    }

    public PlaylistSearchCommandFilter(String owner) {
        this(null, owner);
    }

    public PlaylistSearchCommandFilter(String name, String owner) {
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
