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
import globalwaves.fileio.output.command.ResultsCommandOutput;
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

        String nameFilter = songFilter.getName();
        String albumFilter = songFilter.getAlbum();
        ArrayList<String> tagsFilter = songFilter.getTags();
        String lyricsFilter = songFilter.getLyrics();
        String genreFilter = songFilter.getGenre();
        String releaseYearFilter = songFilter.getReleaseYear();
        String artistFilter = songFilter.getArtist();

        Map<String, Function<SongInput, String>> map = new HashMap<>() {
            {
                put(albumFilter, SongInput::getAlbum);
                put(artistFilter, SongInput::getArtist);
            }
        };

        for (SongInput song : libraryInput.getSongs()) {
            boolean passed = true;

            for (String key : map.keySet()) {
                if (key == null) {
                    continue;
                }

                String mapValue = map.get(key).apply(song);

                if (!mapValue.equals(key)) {
                    passed = false;
                    break;
                }
            }

            if (lyricsFilter != null && passed && !song.getLyrics().contains(lyricsFilter)) {
                passed = false;
            }

            if (nameFilter != null && passed && !song.getName().startsWith(nameFilter)) {
                passed = false;
            }

            if (genreFilter != null && passed && !song.getGenre().toLowerCase().equals(genreFilter.toLowerCase())) {
                passed = false;
            }

            if (releaseYearFilter != null && passed) {
                boolean greater = releaseYearFilter.charAt(0) == '>';
                int targetYear = Integer.parseInt(releaseYearFilter.substring(1));
                int songYear = song.getReleaseYear();

                if ((greater && songYear < targetYear) || (!greater && songYear > targetYear)) {
                    passed = false;
                }
            }

            if (tagsFilter != null && passed) {
                for (String commandTag : tagsFilter) {
                    boolean foundTag = false;

                    for (String songTag : song.getTags()) {
                        if (songTag.equals(commandTag)) {
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
        PodcastSearchCommandFilter podcastFilter = (PodcastSearchCommandFilter) command.getFilters();

        String nameFilter = podcastFilter.getName();
        String commandOwner = podcastFilter.getOwner();

        for (PodcastInput podcast : libraryInput.getPodcasts()) {
            if ((nameFilter != null && !podcast.getName().startsWith(nameFilter)) ||
                    (commandOwner != null && !podcast.getOwner().equals(commandOwner))) {
                continue;
            }

            currentUser.addSearchResult(podcast);
        }
    }

    public void playlistSearch(SearchCommandInput command, User currentUser) {
        PlaylistSearchCommandFilter playlistFilter = (PlaylistSearchCommandFilter) command.getFilters();

        String nameFilter = playlistFilter.getName();
        String commandOwner = playlistFilter.getOwner();

        for (PodcastInput podcast : libraryInput.getPodcasts()) {
            if ((nameFilter != null && !podcast.getName().startsWith(nameFilter)) ||
                    (commandOwner != null && !podcast.getOwner().equals(commandOwner))) {
                continue;
            }

            currentUser.addSearchResult(podcast);
        }
    }

    @Override
    public ResultsCommandOutput visit(SearchCommandInput command) {
        User currentUser;
        ArrayList<String> searchResult;

        if (!users.containsKey(command.getUsername())) {
            return new ResultsCommandOutput(command, "User not found");
        }

        currentUser = users.get(command.getUsername());
        if (!currentUser.getState().equals(User.UserState.INITIAL)) {
            currentUser.resetSearch();
        }

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

        return new ResultsCommandOutput(command,
                "Search returned " + searchResult.size() + " results",
                searchResult);
    }

    @Override
    public CommandOutput visit(SelectCommandInput command) {
        User currentUser;

        if (!users.containsKey(command.getUsername())) {
            return new CommandOutput(command, "User not found");
        }

        currentUser = users.get(command.getUsername());

        try {
            currentUser.selectSearchResult(command.getItemNumber() - 1);
        } catch (RuntimeException e) {
            return new CommandOutput(command, e.getMessage());
        }

        return new CommandOutput(command,
                "Successfully selected " + currentUser.getCurrentSong().getName() + ".");
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        if (!users.containsKey(command.getUsername()) || command.getUsername() == null) {
            return new CommandOutput(command, "User not found");
        }

        try {
            User currentUser = users.get(command.getUsername());

            currentUser.loadCurrentSong(command.getTimestamp());
        } catch (RuntimeException e) {
            return new CommandOutput(command, e.getMessage());
        }

        return new CommandOutput(command, "Playback loaded successfully.");
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
