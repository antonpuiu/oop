package globalwaves.player.components;

import java.util.ArrayList;
import java.util.Map;

import globalwaves.entity.AudioFile;
import globalwaves.entity.Playlist;
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
import globalwaves.fileio.input.library.SongInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.player.AddRemoveInPlaylistCommandOutput;
import globalwaves.fileio.output.command.player.LoadCommandOutput;
import globalwaves.fileio.output.command.player.PlayPauseCommandOutput;
import globalwaves.fileio.output.command.player.StatusCommandOutput;
import globalwaves.player.User;
import globalwaves.visitor.command.PlayerCommandVisitor;

public class PlayerComponent implements PlayerCommandVisitor {
    private Map<String, User> users;

    public PlayerComponent(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        User currentUser = users.get(command.getUsername());
        LoadCommandOutput.Result result = currentUser.loadCurrentSong(command.getTimestamp());

        return new LoadCommandOutput(command, result);
    }

    @Override
    public CommandOutput visit(PlayPauseCommandInput command) {
        User currentUser = users.get(command.getUsername());
        PlayPauseCommandOutput.Result result = currentUser.playPause(command.getTimestamp());

        return new PlayPauseCommandOutput(command, result);
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
        User currentUser = users.get(command.getUsername());
        ArrayList<Playlist> userPlaylists = currentUser.getPlaylists();
        int playlistId = command.getPlaylistId() - 1;

        if (!currentUser.getState().equals(User.UserState.AUDIOFILE_LOADED)) {
            return new AddRemoveInPlaylistCommandOutput(command,
                    AddRemoveInPlaylistCommandOutput.Result.NO_SOURCE);
        }

        if (!currentUser.getCurrentAudioFile().isSong()) {
            return new AddRemoveInPlaylistCommandOutput(command,
                    AddRemoveInPlaylistCommandOutput.Result.SOURCE_NO_SONG);
        }

        if (playlistId >= userPlaylists.size()) {
            return new AddRemoveInPlaylistCommandOutput(command,
                    AddRemoveInPlaylistCommandOutput.Result.NO_PLAYLIST);
        }

        Playlist currentPlaylist = userPlaylists.get(playlistId);
        SongInput currentSong = (SongInput) currentUser.getCurrentAudioFile();

        if (currentPlaylist.containsSong(currentSong)) {
            currentPlaylist.removeSong(currentSong);
            return new AddRemoveInPlaylistCommandOutput(command,
                    AddRemoveInPlaylistCommandOutput.Result.REMOVE);
        }

        currentPlaylist.addSong(currentSong);
        return new AddRemoveInPlaylistCommandOutput(command,
                AddRemoveInPlaylistCommandOutput.Result.ADD);
    }

    @Override
    public CommandOutput visit(StatusCommandInput command) {
        User currentUser = users.get(command.getUsername());

        return new StatusCommandOutput(command, currentUser.getMusicPlayerState(command.getTimestamp()));
    }
}
