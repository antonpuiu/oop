package globalwaves.fileio.input.command.searchbar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.input.command.searchbar.filter.SearchCommandFilter;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

@JsonDeserialize(using = SearchCommandInputDeserializer.class)
public final class SearchCommandInput extends CommandInput {
    private String type;
    private SearchCommandFilter filters;

    public SearchCommandInput() {
        this(null, null, null);
    }

    public SearchCommandInput(final String type, final SearchCommandFilter filters) {
        this.type = type;
        this.filters = filters;
    }

    public SearchCommandInput(final String command,
            final String type,
            final SearchCommandFilter filters) {
        super(command);

        this.type = type;
        this.filters = filters;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public SearchCommandFilter getFilters() {
        return filters;
    }

    public void setFilters(final SearchCommandFilter filters) {
        this.filters = filters;
    }

    @Override
    public CommandOutput accept(final CommandVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return super.toString() + "SearchCommandInput [type=" + type + ", filters=" + filters + "]";
    }
}
