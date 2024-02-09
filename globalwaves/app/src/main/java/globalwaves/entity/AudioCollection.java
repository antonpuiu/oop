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

    public void setCurrentAudioFile(int currentAudioFile) {
        this.currentAudioFile = currentAudioFile;
    }

    @Override
    public int getCheckpoint() {
        return getAudioFiles().get(currentAudioFile).getCheckpoint();
    }

    @Override
    public void addCheckpoint(int qty) {
        getAudioFiles().get(currentAudioFile).addCheckpoint(qty);
    }

    public abstract List<AudioCheckpoint> getAudioFiles();
}
