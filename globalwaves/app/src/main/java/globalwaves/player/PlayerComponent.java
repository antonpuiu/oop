package globalwaves.player;

import java.util.Map;

import globalwaves.fileio.input.command.player.AddRemoveInPlaylistCommandInput;
import globalwaves.fileio.input.command.player.BackwardCommandInput;
import globalwaves.fileio.input.command.player.ForwardCommandInput;
import globalwaves.fileio.input.command.player.LikeCommandInput;
import globalwaves.fileio.input.command.player.LoadCommandInput;
import globalwaves.fileio.input.command.player.NextCommandInput;
import globalwaves.fileio.input.command.player.PlayPauseCommandInput;
import globalwaves.fileio.input.command.player.PrevCommandInput;
import globalwaves.fileio.input.command.player.RepeatCommandInput;
import globalwaves.fileio.input.command.player.ShuffleCommandInput;
import globalwaves.fileio.input.command.player.StatusCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.PlayerCommandVisitor;

public class PlayerComponent implements PlayerCommandVisitor {
    private Map<String, User> users;

    public PlayerComponent(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        if (!users.containsKey(command.getUsername()) || command.getUsername() == null) {
            return new CommandOutput(command, "User not found");
        }

        try {
            User currentUser = users.get(command.getUsername());

            currentUser.loadCurrentSong(command.getTimestamp());
        } catch (RuntimeException e) {
            return new CommandOutput(command, e.getMessage());
        }

        return new CommandOutput(command, "Playback loaded successfully.");
    }

    @Override
    public CommandOutput visit(PlayPauseCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(RepeatCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ShuffleCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ForwardCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(BackwardCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(LikeCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(NextCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(PrevCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(AddRemoveInPlaylistCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(StatusCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }
}
