package lab5.task4;

import java.util.ArrayList;

public abstract class Album {
    protected ArrayList<Song> songs;

    public Album() {
        songs = new ArrayList<>();
    }

    abstract void addSong(Song song);

    void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        return "Album [songs=" + songs + "]";
    }
}
