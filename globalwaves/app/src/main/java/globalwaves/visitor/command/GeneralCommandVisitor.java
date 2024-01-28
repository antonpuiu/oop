package globalwaves.visitor.command;

import globalwaves.fileio.input.command.general.GetTop5PlaylistsCommandInput;
import globalwaves.fileio.input.command.general.GetTop5SongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface GeneralCommandVisitor {
    CommandOutput visit(GetTop5SongsCommandInput command);

    CommandOutput visit(GetTop5PlaylistsCommandInput command);
}
