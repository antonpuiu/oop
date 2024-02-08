package globalwaves.fileio.input.library;

import globalwaves.entity.AudioCheckpoint;

public final class EpisodeInput extends AudioCheckpoint {
    private String name;
    private Integer duration;
    private String description;

    public EpisodeInput() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "EpisodeInput [name=" + name + ", duration=" + duration + ", description=" + description + "]";
    }
}
