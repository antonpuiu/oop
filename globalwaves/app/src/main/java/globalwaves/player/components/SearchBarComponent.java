package globalwaves.player.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.input.command.searchbar.filter.PlaylistSearchCommandFilter;
import globalwaves.fileio.input.command.searchbar.filter.PodcastSearchCommandFilter;
import globalwaves.fileio.input.command.searchbar.filter.SongSearchCommandFilter;
import globalwaves.fileio.input.library.LibraryInput;
import globalwaves.fileio.input.library.PodcastInput;
import globalwaves.fileio.input.library.SongInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.searchbar.SearchCommandOutput;
import globalwaves.fileio.output.command.searchbar.SelectCommandOutput;
import globalwaves.player.User;
import globalwaves.visitor.command.SearchBarCommandVisitor;

public class SearchBarComponent implements SearchBarCommandVisitor {
    private LibraryInput libraryInput;
    private Map<String, User> users;

    public SearchBarComponent(LibraryInput libraryInput, Map<String, User> users) {
        this.libraryInput = libraryInput;
        this.users = users;
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

    private void playlistSearch(SearchCommandInput command, User currentUser) {
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
    public SearchCommandOutput visit(SearchCommandInput command) {
        User currentUser;
        ArrayList<String> searchResult;

        if (!users.containsKey(command.getUsername())) {
            return new SearchCommandOutput(command, "User not found");
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

        return new SearchCommandOutput(command,
                "Search returned " + searchResult.size() + " results",
                searchResult);
    }

    @Override
    public CommandOutput visit(SelectCommandInput command) {
        User currentUser;

        if (!users.containsKey(command.getUsername())) {
            return new SelectCommandOutput(command, "User not found");
        }

        currentUser = users.get(command.getUsername());

        try {
            currentUser.selectSearchResult(command.getItemNumber() - 1);
        } catch (RuntimeException e) {
            return new SelectCommandOutput(command, e.getMessage());
        }

        return new SelectCommandOutput(command,
                "Successfully selected " + currentUser.getCurrentSong().getName() + ".");
    }
}
