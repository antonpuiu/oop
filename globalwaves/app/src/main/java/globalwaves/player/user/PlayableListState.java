package globalwaves.player.user;

import java.util.List;

import globalwaves.entity.AudioCheckpoint;

public class PlayableListState<PlaybackType extends AudioCheckpoint> {
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
