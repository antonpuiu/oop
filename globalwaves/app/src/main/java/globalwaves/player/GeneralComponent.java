package globalwaves.player;

import globalwaves.fileio.input.command.general.GetTop5PlaylistsCommandInput;
import globalwaves.fileio.input.command.general.GetTop5SongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.GeneralCommandVisitor;

public class GeneralComponent implements GeneralCommandVisitor {

    public GeneralComponent() {
    }

    @Override
    public CommandOutput visit(GetTop5SongsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(GetTop5PlaylistsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }
}
