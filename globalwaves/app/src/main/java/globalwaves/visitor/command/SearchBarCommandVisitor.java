package globalwaves.visitor.command;

import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface SearchBarCommandVisitor {
    CommandOutput visit(SearchCommandInput command);

    CommandOutput visit(SelectCommandInput command);
}
