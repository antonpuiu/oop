package globalwaves.entity;

public class AudioCheckpoint {
    private int checkpoint;

    public AudioCheckpoint() {
        checkpoint = 0;
    }

    public int getCheckpoint() {
        return checkpoint;
    }

    public void addCheckpoint(int qty) {
        checkpoint += qty;
    }
}
