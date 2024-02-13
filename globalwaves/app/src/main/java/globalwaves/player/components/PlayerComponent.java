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
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.fileio.input.library.SongInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.player.AddRemoveInPlaylistCommandOutput;
import globalwaves.fileio.output.command.player.LikeCommandOutput;
import globalwaves.fileio.output.command.player.LoadCommandOutput;
import globalwaves.fileio.output.command.player.PlayPauseCommandOutput;
import globalwaves.fileio.output.command.player.RepeatCommandOutput;
import globalwaves.fileio.output.command.player.StatusCommandOutput;
import globalwaves.player.user.PlayerState;
import globalwaves.player.user.RepeatState;
import globalwaves.player.user.SourceType;
import globalwaves.player.user.UserData;
import globalwaves.player.user.UserState;
import globalwaves.visitor.command.PlayerCommandVisitor;

public class PlayerComponent extends DefaultComponent implements PlayerCommandVisitor {
    public PlayerComponent(Map<String, UserData> usersData) {
        super(usersData);
    }

    private void updatePlayerState(LoadCommandInput command, UserData currentUserData, SourceType sourceType) {
        PlayerState<?> playerState = currentUserData.getPlayerState();
        PodcastInput podcastNowPlaying = null;
        Playlist playlistNowPlaying = null;

        switch (sourceType) {
            case LIBRARY:
                playerState.getNowPlaying().resetPlayback(command.getTimestamp());
                break;
            case PLAYLIST:
                playlistNowPlaying = (Playlist) playerState.getNowPlaying();
                playlistNowPlaying.resetCurrentAudioFile();

                for (int i = 0; i < playlistNowPlaying.getSize(); i++) {
                    playlistNowPlaying.getSong(i).stopPlayback();
                }

                playlistNowPlaying.startPlayback(command.getTimestamp());
                break;
            case PODCAST:
                podcastNowPlaying = (PodcastInput) playerState.getNowPlaying();
                podcastNowPlaying.startPlayback(command.getTimestamp());
                break;
            case UNKNOWN:
                throw new RuntimeException("[Load Command] BUG: SourceType should not be UNKNOWN at this point.");
        }

        currentUserData.setState(UserState.AUDIOFILE_LOADED);
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        UserData currentUserData = usersData.get(command.getUsername());

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
        UserData currentUserData = usersData.get(command.getUsername());
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
        UserData currentUserData = usersData.get(command.getUsername());
        SourceType currentSourceType = currentUserData.getSourceType();

        PlayerState<?> currentPlayerState = currentUserData.getPlayerState();
        RepeatState currentRepeatState = currentPlayerState.getRepeatState();
        List<RepeatState> availableValues = null;
        int currentRepeatStateIndex;

        switch (currentSourceType) {
            case PLAYLIST:
                availableValues = RepeatState.getPlaylistValues();
                break;
            case LIBRARY:
            case PODCAST:
                availableValues = RepeatState.getLibraryAndPlaylistValues();
                break;
            default:
                throw new RuntimeException("BUG: Source type not set.");
        }

        currentRepeatStateIndex = availableValues.indexOf(currentRepeatState);
        currentRepeatStateIndex = (currentRepeatStateIndex + 1) % availableValues.size();
        currentPlayerState.setRepeatState(availableValues.get(currentRepeatStateIndex));

        return new RepeatCommandOutput(command, RepeatCommandOutput.Result.SUCCESS,
                availableValues.get(currentRepeatStateIndex).getValue().toLowerCase());
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
        UserData currentUserData = usersData.get(command.getUsername());

        UserState currentUserState = currentUserData.getState();
        SourceType currentSourceType = currentUserData.getSourceType();

        if (!currentUserState.equals(UserState.AUDIOFILE_LOADED)) {
            return new LikeCommandOutput(command, LikeCommandOutput.Result.NO_SOURCE);
        }

        if (currentSourceType.equals(SourceType.PODCAST)) {
            return new LikeCommandOutput(command, LikeCommandOutput.Result.SOURCE_NO_SONG);
        }

        List<SongInput> likedSongs = currentUserData.getLikedSongs();
        SongInput currentSong = null;

        if (currentSourceType.equals(SourceType.LIBRARY)) {
            currentSong = (SongInput) currentUserData.getNowPlaying();
        } else if (currentSourceType.equals(SourceType.PLAYLIST)) {
            Playlist currentPlaylist = (Playlist) currentUserData.getNowPlaying();
            currentSong = currentPlaylist.getSong(currentPlaylist.getCurrentAudioFile());
        }

        if (!likedSongs.contains(currentSong)) {
            likedSongs.add(currentSong);

            return new LikeCommandOutput(command, LikeCommandOutput.Result.LIKE);
        } else {
            likedSongs.remove(currentSong);

            return new LikeCommandOutput(command, LikeCommandOutput.Result.UNLIKE);
        }
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
        UserData currentUserData = usersData.get(command.getUsername());
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

        if (currentSong == null) {
            return new AddRemoveInPlaylistCommandOutput(command, AddRemoveInPlaylistCommandOutput.Result.NULL_SONG);
        }

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
        UserData currentUserData = usersData.get(command.getUsername());

        return new StatusCommandOutput(command,
                currentUserData.getPlayerState().getMusicPlayerState(command.getTimestamp()));
    }
}
