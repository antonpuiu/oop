package globalwaves.player;

import java.util.ArrayList;

import globalwaves.entity.AudioFile;

public class User {
    private UserState state;
    private ArrayList<AudioFile> searchResults;
    private AudioFile currentSong;

    public User() {
        state = UserState.INITIAL;
        searchResults = new ArrayList<>();
        currentSong = null;
    }

    public void addSearchResult(AudioFile song) {
        searchResults.add(song);
    }

    public void finishSearch() {
        state = UserState.SEARCH_PERFORMED;
    }

    public void selectSearchResult(int index) {
        if (!state.equals(UserState.SEARCH_PERFORMED)) {
            throw new RuntimeException("Cannot select result before search");
        }

        if (index > searchResults.size()) {
            throw new IndexOutOfBoundsException();
        }

        currentSong = searchResults.get(index);
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

    enum UserState {
        INITIAL,
        SEARCH_PERFORMED,
        AUDIOFILE_SELECTED
    }
}
