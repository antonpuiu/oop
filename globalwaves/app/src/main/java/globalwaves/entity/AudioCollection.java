package globalwaves.entity;

import java.util.List;

public abstract class AudioCollection implements AudioFile {
    private AudioFile currentAudioFile;

    public AudioFile getCurrentAudioFile() {
        return currentAudioFile;
    }

    public void setCurrentAudioFile(AudioFile currentAudioFile) {
        this.currentAudioFile = currentAudioFile;
    }

    public void setCurrentAudioFile(int index) {
        currentAudioFile = getAudioFiles().get(index);
    }

    @Override
    public boolean isCollection() {
        return true;
    }

    @Override
    public int getDuration() {
        if (currentAudioFile == null) {
            return -1;
        }

        return currentAudioFile.getDuration();
    }

    public abstract int getSize();

    public abstract List<AudioFile> getAudioFiles();
}
