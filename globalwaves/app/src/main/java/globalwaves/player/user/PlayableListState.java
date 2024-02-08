package globalwaves.player.user;

import java.util.List;

import globalwaves.entity.AudioFile;

public class PlayableListState<PlaybackType extends AudioFile> {
    private List<PlaybackType> searchResult;
    private PlayerState<PlaybackType> playerState;

    public PlayableListState(List<PlaybackType> searchResult) {
        this.searchResult = searchResult;

        playerState = new PlayerState<>();
    }

    public List<PlaybackType> getSearchResult() {
        return searchResult;
    }

    public PlayerState<PlaybackType> getPlayerState() {
        return playerState;
    }
}
