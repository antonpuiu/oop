package globalwaves.fileio.input.command.searchbar.filter;

import java.util.ArrayList;

public class SearchCommandFilter {
    private String name;
    private String owner;
    private String album;
    private ArrayList<String> tags;
    private String lyrics;
    private String genre;
    private String releaseYear;
    private String artist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "SearchCommandFilter [name=" + name + ", owner=" + owner + ", album=" + album + ", tags=" + tags
                + ", lyrics=" + lyrics + ", genre=" + genre + ", releaseYear=" + releaseYear + ", artist=" + artist
                + "]";
    }
}
