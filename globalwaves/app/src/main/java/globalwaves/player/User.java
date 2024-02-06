package globalwaves.player;

import java.util.ArrayList;
import java.util.List;

import globalwaves.entity.AudioCollection;
import globalwaves.entity.AudioFile;
import globalwaves.entity.Playlist;
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.fileio.input.library.SongInput;
import globalwaves.fileio.output.command.player.LoadCommandOutput;
import globalwaves.fileio.output.command.player.PlayPauseCommandOutput;
import globalwaves.fileio.output.command.searchbar.SelectCommandOutput;

public class User {
    private UserState state;
    private AudioFile currentAudioFile;

    private ArrayList<AudioFile> searchResults;
    private ArrayList<Playlist> playlists;

    private int startTimestamp;
    private int remainedTime;
    private String repeat;
    private boolean shuffle;
    private boolean paused;

    public User() {
        state = UserState.INITIAL;
        currentAudioFile = null;

        searchResults = new ArrayList<>();
        playlists = new ArrayList<>();

        startTimestamp = 0;
        remainedTime = 0;
        repeat = "No Repeat";
        shuffle = false;
        paused = false;
    }

    public void addSearchResult(AudioFile song) {
        searchResults.add(song);
    }

    public void setSongSearchResult(List<SongInput> searchResults) {
        this.searchResults.clear();
        this.searchResults.addAll(searchResults);
        state = UserState.SEARCH_PERFORMED;
    }

    public void setPodcastSearchResult(List<PodcastInput> searchResults) {
        this.searchResults.clear();
        this.searchResults.addAll(searchResults);
        state = UserState.SEARCH_PERFORMED;
    }

    public void setPlaylistSearchResult(List<Playlist> searchResults) {
        this.searchResults.clear();
        this.searchResults.addAll(searchResults);
        state = UserState.SEARCH_PERFORMED;
    }

    public void setSearchResult(List<AudioFile> searchResults) {
        this.searchResults.clear();
        this.searchResults.addAll(searchResults);
        state = UserState.SEARCH_PERFORMED;
    }

    public void finishSearch() {
        state = UserState.SEARCH_PERFORMED;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public SelectCommandOutput.Result selectSearchResult(int index) {
        if (!state.equals(UserState.SEARCH_PERFORMED)) {
            return SelectCommandOutput.Result.NO_SEARCH;
        }

        if (index >= searchResults.size()) {
            return SelectCommandOutput.Result.OUT_OF_BOUNDS;
        }

        currentAudioFile = searchResults.get(index);
        searchResults.clear();
        state = UserState.AUDIOFILE_SELECTED;

        if (currentAudioFile.isCollection()) {
            ((AudioCollection) currentAudioFile).setCurrentAudioFile(0);
        }

        return SelectCommandOutput.Result.SUCCESS;
    }

    public ArrayList<String> getSearchResults() {
        ArrayList<String> result = new ArrayList<>();

        for (AudioFile song : searchResults) {
            if (result.size() == 5) {
                break;
            }

            result.add(song.getName());
        }

        return result;
    }

    public AudioFile getCurrentAudioFile() {
        return currentAudioFile;
    }

    public LoadCommandOutput.Result loadCurrentSong(int loadTimestamp) {
        if (currentAudioFile == null || !state.equals(UserState.AUDIOFILE_SELECTED)) {
            return LoadCommandOutput.Result.NO_SOURCE;
        }

        if (currentAudioFile.isCollection()) {
            AudioCollection collection = (AudioCollection) currentAudioFile;

            if (collection.getSize() <= 0) {
                return LoadCommandOutput.Result.EMPTY_COLLECTION;
            }
        }

        state = UserState.AUDIOFILE_LOADED;
        paused = false;
        startTimestamp = loadTimestamp;
        remainedTime = currentAudioFile.getDuration();

        return LoadCommandOutput.Result.SUCCESS;
    }

    public UserState getState() {
        return state;
    }

    public void resetSearch() {
        state = UserState.INITIAL;
        searchResults.clear();
        currentAudioFile = null;
        remainedTime = 0;
    }

    private void pausePlayback(int timestamp) {
        paused = true;
        remainedTime -= (timestamp - startTimestamp);
        startTimestamp = 0;
    }

    private void startPlayback(int timestamp) {
        paused = false;
        startTimestamp = timestamp;
    }

    public PlayPauseCommandOutput.Result playPause(int timestamp) {
        if (!state.equals(UserState.AUDIOFILE_LOADED)) {
            return PlayPauseCommandOutput.Result.NO_SOURCE;
        }

        if (paused) {
            startPlayback(timestamp);

            return PlayPauseCommandOutput.Result.RESUME;
        } else {
            pausePlayback(timestamp);

            return PlayPauseCommandOutput.Result.PAUSE;
        }
    }

    public MusicPlayerState getMusicPlayerState(int timestamp) {
        int elapsed;
        String name;

        if (paused) {
            elapsed = remainedTime;
        } else {
            elapsed = remainedTime - (timestamp - startTimestamp);
        }

        if (elapsed < 0) {
            currentAudioFile = null;
            elapsed = 0;
            paused = true;
        }

        name = currentAudioFile == null ? "" : currentAudioFile.getName();

        return new MusicPlayerState(
                name,
                elapsed,
                repeat,
                shuffle,
                paused);
    }

    public enum UserState {
        INITIAL,
        SEARCH_PERFORMED,
        AUDIOFILE_SELECTED,
        AUDIOFILE_LOADED
    }
}
