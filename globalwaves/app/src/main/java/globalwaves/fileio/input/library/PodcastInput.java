package globalwaves.fileio.input.library;

import java.util.ArrayList;

import globalwaves.entity.AudioCollection;

public final class PodcastInput implements AudioCollection {
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
}
