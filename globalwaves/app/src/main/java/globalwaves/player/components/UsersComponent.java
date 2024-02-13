package globalwaves.player.components;

import java.util.List;
import java.util.Map;

import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.users.ShowPreferredSongsCommandOutput;
import globalwaves.player.user.UserData;
import globalwaves.visitor.command.UsersCommandVisitor;

public class UsersComponent extends DefaultComponent implements UsersCommandVisitor {
    public UsersComponent(Map<String, UserData> usersData) {
        super(usersData);
    }

    @Override
    public CommandOutput visit(ShowPreferredSongsCommandInput command) {
        UserData currentUserData = usersData.get(command.getUsername());
        List<String> result = currentUserData.getLikedSongs()
                .stream()
                .map(song -> (song.getName()))
                .toList();

        return new ShowPreferredSongsCommandOutput(command, result);
    }
}
