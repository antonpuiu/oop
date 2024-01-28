package globalwaves.visitor;

import globalwaves.fileio.input.command.general.GetTop5PlaylistsCommandInput;
import globalwaves.fileio.input.command.general.GetTop5SongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface GeneralCommandVisitor {
    public CommandOutput visit(GetTop5SongsCommandInput command);

    public CommandOutput visit(GetTop5PlaylistsCommandInput command);
}
