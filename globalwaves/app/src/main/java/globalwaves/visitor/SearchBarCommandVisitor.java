package globalwaves.visitor;

import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface SearchBarCommandVisitor {
    public CommandOutput visit(SearchCommandInput command);

    public CommandOutput visit(SelectCommandInput command);
}
