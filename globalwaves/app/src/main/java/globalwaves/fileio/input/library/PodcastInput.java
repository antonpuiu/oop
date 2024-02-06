package globalwaves.fileio.input.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import globalwaves.entity.AudioCollection;
import globalwaves.entity.AudioFile;

public final class PodcastInput extends AudioCollection {
    private String name;
    private String owner;
    private ArrayList<EpisodeInput> episodes;

    public PodcastInput() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public ArrayList<EpisodeInput> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final ArrayList<EpisodeInput> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "PodcastInput [name=" + name + ", owner=" + owner + ", episodes=" + episodes + "]";
    }

    @Override
    public int getSize() {
        if (episodes == null)
            return -1;

        return episodes.size();
    }

    @Override
    public List<AudioFile> getAudioFiles() {
        return Collections.unmodifiableList(episodes);
    }

    @Override
    public boolean isSong() {
        return false;
    }
}
