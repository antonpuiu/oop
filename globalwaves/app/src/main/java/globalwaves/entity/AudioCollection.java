package globalwaves.entity;

import java.util.List;

public abstract class AudioCollection implements AudioFile {
    @Override
    public boolean isCollection() {
        return true;
    }

    public abstract int getSize();

    public abstract List<AudioFile> getAudioFiles();
}
