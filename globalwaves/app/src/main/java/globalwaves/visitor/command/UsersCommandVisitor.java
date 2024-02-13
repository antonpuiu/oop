package globalwaves.visitor.command;

import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface UsersCommandVisitor {
    CommandOutput visit(ShowPreferredSongsCommandInput command);
}
