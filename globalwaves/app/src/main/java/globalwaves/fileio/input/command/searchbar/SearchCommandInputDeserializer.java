package globalwaves.fileio.input.command.searchbar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class SearchCommandInputDeserializer extends StdDeserializer<SearchCommandInput> {

    public SearchCommandInputDeserializer() {
        super(SearchCommandInput.class);
    }

    @Override
    public SearchCommandInput deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();
        String type = node.get("type").asText();

        SearchCommandFilter filters = null;

        // Depending on the 'type', create and return the appropriate subclass
        if ("song".equals(type)) {
            String name = Optional.ofNullable(node.get("name")).map(x -> x.asText()).orElse(null);
            String album = Optional.ofNullable(node.get("album")).map(x -> x.asText()).orElse(null);
            ArrayList<String> tags = null;
            String lyrics = Optional.ofNullable(node.get("lyrics")).map(x -> x.asText()).orElse(null);
            String genre = Optional.ofNullable(node.get("genre")).map(x -> x.asText()).orElse(null);
            String releaseYear = Optional.ofNullable(node.get("releaseYear")).map(x -> x.asText()).orElse(null);
            String artist = Optional.ofNullable(node.get("artist")).map(x -> x.asText()).orElse(null);

            JsonNode tagsNode = node.get("tags");

            if (tagsNode != null) {
                tags = new ArrayList<>();

                for (JsonNode tag : tagsNode)
                    tags.add(tag.asText());
            }

            filters = new SongSearchCommandFilter(name, album, tags, lyrics, genre, releaseYear, artist);
        } else if ("podcast".equals(type)) {
            String name = Optional.ofNullable(node.get("name")).map(x -> x.asText()).orElse(null);
            String owner = Optional.ofNullable(node.get("owner")).map(x -> x.asText()).orElse(null);

            filters = new PodcastSearchCommandFilter(name, owner);
        } else if ("playlist".equals(type)) {
            String name = Optional.ofNullable(node.get("name")).map(x -> x.asText()).orElse(null);
            String owner = Optional.ofNullable(node.get("owner")).map(x -> x.asText()).orElse(null);

            filters = new PlaylistSearchCommandFilter();
        } else {
            throw new IOException("Unknown 'type' value: " + type);
        }

        return new SearchCommandInput(type, filters);
    }
}
