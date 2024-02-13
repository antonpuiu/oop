package globalwaves.player.components;

import java.util.Map;

import globalwaves.fileio.input.command.general.GetTop5PlaylistsCommandInput;
import globalwaves.fileio.input.command.general.GetTop5SongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.player.user.UserData;
import globalwaves.visitor.command.GeneralCommandVisitor;

public class GeneralComponent extends DefaultComponent implements GeneralCommandVisitor {
    public GeneralComponent(Map<String, UserData> users) {
        super(users);
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
