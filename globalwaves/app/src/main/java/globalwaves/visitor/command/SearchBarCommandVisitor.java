package globalwaves.visitor.command;

import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.ResultsCommandOutput;

public interface SearchBarCommandVisitor {
    ResultsCommandOutput visit(SearchCommandInput command);

    CommandOutput visit(SelectCommandInput command);
}
