package globalwaves.fileio.input.command.searchbar;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import globalwaves.fileio.input.command.CommandInput;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SongSearchCommandInput.class, name = "song"),
        @JsonSubTypes.Type(value = PodcastSearchCommandInput.class, name = "podcast"),
        @JsonSubTypes.Type(value = PlaylistSearchCommandInput.class, name = "playlist")
})
public abstract class SearchCommandInput extends CommandInput {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
