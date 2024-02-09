package globalwaves.player.user;

import java.util.ArrayList;
import java.util.List;

import globalwaves.entity.AudioFile;
import globalwaves.entity.Playlist;
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.fileio.input.library.SongInput;

public class UserData {
    private List<Playlist> playlists;
    private SourceType sourceType;
    private UserState state;

    private PlayableListState<SongInput> libraryInput;
    private PlayableListState<PodcastInput> podcastInput;
    private PlayableListState<Playlist> playlistInput;

    public UserData() {
        playlists = new ArrayList<>();
        sourceType = SourceType.UNKNOWN;
        state = UserState.INITIAL;

        libraryInput = null;
        podcastInput = null;
        playlistInput = null;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public List<? extends AudioFile> getSearchResult() {
        switch (sourceType) {
            case LIBRARY:
                return libraryInput.getSearchResult();
            case PODCAST:
                return podcastInput.getSearchResult();
            case PLAYLIST:
                return playlistInput.getSearchResult();
            default:
                return null;
        }
    }

    public PlayerState<?> getPlayerState() {
        switch (sourceType) {
            case LIBRARY:
                return libraryInput.getPlayerState();
            case PODCAST:
                return podcastInput.getPlayerState();
            case PLAYLIST:
                return playlistInput.getPlayerState();
            default:
                return null;
        }
    }

    @SuppressWarnings("unchecked")
    public void setSearchResult(List<? extends AudioFile> searchResult, SourceType sourceType) {
        resetSearchResult();

        switch (sourceType) {
            case LIBRARY:
                libraryInput = new PlayableListState<>((List<SongInput>) searchResult);
                break;
            case PODCAST:
                podcastInput = new PlayableListState<>((List<PodcastInput>) searchResult);
                break;
            case PLAYLIST:
                playlistInput = new PlayableListState<>((List<Playlist>) searchResult);
                break;
            default:
                return;
        }

        state = UserState.SEARCH_PERFORMED;
        this.sourceType = sourceType;
    }

    public void resetSearchResult() {
        state = UserState.INITIAL;

        libraryInput = null;
        podcastInput = null;
        playlistInput = null;
    }

    public AudioFile getNowPlaying() {
        if (state.equals(UserState.INITIAL) ||
                state.equals(UserState.SEARCH_PERFORMED)) {
            return null;
        }

        switch (sourceType) {
            case LIBRARY:
                return libraryInput.getPlayerState().getNowPlaying();
            case PLAYLIST:
                return playlistInput.getPlayerState().getNowPlaying();
            case PODCAST:
                return podcastInput.getPlayerState().getNowPlaying();
            default:
                return null;
        }
    }
}
