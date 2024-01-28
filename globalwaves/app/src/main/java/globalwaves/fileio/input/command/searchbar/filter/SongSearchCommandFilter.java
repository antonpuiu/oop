package globalwaves.fileio.input.command.searchbar.filter;

import java.util.ArrayList;

public final class SongSearchCommandFilter extends SearchCommandFilter {
    private String album;
    private ArrayList<String> tags;
    private String lyrics;
    private String genre;
    private String releaseYear;
    private String artist;

    public SongSearchCommandFilter() {
    }

    public SongSearchCommandFilter(final String name, final String album,
            final ArrayList<String> tags, final String lyrics, final String genre,
            final String releaseYear, final String artist) {
        super(name);

        this.album = album;
        this.tags = tags;
        this.lyrics = lyrics;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.artist = artist;
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

    @Override
    public String toString() {
        return super.toString() + "SongSearchCommandFilter [album=" + album + ", tags=" + tags + ", lyrics=" + lyrics
                + ", genre=" + genre
                + ", releaseYear=" + releaseYear + ", artist=" + artist + "]";
    }

}
