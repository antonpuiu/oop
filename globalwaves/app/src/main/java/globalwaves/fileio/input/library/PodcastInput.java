package globalwaves.fileio.input.library;

import java.util.ArrayList;

import globalwaves.entity.AudioCollection;
import globalwaves.entity.AudioFile;

public final class PodcastInput extends AudioCollection implements AudioFile {
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

    public EpisodeInput getCurrentEpisode() {
        return episodes.get(currentAudioFile);
    }

    public ArrayList<EpisodeInput> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final ArrayList<EpisodeInput> episodes) {
        this.episodes = episodes;
    }

    public int getSize() {
        return episodes.size();
    }

    @Override
    public String toString() {
        return "PodcastInput [name=" + name + ", owner=" + owner + ", episodes=" + episodes + "]";
    }
}
