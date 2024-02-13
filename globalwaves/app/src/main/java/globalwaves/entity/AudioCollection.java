package globalwaves.entity;

import java.util.List;

public abstract class AudioCollection extends AudioCheckpoint {
    protected int currentAudioFile;

    public AudioCollection() {
        currentAudioFile = 0;
    }

    public int getCurrentAudioFile() {
        return currentAudioFile;
    }

    public void resetCurrentAudioFile() {
        currentAudioFile = 0;
    }

    public void setCurrentAudioFile(int currentAudioFile) {
        this.currentAudioFile = currentAudioFile;
    }

    @Override
    public void update(int timestamp) {
        List<AudioCheckpoint> audioFiles = getAudioFiles();
        AudioCheckpoint currentAudioCheckpoint = audioFiles.get(currentAudioFile);
        int elapsed = currentAudioCheckpoint.getElapsed(timestamp);

        if (elapsed > 0) {
            return;
        }

        System.out.println("Elapsed: " + elapsed);
        System.out.println("Paused: " + paused);

        currentAudioCheckpoint.stopPlayback();
        currentAudioFile++;

        if (currentAudioFile == audioFiles.size()) {
            System.out.println("currentAudioFile == audioFile.size()");
            currentAudioFile--;
            paused = true;

            return;
        }

        audioFiles.get(currentAudioFile).startPlayback(timestamp + elapsed);
    }

    @Override
    public int getDuration() {
        return getAudioFiles().get(currentAudioFile).getDuration();
    }

    @Override
    public int getElapsed(int timestamp) {
        if (paused) {
            System.out.println("Collection paused");
            return 0;
        }

        return getAudioFiles().get(currentAudioFile).getElapsed(timestamp);
    }

    @Override
    public boolean getPaused() {
        if (paused) {
            return true;
        }

        return getAudioFiles().get(currentAudioFile).getPaused();
    }

    @Override
    public void startPlayback(int timestamp) {
        paused = false;
        getAudioFiles().get(currentAudioFile).startPlayback(timestamp);
    }

    @Override
    public void pausePlayback(int timestamp) {
        getAudioFiles().get(currentAudioFile).pausePlayback(timestamp);
    }

    public abstract List<AudioCheckpoint> getAudioFiles();
}
