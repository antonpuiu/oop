package globalwaves.player.components;

import java.util.List;
import java.util.Map;

import globalwaves.entity.Playlist;
import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.playlist.CreatePlaylistCommandOutput;
import globalwaves.player.user.UserData;
import globalwaves.visitor.command.PlaylistCommandVisitor;

public class PlaylistComponent implements PlaylistCommandVisitor {
    private Map<String, UserData> users;
    private List<Playlist> playlists;

    public PlaylistComponent(Map<String, UserData> users, List<Playlist> playlists) {
        this.users = users;
        this.playlists = playlists;
    }

    @Override
    public CommandOutput visit(CreatePlaylistCommandInput command) {
        String username = command.getUsername();
        String playlistName = command.getPlaylistName();

        UserData currentUser = users.get(username);
        List<Playlist> userPlaylists = currentUser.getPlaylists();

        for (Playlist playlist : userPlaylists) {
            if (playlist.getName().toLowerCase().equals(playlistName.toLowerCase())) {
                return new CreatePlaylistCommandOutput(command, CreatePlaylistCommandOutput.Result.ALREADY_EXISTS);
            }
        }

        Playlist newPlaylist = new Playlist(playlistName, username);

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
