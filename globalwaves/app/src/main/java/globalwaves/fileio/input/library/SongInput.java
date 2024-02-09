package globalwaves.fileio.input.library;

import java.util.List;

import globalwaves.entity.AudioCheckpoint;

public final class SongInput extends AudioCheckpoint {
    private String name;
    private Integer duration;
    private String album;
    private List<String> tags;
    private String lyrics;
    private String genre;
    private Integer releaseYear;
    private String artist;

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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(final String album) {
        this.album = album;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(final String lyrics) {
        this.lyrics = lyrics;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(final String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(final int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "SongInput [name=" + name + ", duration=" + duration + ", album=" + album + ", tags=" + tags
                + ", lyrics="
                + lyrics + ", genre=" + genre + ", releaseYear=" + releaseYear + ", artist=" + artist + "]";
    }
}
