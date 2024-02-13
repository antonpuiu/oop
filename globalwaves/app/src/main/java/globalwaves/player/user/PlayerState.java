package globalwaves.player.user;

import globalwaves.entity.AudioCheckpoint;
import globalwaves.entity.AudioFile;
import globalwaves.entity.Playlist;
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.player.MusicPlayerState;

public class PlayerState<PlaybackType extends AudioCheckpoint> {
    private RepeatState repeatState;
    private boolean shuffle;
    private PlaybackType nowPlaying;

    public PlayerState() {
        repeatState = RepeatState.NO_REPEAT;

        shuffle = false;

        nowPlaying = null;
    }

    public String getRepeat() {
        return repeatState.getValue();
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public PlaybackType getNowPlaying() {
        return nowPlaying;
    }

    @SuppressWarnings("unchecked")
    public void setNowPlaying(AudioFile nowPlaying) {
        this.nowPlaying = (PlaybackType) nowPlaying;
    }

    public RepeatState getRepeatState() {
        return repeatState;
    }

    public void setRepeatState(RepeatState repeatState) {
        this.repeatState = repeatState;
    }

    public MusicPlayerState getMusicPlayerState(int timestamp) {
        int elapsed;
        String name;

        if (nowPlaying == null) {
            return new MusicPlayerState(
                    "",
                    0,
                    RepeatState.NO_REPEAT.getValue(),
                    false,
                    true);
        }

        elapsed = nowPlaying.getElapsed(timestamp);

        if (nowPlaying instanceof PodcastInput) {
            name = elapsed == 0 ? "" : ((PodcastInput) nowPlaying).getCurrentEpisode().getName();
        } else if (nowPlaying instanceof Playlist) {
            name = elapsed == 0 ? ""
                    : ((Playlist) nowPlaying).getSong(((Playlist) nowPlaying).getCurrentAudioFile()).getName();
        } else {
            name = elapsed == 0 ? "" : nowPlaying.getName();
        }

        return new MusicPlayerState(
                name,
                elapsed,
                repeatState.getValue(),
                shuffle,
                nowPlaying.getPaused());
    }

    public void pausePlayback(int timestamp) {
        nowPlaying.pausePlayback(timestamp);
    }

    public void startPlayback(int timestamp) {
        nowPlaying.startPlayback(timestamp);
    }

    public boolean playPause(int timestamp) {
        if (nowPlaying.getPaused()) {
            nowPlaying.startPlayback(timestamp);
        } else {
            nowPlaying.pausePlayback(timestamp);
        }

        return nowPlaying.getPaused();
    }
}
