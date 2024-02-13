package globalwaves.fileio.input.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.input.command.searchbar.filter.SearchCommandFilter;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public class SearchCommandInput extends CommandInput {
    private String type;
    private SearchCommandFilter filters;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public SearchCommandFilter getFilters() {
        return filters;
    }

    public void setFilters(SearchCommandFilter filters) {
        this.filters = filters;
    }

    @Override
    public CommandOutput accept(CommandVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return super.toString() + " SearchCommandInput [type=" + type + ", filters=" + filters + "]";
    }

}
