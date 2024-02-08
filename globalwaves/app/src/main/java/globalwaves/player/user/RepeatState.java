package globalwaves.player.user;

public enum RepeatState {
    REPEAT("Repeat"),
    NO_REPEAT("No Repeat");

    private String value;

    private RepeatState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
