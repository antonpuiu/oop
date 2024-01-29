package globalwaves.player.components;

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
import globalwaves.fileio.output.command.player.PlayerCommandOutput;
import globalwaves.fileio.output.command.player.StatusCommandOutput;
import globalwaves.player.MusicPlayerState;
import globalwaves.player.User;
import globalwaves.visitor.command.PlayerCommandVisitor;

public class PlayerComponent implements PlayerCommandVisitor {
    private Map<String, User> users;

    public PlayerComponent(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        if (!users.containsKey(command.getUsername()) || command.getUsername() == null) {
            return new PlayerCommandOutput(command, "User not found");
        }

        try {
            User currentUser = users.get(command.getUsername());

            currentUser.loadCurrentSong(command.getTimestamp());
        } catch (RuntimeException e) {
            return new PlayerCommandOutput(command, e.getMessage());
        }

        return new PlayerCommandOutput(command, "Playback loaded successfully.");
    }

    @Override
    public CommandOutput visit(PlayPauseCommandInput command) {
        if (!users.containsKey(command.getUsername()) || command.getUsername() == null) {
            return new PlayerCommandOutput(command, "User not found");
        }

        try {
            User currentUser = users.get(command.getUsername());

            if (currentUser.playPause(command.getTimestamp())) {
                return new PlayerCommandOutput(command, "Playback resumed successfully.");
            } else {
                return new PlayerCommandOutput(command, "Playback paused successfully.");
            }
        } catch (RuntimeException e) {
            return new PlayerCommandOutput(command, e.getMessage());
        }
    }

    @Override
    public CommandOutput visit(RepeatCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(ShuffleCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(ForwardCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(BackwardCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(LikeCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(NextCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(PrevCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(AddRemoveInPlaylistCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(StatusCommandInput command) {
        if (!users.containsKey(command.getUsername()) || command.getUsername() == null) {
            return new PlayerCommandOutput(command, "User not found");
        }

        User currentUser = users.get(command.getUsername());

        return new StatusCommandOutput(command, currentUser.getMusicPlayerState(command.getTimestamp()));
    }
}
