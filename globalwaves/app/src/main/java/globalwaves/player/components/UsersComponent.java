package globalwaves.player.components;

import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.UsersCommandVisitor;

public class UsersComponent implements UsersCommandVisitor {

    public UsersComponent() {
    }

    @Override
    public CommandOutput visit(ShowPreferredSongsCommandInput visitor) {
        return null;
    }
}
