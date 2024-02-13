package globalwaves.player.user;

import java.util.List;

public enum RepeatState {
    NO_REPEAT("No Repeat"),
    REPEAT_ONCE("Repeat Once"),
    REPEAT_CURRENT_SONG("Repeat Current Song"),
    REPEAT_ALL("Repeat All"),
    REPEAT_INFINITE("Repeat Infinite");

    private String value;

    private RepeatState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<RepeatState> getPlaylistValues() {
        return List.of(NO_REPEAT, REPEAT_ALL, REPEAT_CURRENT_SONG);
    }

    public static List<RepeatState> getLibraryAndPlaylistValues() {
        return List.of(NO_REPEAT, REPEAT_ONCE, REPEAT_INFINITE);
    }
}
