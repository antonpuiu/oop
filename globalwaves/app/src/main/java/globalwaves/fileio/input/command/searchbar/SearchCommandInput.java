package globalwaves.fileio.input.command.searchbar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.CommandVisitor;

@JsonDeserialize(using = SearchCommandInputDeserializer.class)
public class SearchCommandInput extends CommandInput {
    private String type;
    private SearchCommandFilter filters;

    public SearchCommandInput() {
        this(null, null);
    }

    public SearchCommandInput(String type, SearchCommandFilter filters) {
        this.type = type;
        this.filters = filters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
        return null;
    }
}
