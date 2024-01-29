package globalwaves.player;

import java.util.ArrayList;

import globalwaves.entity.AudioCollection;
import globalwaves.entity.AudioFile;

public class User {
    private UserState state;
    private ArrayList<AudioFile> searchResults;
    private AudioFile currentAudioFile;

    private int startTimestamp;
    private int remainedTime;
    private String repeat;
    private boolean shuffle;
    private boolean paused;

    public User() {
        state = UserState.INITIAL;
        searchResults = new ArrayList<>();
        currentAudioFile = null;
        remainedTime = 0;
        repeat = "No Repeat";
        shuffle = false;
        paused = false;
    }

    public void addSearchResult(AudioFile song) {
        searchResults.add(song);
    }

    public void finishSearch() {
        state = UserState.SEARCH_PERFORMED;
    }

    public void selectSearchResult(int index) {
        if (!state.equals(UserState.SEARCH_PERFORMED)) {
            throw new RuntimeException("Please conduct a search before making a selection.");
        }

        if (index > searchResults.size()) {
            throw new RuntimeException("The selected ID is too high.");
        }

        currentAudioFile = searchResults.get(index);
        searchResults.clear();
        state = UserState.AUDIOFILE_SELECTED;
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

    public AudioFile getCurrentSong() {
        return currentAudioFile;
    }

    public void loadCurrentSong(int loadTimestamp) {
        if (currentAudioFile == null || !state.equals(UserState.AUDIOFILE_SELECTED)) {
            throw new RuntimeException("Please select a source before attempting to load.");
        }

        if (currentAudioFile.isCollection()) {
            AudioCollection collection = (AudioCollection) currentAudioFile;

            if (collection.getSize() <= 0) {
                throw new RuntimeException("You can't load an empty audio collection!");
            }
        }

        state = UserState.AUDIOFILE_LOADED;
        startTimestamp = loadTimestamp;
        remainedTime = currentAudioFile.getDuration();
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

    public boolean playPause(int timestamp) {
        if (!state.equals(UserState.AUDIOFILE_LOADED)) {
            throw new RuntimeException("Please load a source before attempting to pause or resume playback.");
        }

        if (paused) {
            startPlayback(timestamp);

            return true;
        } else {
            pausePlayback(timestamp);

            return false;
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
