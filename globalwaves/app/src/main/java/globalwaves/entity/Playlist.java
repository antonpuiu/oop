package globalwaves.entity;

import java.util.ArrayList;

import globalwaves.fileio.input.library.SongInput;

public class Playlist extends AudioCollection implements AudioFile {
    private String name;
    private String owner;
    private boolean restricted;
    private ArrayList<SongInput> songs;

    public Playlist(String name, String owner) {
        this(name, owner, false);
    }

    public Playlist(String name, String owner, boolean restricted) {
        this.name = name;
        this.owner = owner;
        this.restricted = restricted;

        songs = new ArrayList<>();
    }

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

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public boolean containsSong(SongInput song) {
        return songs.contains(song);
    }

    public void addSong(SongInput song) {
        songs.add(song);
    }

    public SongInput getSong(int index) {
        return songs.get(index);
    }

    public void removeSong(SongInput song) {
        songs.remove(song);
    }

    public int getSize() {
        return songs.size();
    }
}
