package globalwaves.visitor;

import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface UsersCommandVisitor {
    public CommandOutput visit(ShowPreferredSongsCommandInput visitor);
}
