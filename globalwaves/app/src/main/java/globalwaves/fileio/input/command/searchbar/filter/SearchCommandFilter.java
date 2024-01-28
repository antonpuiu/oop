package globalwaves.fileio.input.command.searchbar.filter;

public class SearchCommandFilter {
    private String name;

    public SearchCommandFilter() {
        this(null);
    }

    public SearchCommandFilter(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SearchCommandFilter [name=" + name + "]";
    }
}
