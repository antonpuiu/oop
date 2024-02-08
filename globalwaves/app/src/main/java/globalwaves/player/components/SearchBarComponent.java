package globalwaves.player.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import globalwaves.entity.AudioFile;
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
import globalwaves.player.user.PlayerState;
import globalwaves.player.user.SourceType;
import globalwaves.player.user.UserData;
import globalwaves.player.user.UserState;
import globalwaves.visitor.command.SearchBarCommandVisitor;

public class SearchBarComponent implements SearchBarCommandVisitor {
    private LibraryInput libraryInput;
    private Map<String, UserData> usersData;
    private List<Playlist> playlists;

    public SearchBarComponent(LibraryInput libraryInput, Map<String, UserData> usersData, List<Playlist> playlists) {
        this.libraryInput = libraryInput;
        this.usersData = usersData;
        this.playlists = playlists;
    }

    private void searchSong(SongSearchCommandInput command, UserData currentUserData) {
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

        audioFiles = audioFilesStream.limit(5).toList();
        currentUserData.setSearchResult(audioFiles, SourceType.LIBRARY);
    }

    private void podcastSearch(PodcastSearchCommandInput command, UserData currentUserData) {
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

        audioFiles = audioFilesStream.limit(5).toList();
        currentUserData.setSearchResult(audioFiles, SourceType.PODCAST);
    }

    private void playlistSearch(PlaylistSearchCommandInput command, UserData currentUserData) {
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

        audioFiles = audioFilesStream.limit(5).toList();
        currentUserData.setSearchResult(audioFiles, SourceType.PLAYLIST);
    }

    @Override
    public CommandOutput visit(SongSearchCommandInput command) {
        UserData currentUserData;
        List<? extends AudioFile> searchResult;
        UserState userState;

        currentUserData = usersData.get(command.getUsername());
        userState = currentUserData.getState();

        if (!userState.equals(UserState.INITIAL)) {
            currentUserData.resetSearchResult();
        }

        searchSong(command, currentUserData);
        searchResult = currentUserData.getSearchResult();

        return new SearchCommandOutput(command, SearchCommandOutput.Result.DEFAULT,
                Integer.toString(searchResult.size()),
                currentUserData.getSearchResult()
                        .stream()
                        .map(song -> (song.getName()))
                        .toList());
    }

    @Override
    public CommandOutput visit(PodcastSearchCommandInput command) {
        UserData currentUserData;
        List<? extends AudioFile> searchResult;

        currentUserData = usersData.get(command.getUsername());
        if (!currentUserData.getState().equals(UserState.INITIAL)) {
            currentUserData.resetSearchResult();
        }

        podcastSearch(command, currentUserData);
        searchResult = currentUserData.getSearchResult();

        return new SearchCommandOutput(command,
                SearchCommandOutput.Result.DEFAULT,
                Integer.toString(searchResult.size()),
                currentUserData.getSearchResult()
                        .stream()
                        .map(song -> (song.getName()))
                        .toList());
    }

    @Override
    public CommandOutput visit(PlaylistSearchCommandInput command) {
        UserData currentUserData;
        List<? extends AudioFile> searchResult;

        currentUserData = usersData.get(command.getUsername());
        if (!currentUserData.getState().equals(UserState.INITIAL)) {
            currentUserData.resetSearchResult();
        }

        playlistSearch(command, currentUserData);
        searchResult = currentUserData.getSearchResult();

        return new SearchCommandOutput(command,
                SearchCommandOutput.Result.DEFAULT,
                Integer.toString(searchResult.size()),
                currentUserData.getSearchResult()
                        .stream()
                        .map(song -> (song.getName()))
                        .toList());
    }

    @Override
    public CommandOutput visit(SearchCommandInput command) {
        UserData currentUserData = usersData.get(command.getUsername());
        UserState currentUserState = currentUserData.getState();
        PlayerState<?> currentPlayerState = currentUserData.getPlayerState();

        if (currentUserState.equals(UserState.AUDIOFILE_LOADED)) {
            currentPlayerState.pausePlayback(command.getTimestamp());
            currentUserData.setState(UserState.INITIAL);
        }

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
        UserData currentUserData = usersData.get(command.getUsername());
        int resultIndex = command.getItemNumber() - 1;

        PlayerState<?> playerState = currentUserData.getPlayerState();
        UserState userState = currentUserData.getState();

        if (!userState.equals(UserState.SEARCH_PERFORMED)) {
            return new SelectCommandOutput(command, SelectCommandOutput.Result.NO_SEARCH, null);
        }

        var searchResult = currentUserData.getSearchResult();

        if (resultIndex >= searchResult.size()) {
            return new SelectCommandOutput(command, SelectCommandOutput.Result.OUT_OF_BOUNDS, null);
        }

        playerState.setNowPlaying(searchResult.get(resultIndex));
        currentUserData.setState(UserState.AUDIOFILE_SELECTED);

        return new SelectCommandOutput(command, SelectCommandOutput.Result.SUCCESS,
                searchResult.get(resultIndex).getName());
    }
}
