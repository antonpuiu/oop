package globalwaves.fileio.input.command.searchbar;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import globalwaves.fileio.input.command.searchbar.filter.PlaylistSearchCommandFilter;
import globalwaves.fileio.input.command.searchbar.filter.PodcastSearchCommandFilter;
import globalwaves.fileio.input.command.searchbar.filter.SearchCommandFilter;
import globalwaves.fileio.input.command.searchbar.filter.SongSearchCommandFilter;

public final class SearchCommandInputDeserializer extends StdDeserializer<SearchCommandInput> {

    public SearchCommandInputDeserializer() {
        super(SearchCommandInput.class);
    }

    @Override
    public SearchCommandInput deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        SearchCommandInput result = null;
        JsonNode node = new ObjectMapper().readTree(p);
        String type = node.get("type").asText();

        SearchCommandFilter filters = null;

        JsonNode filtersNode = node.get("filters");

        if ("song".equals(type)) {
            String name = filtersNode.has("name") ? filtersNode.get("name").asText() : null;
            String album = filtersNode.has("album") ? filtersNode.get("album").asText() : null;
            ArrayList<String> tags = null;
            String lyrics = filtersNode.has("lyrics") ? filtersNode.get("lyrics").asText() : null;
            String genre = filtersNode.has("genre") ? filtersNode.get("genre").asText() : null;
            String releaseYear = filtersNode.has("releaseYear") ? filtersNode.get("releaseYear").asText() : null;
            String artist = filtersNode.has("artist") ? filtersNode.get("artist").asText() : null;

            JsonNode tagsNode = filtersNode.get("tags");

            if (tagsNode != null) {
                tags = new ArrayList<>();

                for (JsonNode tag : tagsNode)
                    tags.add(tag.asText());
            }

            filters = new SongSearchCommandFilter(name, album, tags, lyrics, genre, releaseYear,
                    artist);
        } else if ("podcast".equals(type)) {
            String name = (filtersNode.get("name") != null) ? filtersNode.get("name").asText() : null;
            String owner = (filtersNode.get("owner") != null) ? filtersNode.get("owner").asText() : null;

            filters = new PodcastSearchCommandFilter(name, owner);
        } else if ("playlist".equals(type)) {
            String name = (filtersNode.get("name") != null) ? filtersNode.get("name").asText() : null;
            String owner = (filtersNode.get("owner") != null) ? filtersNode.get("owner").asText() : null;

            filters = new PlaylistSearchCommandFilter(name, owner);
        } else {
            throw new IOException("Unknown 'type' value: " + type);
        }

        result = new SearchCommandInput("search", type, filters);

        result.setUsername(node.has("username") ? node.get("username").asText() : null);
        result.setTimestamp(node.has("timestamp") ? node.get("timestamp").asInt() : null);

        return result;
    }
}
