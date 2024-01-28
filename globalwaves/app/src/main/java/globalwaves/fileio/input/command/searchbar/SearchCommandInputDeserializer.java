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

        JsonNode typeNode = jsonNode.get("type");
        String type = (typeNode != null && !typeNode.isNull()) ? typeNode.asText() : "defaultType";

        if (typeNode == null) {
            System.out.println(jsonNode);
        }

        switch (type) {
            case "song":
                return mapper.readValue(jsonNode.toString(), SongSearchCommandInput.class);
            case "podcast":
                return mapper.readValue(jsonNode.toString(), PodcastSearchCommandInput.class);
            case "playlist":
                return mapper.readValue(jsonNode.toString(), PlaylistSearchCommandInput.class);
            default:
                return null;
        }
    }
}
