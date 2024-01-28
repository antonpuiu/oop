package globalwaves.fileio.input.command;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.CommandVisitor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "command")
@JsonSubTypes({
        /* Library */
        @JsonSubTypes.Type(value = SearchCommandInput.class, name = "search"),
        @JsonSubTypes.Type(value = SelectCommandInput.class, name = "select"),

        /* Player */
        @JsonSubTypes.Type(value = LoadCommandInput.class, name = "load"),
        @JsonSubTypes.Type(value = PlayPauseCommandInput.class, name = "playPause"),
        @JsonSubTypes.Type(value = RepeatCommandInput.class, name = "repeat"),
        @JsonSubTypes.Type(value = ShuffleCommandInput.class, name = "shuffle"),
        @JsonSubTypes.Type(value = ForwardCommandInput.class, name = "forward"),
        @JsonSubTypes.Type(value = BackwardCommandInput.class, name = "backward"),
        @JsonSubTypes.Type(value = LikeCommandInput.class, name = "like"),
        @JsonSubTypes.Type(value = NextCommandInput.class, name = "next"),
        @JsonSubTypes.Type(value = PrevCommandInput.class, name = "prev"),
        @JsonSubTypes.Type(value = AddRemoveInPlaylistCommandInput.class, name = "addRemoveInPlaylist"),
        @JsonSubTypes.Type(value = StatusCommandInput.class, name = "status"),

        /* Playlist */
        @JsonSubTypes.Type(value = CreatePlaylistCommandInput.class, name = "createPlaylist"),
        @JsonSubTypes.Type(value = SwitchVisibilityCommandInput.class, name = "switchVisibility"),
        @JsonSubTypes.Type(value = FollowPlaylistCommandInput.class, name = "follow"),
        @JsonSubTypes.Type(value = ShowPlaylistsCommandInput.class, name = "showPlaylists"),

        /* Users */
        @JsonSubTypes.Type(value = ShowPreferredSongsCommandInput.class, name = "showPreferredSongs"),

        /* General */
        @JsonSubTypes.Type(value = GetTop5SongsCommandInput.class, name = "getTop5Songs"),
        @JsonSubTypes.Type(value = GetTop5PlaylistsCommandInput.class, name = "getTop5Playlists")
})
public abstract class CommandInput {
    private String command;
    private String username;
    private int timestamp;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public abstract CommandOutput accept(CommandVisitor visitor);
}
