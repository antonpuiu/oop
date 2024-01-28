package globalwaves.fileio.input.library;

import java.util.ArrayList;
import java.util.List;

import globalwaves.entity.AudioCollection;
import globalwaves.entity.AudioFile;

public final class LibraryInput extends AudioCollection {
    private ArrayList<SongInput> songs;
    private ArrayList<PodcastInput> podcasts;
    private ArrayList<UserInput> users;

    public LibraryInput() {
    }

    @Override
    public String getName() {
        return null;
    }

    public ArrayList<SongInput> getSongs() {
        return songs;
    }

    public void setSongs(final ArrayList<SongInput> songs) {
        this.songs = songs;
    }

    public ArrayList<PodcastInput> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(final ArrayList<PodcastInput> podcasts) {
        this.podcasts = podcasts;
    }

    public ArrayList<UserInput> getUsers() {
        return users;
    }

    public void setUsers(final ArrayList<UserInput> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "LibraryInput [songs=" + songs + ", podcasts=" + podcasts + ", users=" + users + "]";
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public List<AudioFile> getAudioFiles() {
        return null;
    }
}
