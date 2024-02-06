package globalwaves.fileio.input.command.searchbar.filter;

import java.util.ArrayList;

public final class SongSearchCommandFilter {
    private String name;
    private String album;
    private ArrayList<String> tags;
    private String lyrics;
    private String genre;
    private String releaseYear;
    private String artist;

    public SongSearchCommandFilter(SearchCommandFilter filter) {
        name = filter.getName();
        album = filter.getAlbum();
        tags = filter.getTags();
        lyrics = filter.getLyrics();
        genre = filter.getGenre();
        releaseYear = filter.getReleaseYear();
        artist = filter.getArtist();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(final String album) {
        this.album = album;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(final ArrayList<String> tags) {
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(final String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }
}
