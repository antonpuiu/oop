package globalwaves.fileio.input.command.searchbar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class SearchCommandInputDeserializer extends StdDeserializer<SearchCommandInput> {

    protected SearchCommandInputDeserializer() {
        super(SearchCommandInput.class);
    }

    @Override
    public SearchCommandInput deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        JsonNode jsonNode = jsonParser.readValueAsTree();

        String type = jsonNode.get("type").asText();

        switch (type) {
            case "song":
                return new SearchCommandInput(type,
                        mapper.readValue(jsonNode.toString(), SongSearchCommandFilter.class));
            case "podcast":
                return new SearchCommandInput(type,
                        mapper.readValue(jsonNode.toString(), PodcastSearchCommandFilter.class));
            case "playlist":
                return new SearchCommandInput(type,
                        mapper.readValue(jsonNode.toString(), PlaylistSearchCommandFilter.class));
            default:
                return null;
        }
    }
}
