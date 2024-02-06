package globalwaves.player.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import globalwaves.entity.Playlist;
import globalwaves.fileio.input.command.searchbar.PlaylistSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.PodcastSearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SearchCommandInput;
import globalwaves.fileio.input.command.searchbar.SelectCommandInput;
import globalwaves.fileio.input.command.searchbar.SongSearchCommandInput;
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
    private List<Playlist> playlists;

    public SearchBarComponent(LibraryInput libraryInput, Map<String, User> users, List<Playlist> playlists) {
        this.libraryInput = libraryInput;
        this.users = users;
        this.playlists = playlists;
    }

    private void searchSong(SongSearchCommandInput command, User currentUser) {
        SongSearchCommandFilter songFilter = command.getSongFilter();
        List<SongInput> audioFiles = libraryInput.getSongs();
        ArrayList<Predicate<SongInput>> predicates = new ArrayList<>();

        String nameFilter = songFilter.getName();
        String albumFilter = songFilter.getAlbum();
        ArrayList<String> tagsFilter = songFilter.getTags();
        String lyricsFilter = songFilter.getLyrics();
        String genreFilter = songFilter.getGenre();
        String releaseYearFilter = songFilter.getReleaseYear();
        String artistFilter = songFilter.getArtist();

        if (nameFilter != null) {
            predicates.add(song -> (song.getName().toLowerCase().startsWith(nameFilter.toLowerCase())));
        }

        if (albumFilter != null) {
            predicates.add(song -> (song.getAlbum().toLowerCase().equals(albumFilter.toLowerCase())));
        }

        if (tagsFilter != null) {
            for (String tag : tagsFilter) {
                predicates.add(song -> {
                    song.setTags(song.getTags().stream().map(String::toLowerCase).toList());

                    return song.getTags().contains(tag.toLowerCase());
                });
            }
        }

        if (lyricsFilter != null) {
            predicates.add(song -> (song.getLyrics().toLowerCase().contains(lyricsFilter.toLowerCase())));
        }

        if (genreFilter != null) {
            predicates.add(song -> (song.getGenre().toLowerCase().equals(genreFilter.toLowerCase())));
        }

        if (releaseYearFilter != null) {
            predicates.add(song -> {
                boolean greater = releaseYearFilter.charAt(0) == '>';
                int targetYear = Integer.parseInt(releaseYearFilter.substring(1));
                int songYear = song.getReleaseYear();

                return !((greater && songYear < targetYear) || (!greater && songYear > targetYear));
            });
        }

        if (artistFilter != null) {
            predicates.add(song -> (song.getArtist().toLowerCase().equals(artistFilter.toLowerCase())));
        }

        Stream<SongInput> audioFilesStream = audioFiles.stream();

        for (var predicate : predicates) {
            audioFilesStream = audioFilesStream.filter(predicate);
        }

        audioFiles = audioFilesStream.toList();
        currentUser.setSongSearchResult(audioFiles);
    }

    private void podcastSearch(PodcastSearchCommandInput command, User currentUser) {
        PodcastSearchCommandFilter podcastFilter = command.getPodcastFilter();
        List<PodcastInput> audioFiles = libraryInput.getPodcasts();
        ArrayList<Predicate<PodcastInput>> predicates = new ArrayList<>();

        String nameFilter = podcastFilter.getName();
        String ownerFilter = podcastFilter.getOwner();

        if (nameFilter != null) {
            predicates.add(podcast -> (podcast.getName().toLowerCase().startsWith(nameFilter.toLowerCase())));
        }

        if (ownerFilter != null) {
            predicates.add(podcast -> (podcast.getOwner().toLowerCase().equals(ownerFilter.toLowerCase())));
        }

        Stream<PodcastInput> audioFilesStream = audioFiles.stream();

        for (var predicate : predicates) {
            audioFilesStream = audioFilesStream.filter(predicate);
        }

        audioFiles = audioFilesStream.toList();
        currentUser.setPodcastSearchResult(audioFiles);
    }

    private void playlistSearch(PlaylistSearchCommandInput command, User currentUser) {
        PlaylistSearchCommandFilter playlistFilter = command.getPlaylistFilter();
        List<Playlist> audioFiles = playlists;
        ArrayList<Predicate<Playlist>> predicates = new ArrayList<>();

        String nameFilter = playlistFilter.getName();
        String ownerFilter = playlistFilter.getOwner();

        if (nameFilter != null) {
            predicates.add(podcast -> (podcast.getName().toLowerCase().startsWith(nameFilter.toLowerCase())));
        }

        if (ownerFilter != null) {
            predicates.add(podcast -> (podcast.getOwner().toLowerCase().equals(ownerFilter.toLowerCase())));
        }

        Stream<Playlist> audioFilesStream = audioFiles.stream();

        for (var predicate : predicates) {
            audioFilesStream = audioFilesStream.filter(predicate);
        }

        audioFiles = audioFilesStream.toList();
        currentUser.setPlaylistSearchResult(audioFiles);
    }

    @Override
    public CommandOutput visit(SongSearchCommandInput command) {
        User currentUser;
        ArrayList<String> searchResult;

        currentUser = users.get(command.getUsername());
        if (!currentUser.getState().equals(User.UserState.INITIAL)) {
            currentUser.resetSearch();
        }

        searchSong(command, currentUser);
        searchResult = currentUser.getSearchResults();

        return new SearchCommandOutput(command, SearchCommandOutput.Result.DEFAULT,
                Integer.toString(searchResult.size()),
                searchResult);
    }

    @Override
    public CommandOutput visit(PodcastSearchCommandInput command) {
        User currentUser;
        ArrayList<String> searchResult;

        currentUser = users.get(command.getUsername());
        if (!currentUser.getState().equals(User.UserState.INITIAL)) {
            currentUser.resetSearch();
        }

        podcastSearch(command, currentUser);
        searchResult = currentUser.getSearchResults();

        return new SearchCommandOutput(command,
                SearchCommandOutput.Result.DEFAULT,
                Integer.toString(searchResult.size()),
                searchResult);
    }

    @Override
    public CommandOutput visit(PlaylistSearchCommandInput command) {
        User currentUser;
        ArrayList<String> searchResult;

        currentUser = users.get(command.getUsername());
        if (!currentUser.getState().equals(User.UserState.INITIAL)) {
            currentUser.resetSearch();
        }

        playlistSearch(command, currentUser);
        searchResult = currentUser.getSearchResults();

        return new SearchCommandOutput(command,
                SearchCommandOutput.Result.DEFAULT,
                Integer.toString(searchResult.size()),
                searchResult);
    }

    @Override
    public CommandOutput visit(SearchCommandInput command) {
        switch (command.getType()) {
            case "song":
                return visit(new SongSearchCommandInput(command));
            case "podcast":
                return visit(new PodcastSearchCommandInput(command));
            case "playlist":
                return visit(new PlaylistSearchCommandInput(command));
        }

        return null;
    }

    @Override
    public CommandOutput visit(SelectCommandInput command) {
        User currentUser;
        SelectCommandOutput.Result result;

        currentUser = users.get(command.getUsername());
        result = currentUser.selectSearchResult(command.getItemNumber() - 1);

        if (!result.equals(SelectCommandOutput.Result.SUCCESS)) {
            return new SelectCommandOutput(command, result, null);
        }

        return new SelectCommandOutput(command, result, currentUser.getCurrentAudioFile().getName());
    }
}
