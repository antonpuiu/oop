package globalwaves.entity;

public abstract class AudioCheckpoint implements AudioFile {
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

    public void subCheckpoint(int qty) {
        checkpoint -= qty;
    }

    public void setCheckpoint(int checkpoint) {
        this.checkpoint = checkpoint;
    }

    public void resetCheckpoint() {
        checkpoint = 0;
    }
}
