package globalwaves.player.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import globalwaves.entity.Playlist;
import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.playlist.CreatePlaylistCommandOutput;
import globalwaves.player.User;
import globalwaves.visitor.command.PlaylistCommandVisitor;

public class PlaylistComponent implements PlaylistCommandVisitor {
    private Map<String, User> users;
    private List<Playlist> playlists;

    public PlaylistComponent(Map<String, User> users, List<Playlist> playlists) {
        this.users = users;
        this.playlists = playlists;
    }

    @Override
    public CommandOutput visit(CreatePlaylistCommandInput command) {
        String username = command.getUsername();
        String playlistName = command.getPlaylistName();

        User currentUser = users.get(username);
        ArrayList<Playlist> userPlaylists = currentUser.getPlaylists();

        for (Playlist playlist : userPlaylists) {
            if (playlist.getName().toLowerCase().equals(playlistName.toLowerCase())) {
                return new CreatePlaylistCommandOutput(command, CreatePlaylistCommandOutput.Result.ALREADY_EXISTS);
            }
        }

        Playlist newPlaylist = new Playlist(username, playlistName);

        userPlaylists.add(newPlaylist);
        playlists.add(newPlaylist);

        return new CreatePlaylistCommandOutput(command, CreatePlaylistCommandOutput.Result.SUCCESS);
    }

    @Override
    public CommandOutput visit(SwitchVisibilityCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(FollowPlaylistCommandInput command) {
        return null;
    }

    @Override
    public CommandOutput visit(ShowPlaylistsCommandInput command) {
        return null;
    }
}
