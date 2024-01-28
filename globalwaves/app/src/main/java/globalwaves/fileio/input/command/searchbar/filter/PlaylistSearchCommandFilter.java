package globalwaves.fileio.input.command.searchbar.filter;

import globalwaves.visitor.filter.FilterVisitor;

public final class PlaylistSearchCommandFilter extends SearchCommandFilter {
    private String owner;

    public PlaylistSearchCommandFilter() {
        this(null, null);
    }

    public PlaylistSearchCommandFilter(final String owner) {
        this(null, owner);
    }

    public PlaylistSearchCommandFilter(final String name, final String owner) {
        super(name);

        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return super.toString() + "PlaylistSearchCommandFilter [owner=" + owner + "]";
    }
}
