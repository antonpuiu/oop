package globalwaves.player;

import java.util.ArrayList;

import globalwaves.entity.AudioCollection;
import globalwaves.entity.AudioFile;

public class User {
    private UserState state;
    private ArrayList<AudioFile> searchResults;
    private AudioFile currentAudioFile;
    private int loadTimestamp;

    public User() {
        state = UserState.INITIAL;
        searchResults = new ArrayList<>();
        currentAudioFile = null;
        loadTimestamp = 0;
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

    public AudioFile getCurrentSong() {
        return currentAudioFile;
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

        this.loadTimestamp = loadTimestamp;
        state = UserState.AUDIOFILE_LOADED;
    }

    public UserState getState() {
        return state;
    }

    public void resetSearch() {
        state = UserState.INITIAL;
        searchResults.clear();
        currentAudioFile = null;
        loadTimestamp = 0;
    }

    enum UserState {
        INITIAL,
        SEARCH_PERFORMED,
        AUDIOFILE_SELECTED,
        AUDIOFILE_LOADED
    }
}
