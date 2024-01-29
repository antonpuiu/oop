package globalwaves.player.components;

import globalwaves.fileio.input.command.general.GetTop5PlaylistsCommandInput;
import globalwaves.fileio.input.command.general.GetTop5SongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.GeneralCommandVisitor;

public class GeneralComponent implements GeneralCommandVisitor {

    public GeneralComponent() {
    }

    @Override
    public CommandOutput visit(GetTop5SongsCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(GetTop5PlaylistsCommandInput command) {
        return null;
    }
}
