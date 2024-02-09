package globalwaves.fileio.input.library;

import java.util.ArrayList;
import java.util.List;

import globalwaves.entity.AudioCheckpoint;
import globalwaves.entity.AudioCollection;

public final class PodcastInput extends AudioCollection {
    private String name;
    private String owner;
    private List<EpisodeInput> episodes;

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

    public List<EpisodeInput> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final ArrayList<EpisodeInput> episodes) {
        this.episodes = episodes;
    }

    public int getSize() {
        return episodes.size();
    }

    @Override
    public List<AudioCheckpoint> getAudioFiles() {
        List<AudioCheckpoint> audioFiles = new ArrayList<>();

        for (var episode : episodes) {
            audioFiles.add(episode);
        }

        return audioFiles;
    }

    @Override
    public String toString() {
        return "PodcastInput [name=" + name + ", owner=" + owner + ", episodes=" + episodes + "]";
    }
}
