package globalwaves.player;

import java.util.HashMap;
import java.util.Map;

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
import globalwaves.fileio.input.command.users.ShowPreferredSongsCommandInput;
import globalwaves.fileio.input.library.LibraryInput;
import globalwaves.fileio.input.library.UserInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.ResultsCommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public class MusicPlayer implements CommandVisitor {
    private SearchBarComponent searchBarComponent;
    private PlayerComponent playerComponent;
    private PlaylistComponent playlistComponent;
    private UsersComponent usersComponent;
    private GeneralComponent generalComponent;

    public MusicPlayer() {
        searchBarComponent = null;
        playerComponent = null;
        playlistComponent = null;
        generalComponent = null;
    }

    public void loadLibrary(LibraryInput libraryInput) {
        Map<String, User> users = new HashMap<>();

        for (UserInput user : libraryInput.getUsers())
            users.put(user.getUsername(), new User());

        searchBarComponent = new SearchBarComponent(libraryInput, users);
        playerComponent = new PlayerComponent(users);
        playlistComponent = new PlaylistComponent();
        usersComponent = new UsersComponent();
        generalComponent = new GeneralComponent();
    }

    @Override
    public ResultsCommandOutput visit(SearchCommandInput command) {
        return searchBarComponent.visit(command);
    }

    @Override
    public CommandOutput visit(SelectCommandInput command) {
        return searchBarComponent.visit(command);
    }

    @Override
    public CommandOutput visit(LoadCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(PlayPauseCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(RepeatCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(ShuffleCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(ForwardCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(BackwardCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(LikeCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(NextCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(PrevCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(AddRemoveInPlaylistCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(StatusCommandInput command) {
        return playerComponent.visit(command);
    }

    @Override
    public CommandOutput visit(CreatePlaylistCommandInput command) {
        return playlistComponent.visit(command);
    }

    @Override
    public CommandOutput visit(SwitchVisibilityCommandInput command) {
        return playlistComponent.visit(command);
    }

    @Override
    public CommandOutput visit(FollowPlaylistCommandInput command) {
        return playlistComponent.visit(command);
    }

    @Override
    public CommandOutput visit(ShowPlaylistsCommandInput command) {
        return playlistComponent.visit(command);
    }

    @Override
    public CommandOutput visit(ShowPreferredSongsCommandInput command) {
        return usersComponent.visit(command);
    }

    @Override
    public CommandOutput visit(GetTop5SongsCommandInput command) {
        return generalComponent.visit(command);
    }

    @Override
    public CommandOutput visit(GetTop5PlaylistsCommandInput command) {
        return generalComponent.visit(command);
    }
}
