package globalwaves.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import globalwaves.entity.Playlist;
import globalwaves.fileio.input.command.general.GetTop5PlaylistsCommandInput;
import globalwaves.fileio.input.command.general.GetTop5SongsCommandInput;
import globalwaves.fileio.input.command.player.AddRemoveInPlaylistCommandInput;
import globalwaves.fileio.input.command.player.BackwardCommandInput;
import globalwaves.fileio.input.command.player.ForwardCommandInput;
import globalwaves.fileio.input.command.player.LikeCommandInput;
import globalwaves.fileio.input.command.player.LoadCommandInput;
import globalwaves.fileio.input.command.player.NextCommandInput;
import globalwaves.fileio.input.command.player.PlayPauseCommandInput;
import globalwaves.fileio.input.command.player.PrevCommandInput;
import globalwaves.fileio.input.command.player.RepeatCommandInput;
import globalwaves.fileio.input.command.player.ShuffleCommandInput;
import globalwaves.fileio.input.command.player.StatusCommandInput;
import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.input.command.searchbar.filter.PlaylistSearchCommandFilter;
import globalwaves.fileio.input.command.searchbar.filter.PodcastSearchCommandFilter;
import globalwaves.fileio.input.command.searchbar.filter.SongSearchCommandFilter;
import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.input.library.LibraryInput;
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.fileio.input.library.SongInput;
import globalwaves.fileio.input.library.UserInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public class Player implements CommandVisitor {
    private LibraryInput libraryInput;
    private Map<String, User> users;
    private ArrayList<Playlist> playlists;

    public Player() {
        libraryInput = null;
        users = new HashMap<>();
    }

    public void loadLibrary(LibraryInput libraryInput) {
        if (!users.isEmpty())
            return;

        this.libraryInput = libraryInput;

        for (UserInput user : libraryInput.getUsers())
            users.put(user.getUsername(), new User());
    }

    private void searchSong(SearchCommandInput command, User currentUser) {
        SongSearchCommandFilter songFilter = (SongSearchCommandFilter) command.getFilters();

        String name = songFilter.getName();
        String album = songFilter.getAlbum();
        ArrayList<String> tags = songFilter.getTags();
        String lyrics = songFilter.getLyrics();
        String genre = songFilter.getGenre();
        String releaseYear = songFilter.getReleaseYear();
        String artist = songFilter.getArtist();

        Map<String, Function<SongInput, String>> map = new HashMap<>() {
            {
                put(name, SongInput::getName);
                put(album, SongInput::getAlbum);
                put(lyrics, SongInput::getLyrics);
                put(genre, SongInput::getGenre);
                put(artist, SongInput::getArtist);
            }
        };

        for (SongInput song : libraryInput.getSongs()) {
            boolean passed = true;

            for (String key : map.keySet()) {
                if (key == null) {
                    continue;
                }

                String mapValue = map.get(key).apply(song);

                if (mapValue != null && !key.equals(mapValue)) {
                    passed = false;
                    break;
                }
            }

            if (releaseYear != null && passed) {
                boolean greater = releaseYear.charAt(0) == '>';
                int targetYear = Integer.parseInt(releaseYear.substring(1));
                int songYear = song.getReleaseYear();

                if ((greater && songYear < targetYear) || (!greater && songYear > targetYear)) {
                    passed = false;
                }
            }

            if (tags != null && passed) {
                for (String filterTag : tags) {
                    boolean foundTag = false;

                    for (String songTag : song.getTags()) {
                        if (songTag.equals(filterTag)) {
                            foundTag = true;
                            break;
                        }
                    }

                    if (!foundTag) {
                        passed = false;
                        break;
                    }
                }
            }

            if (!passed) {
                continue;
            }

            currentUser.addSearchResult(song);
        }
    }

    private void podcastSearch(SearchCommandInput command, User currentUser) {
        PodcastSearchCommandFilter songFilter = (PodcastSearchCommandFilter) command.getFilters();

        String name = songFilter.getName();
        String owner = songFilter.getOwner();

        Map<String, Function<PodcastInput, String>> map = new HashMap<>() {
            {
                put(name, PodcastInput::getName);
                put(owner, PodcastInput::getOwner);
            }
        };

        for (PodcastInput podcast : libraryInput.getPodcasts()) {
            boolean passed = true;

            for (String key : map.keySet()) {
                if (key == null) {
                    continue;
                }

                String mapValue = map.get(key).apply(podcast);

                if (mapValue != null && !key.equals(mapValue)) {
                    passed = false;
                    continue;
                }
            }

            if (!passed) {
                continue;
            }

            currentUser.addSearchResult(podcast);
        }
    }

    public void playlistSearch(SearchCommandInput command, User currentUser) {
        PlaylistSearchCommandFilter songFilter = (PlaylistSearchCommandFilter) command.getFilters();

        String name = songFilter.getName();
        String owner = songFilter.getOwner();

        Map<String, Function<Playlist, String>> map = new HashMap<>() {
            {
                put(name, Playlist::getName);
                put(owner, Playlist::getOwner);
            }
        };

        for (Playlist playlist : playlists) {
            boolean passed = true;

            for (String key : map.keySet()) {
                if (key == null) {
                    continue;
                }

                String mapValue = map.get(key).apply(playlist);

                if (mapValue != null && !key.equals(mapValue)) {
                    passed = false;
                    continue;
                }
            }

            if (!passed) {
                continue;
            }

            currentUser.addSearchResult(playlist);
        }
    }

    @Override
    public CommandOutput visit(SearchCommandInput command) {
        User currentUser;
        ArrayList<String> searchResult;

        if (!users.containsKey(command.getUsername())) {
            return new CommandOutput(command, "User not found");
        }

        currentUser = users.get(command.getUsername());

        switch (command.getType()) {
            case "song":
                searchSong(command, currentUser);
                break;
            case "podcast":
                podcastSearch(command, currentUser);
                break;
            case "playlist":
                playlistSearch(command, currentUser);
                break;
        }

        currentUser.finishSearch();
        searchResult = currentUser.getSearchResults();

        return new CommandOutput(command,
                "Search returned " + searchResult.size() + " results",
                searchResult);
    }

    @Override
    public CommandOutput visit(SelectCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(PlayPauseCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(RepeatCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ShuffleCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ForwardCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(BackwardCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(LikeCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(NextCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(PrevCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(AddRemoveInPlaylistCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(StatusCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(CreatePlaylistCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(SwitchVisibilityCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(FollowPlaylistCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ShowPlaylistsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(ShowPreferredSongsCommandInput visitor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(GetTop5SongsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandOutput visit(GetTop5PlaylistsCommandInput command) {
        // TODO Auto-generated method stub
        return null;
    }
}
