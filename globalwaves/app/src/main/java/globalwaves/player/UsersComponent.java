package globalwaves.player;

import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.UsersCommandVisitor;

public class UsersComponent implements UsersCommandVisitor {

    public UsersComponent() {
    }

    @Override
    public CommandOutput visit(ShowPreferredSongsCommandInput visitor) {
        // TODO Auto-generated method stub
        return null;
    }
}
