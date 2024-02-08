package globalwaves.player.components;

import java.util.List;
import java.util.Map;

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
import globalwaves.fileio.input.library.EpisodeInput;
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.fileio.input.library.SongInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.player.AddRemoveInPlaylistCommandOutput;
import globalwaves.fileio.output.command.player.LoadCommandOutput;
import globalwaves.fileio.output.command.player.PlayPauseCommandOutput;
import globalwaves.fileio.output.command.player.StatusCommandOutput;
import globalwaves.player.user.PlayerState;
import globalwaves.player.user.SourceType;
import globalwaves.player.user.UserData;
import globalwaves.player.user.UserState;
import globalwaves.visitor.command.PlayerCommandVisitor;

public class PlayerComponent implements PlayerCommandVisitor {
    private Map<String, UserData> users;

    public PlayerComponent(Map<String, UserData> users) {
        this.users = users;
    }

    private void updatePlayerState(LoadCommandInput command, UserData currentUserData, SourceType sourceType) {
        PlayerState<?> playerState = currentUserData.getPlayerState();
        SongInput songNowPlaying = null;
        PodcastInput podcastNowPlaying = null;
        EpisodeInput episodeNowPlaying = null;
        Playlist playlistNowPlaying = null;

        playerState.setPaused(false);
        playerState.setStartTimestamp(command.getTimestamp());

        switch (sourceType) {
            case LIBRARY:
                songNowPlaying = (SongInput) playerState.getNowPlaying();
                playerState.setRemainedTime(songNowPlaying.getDuration());
                break;
            case PLAYLIST:
                playlistNowPlaying = (Playlist) playerState.getNowPlaying();
                songNowPlaying = playlistNowPlaying.getSong(playlistNowPlaying.getCurrentAudioFile());
                playerState.setRemainedTime(songNowPlaying.getDuration());
                break;
            case PODCAST:
                podcastNowPlaying = (PodcastInput) playerState.getNowPlaying();
                episodeNowPlaying = podcastNowPlaying.getEpisodes().get(podcastNowPlaying.getCurrentAudioFile());
                playerState.setRemainedTime(episodeNowPlaying.getDuration());
                break;
            case UNKNOWN:
                throw new RuntimeException("[Load Command] BUG: SourceType should not be UNKNOWN at this point.");
        }

        currentUserData.setState(UserState.AUDIOFILE_LOADED);
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        UserData currentUserData = users.get(command.getUsername());

        UserState userState = currentUserData.getState();
        SourceType sourceType = currentUserData.getSourceType();

        if (!userState.equals(UserState.AUDIOFILE_SELECTED)) {
            return new LoadCommandOutput(command, LoadCommandOutput.Result.NO_SOURCE);
        }

        switch (sourceType) {
            case PLAYLIST:
                Playlist playlist = (Playlist) currentUserData.getNowPlaying();

                if (playlist.getSize() == 0) {
                    return new LoadCommandOutput(command, LoadCommandOutput.Result.EMPTY_COLLECTION);
                }

                break;
            case PODCAST:
                PodcastInput podcastInput = (PodcastInput) currentUserData.getNowPlaying();

                if (podcastInput.getSize() == 0) {
                    return new LoadCommandOutput(command, LoadCommandOutput.Result.EMPTY_COLLECTION);
                }
                break;
            default:
                break;
        }

        updatePlayerState(command, currentUserData, sourceType);

        return new LoadCommandOutput(command, LoadCommandOutput.Result.SUCCESS);
    }

    @Override
    public CommandOutput visit(PlayPauseCommandInput command) {
        UserData currentUserData = users.get(command.getUsername());
        UserState userState = currentUserData.getState();
        PlayerState<?> playerState = currentUserData.getPlayerState();
        boolean paused = false;
        PlayPauseCommandOutput.Result result;

        if (!userState.equals(UserState.AUDIOFILE_LOADED)) {
            return new PlayPauseCommandOutput(command, PlayPauseCommandOutput.Result.NO_SOURCE);
        }

        paused = playerState.playPause(command.getTimestamp());

        if (paused) {
            result = PlayPauseCommandOutput.Result.PAUSE;
        } else {
            result = PlayPauseCommandOutput.Result.RESUME;
        }

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
        UserData currentUserData = users.get(command.getUsername());
        int playlistId = command.getPlaylistId() - 1;

        List<Playlist> userPlaylists = currentUserData.getPlaylists();
        UserState userState = currentUserData.getState();
        SourceType sourceType = currentUserData.getSourceType();

        if (!userState.equals(UserState.AUDIOFILE_LOADED)) {
            return new AddRemoveInPlaylistCommandOutput(command,
                    AddRemoveInPlaylistCommandOutput.Result.NO_SOURCE);
        }

        if (!sourceType.equals(SourceType.LIBRARY)) {
            return new AddRemoveInPlaylistCommandOutput(command,
                    AddRemoveInPlaylistCommandOutput.Result.SOURCE_NO_SONG);
        }

        if (playlistId >= userPlaylists.size()) {
            return new AddRemoveInPlaylistCommandOutput(command,
                    AddRemoveInPlaylistCommandOutput.Result.NO_PLAYLIST);
        }

        Playlist currentPlaylist = userPlaylists.get(playlistId);
        SongInput currentSong = (SongInput) currentUserData.getNowPlaying();

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
        UserData currentUserData = users.get(command.getUsername());

        return new StatusCommandOutput(command,
                currentUserData.getPlayerState().getMusicPlayerState(command.getTimestamp()));
    }
}
