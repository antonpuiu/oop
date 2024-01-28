package globalwaves.fileio.input.command.searchbar;

public class SearchCommandFilter {
    private String name;

    public SearchCommandFilter() {
        this(null);
    }

    public SearchCommandFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
