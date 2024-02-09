package globalwaves.player.user;

import globalwaves.entity.AudioCheckpoint;
import globalwaves.entity.AudioFile;
import globalwaves.entity.Playlist;
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.player.MusicPlayerState;

public class PlayerState<PlaybackType extends AudioCheckpoint> {
    private int startTimestamp;
    private int remainedTime;
    private RepeatState repeatState;
    private boolean shuffle;
    private boolean paused;
    private PlaybackType nowPlaying;

    public PlayerState() {
        startTimestamp = 0;
        remainedTime = 0;

        repeatState = RepeatState.NO_REPEAT;

        shuffle = false;
        paused = false;

        nowPlaying = null;
    }

    public int getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(int startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public int getRemainedTime() {
        return remainedTime;
    }

    public void setRemainedTime(int remainedTime) {
        this.remainedTime = remainedTime;
    }

    public String getRepeat() {
        return repeatState.getValue();
    }

    public void setRepeat(RepeatState repeatState) {
        this.repeatState = repeatState;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
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

        if (paused) {
            elapsed = remainedTime;
        } else {
            elapsed = remainedTime - (timestamp - startTimestamp);
        }

        if (elapsed < 0) {
            elapsed = 0;
            paused = true;
        }

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
                paused);
    }

    public void pausePlayback(int timestamp) {
        paused = true;
        remainedTime -= (timestamp - startTimestamp);
        startTimestamp = 0;
    }

    public void startPlayback(int timestamp) {
        paused = false;
        startTimestamp = timestamp;
    }

    public boolean playPause(int timestamp) {
        if (paused) {
            startPlayback(timestamp);
        } else {
            pausePlayback(timestamp);
        }

        return paused;
    }
}
