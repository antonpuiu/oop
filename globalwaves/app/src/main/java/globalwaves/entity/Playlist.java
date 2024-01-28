package globalwaves.entity;

import java.util.ArrayList;
import java.util.List;

public class Playlist extends AudioCollection {
    private String name;
    private String owner;
    private boolean restricted;
    private ArrayList<AudioFile> songs;

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        if (songs == null)
            return -1;

        return songs.size();
    }

    @Override
    public List<AudioFile> getAudioFiles() {
        return songs;
    }
}
