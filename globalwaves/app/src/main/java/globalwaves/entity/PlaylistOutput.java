package globalwaves.entity;

import java.util.List;

public class PlaylistOutput {
    private String name;
    private List<String> songs;
    private String visibility;
    private int followers;

    public PlaylistOutput(String name, List<String> songs, String visibility, int followers) {
        this.name = name;
        this.songs = songs;
        this.visibility = visibility;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
