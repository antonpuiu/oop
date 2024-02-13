package globalwaves.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import globalwaves.fileio.input.library.SongInput;
import globalwaves.player.user.UserData;

public class Playlist extends AudioCollection {
    private String name;
    private String owner;
    private boolean restricted;
    private List<SongInput> songs;
    private List<UserData> followers;

    public Playlist(String name, String owner) {
        this(name, owner, false);
    }

    public Playlist(String name, String owner, boolean restricted) {
        this.name = name;
        this.owner = owner;
        this.restricted = restricted;

        songs = new LinkedList<>();
        followers = new LinkedList<>();
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

    public void follow(UserData userData) {
        followers.add(userData);
    }

    public void unfollow(UserData userData) {
        followers.remove(userData);
    }

    public int getFollowers() {
        return followers.size();
    }

    @Override
    public List<AudioCheckpoint> getAudioFiles() {
        List<AudioCheckpoint> audioFiles = new ArrayList<>();

        for (var song : songs) {
            audioFiles.add(song);
        }

        return audioFiles;
    }
}
