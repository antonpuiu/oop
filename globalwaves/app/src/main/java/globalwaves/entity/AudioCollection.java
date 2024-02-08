package globalwaves.entity;

public class AudioCollection {
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
}
