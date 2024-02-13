package globalwaves.player.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import globalwaves.entity.Playlist;
import globalwaves.entity.PlaylistOutput;
import globalwaves.fileio.input.command.playlist.CreatePlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.FollowPlaylistCommandInput;
import globalwaves.fileio.input.command.playlist.ShowPlaylistsCommandInput;
import globalwaves.fileio.input.command.playlist.SwitchVisibilityCommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.playlist.CreatePlaylistCommandOutput;
import globalwaves.fileio.output.command.playlist.ShowPlaylistsCommandOutput;
import globalwaves.player.user.UserData;
import globalwaves.visitor.command.PlaylistCommandVisitor;

public class PlaylistComponent extends DefaultComponent implements PlaylistCommandVisitor {
    private List<Playlist> playlists;

    public PlaylistComponent(Map<String, UserData> usersData, List<Playlist> playlists) {
        super(usersData);

        this.playlists = playlists;
    }

    @Override
    public CommandOutput visit(CreatePlaylistCommandInput command) {
        String username = command.getUsername();
        String playlistName = command.getPlaylistName();

        UserData currentUser = usersData.get(username);
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
        UserData currentUserData = usersData.get(command.getUsername());
        List<PlaylistOutput> result = new ArrayList<>();

        for (Playlist playlist : currentUserData.getPlaylists()) {
            result.add(new PlaylistOutput(playlist.getName(),
                    playlist.getAudioFiles()
                            .stream()
                            .map(song -> (song.getName()))
                            .toList(),
                    playlist.isRestricted() ? "private" : "public",
                    playlist.getFollowers()));
        }

        return new ShowPlaylistsCommandOutput(command, result);
    }
}
