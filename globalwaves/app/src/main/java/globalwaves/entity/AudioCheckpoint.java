package globalwaves.entity;

public abstract class AudioCheckpoint implements AudioFile {
    protected int startTimestamp;
    protected int remainedTime;
    protected boolean paused;

    public AudioCheckpoint() {
        startTimestamp = 0;
        remainedTime = 0;

        paused = true;
    }

    public boolean getPaused() {
        return paused;
    }

    public void update(int timestamp) {
        int elapsed = 0;

        if (paused) {
            elapsed = remainedTime;
        } else {
            elapsed = remainedTime - (timestamp - startTimestamp);
        }

        if (elapsed <= 0) {
            remainedTime = 0;
            paused = true;
        }
    }

    public void startPlayback(int timestamp) {
        if (!paused) {
            return;
        }

        if (remainedTime == 0) {
            remainedTime = getDuration();
        }

        startTimestamp = timestamp;
        paused = false;

        System.out.println("Started playback at " + startTimestamp + "\tRemained Time: " + remainedTime);
    }

    public void pausePlayback(int timestamp) {
        if (paused) {
            return;
        }

        remainedTime -= (timestamp - startTimestamp);
        startTimestamp = 0;
        paused = true;

        System.out.println("Paused playback at " + timestamp + "\tRemainedTime: " + remainedTime);
    }

    public void resetPlayback(int timestamp) {
        startTimestamp = timestamp;
        remainedTime = getDuration();
        paused = false;
    }

    public void stopPlayback() {
        startTimestamp = 0;
        remainedTime = getDuration();
        paused = true;
    }

    public int getElapsed(int timestamp) {
        int elapsed = 0;

        if (paused) {
            elapsed = remainedTime;
        } else {
            elapsed = remainedTime - (timestamp - startTimestamp);
        }

        return elapsed;
    }

    public abstract int getDuration();
}
