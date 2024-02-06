package globalwaves.fileio.output.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.player.MusicPlayerState;

public class StatusCommandOutput extends CommandOutput {
    private MusicPlayerState stats;

    public StatusCommandOutput(CommandInput inputCommand, MusicPlayerState stats) {
        super(inputCommand);

        this.stats = stats;
    }

    public MusicPlayerState getStats() {
        return stats;
    }

    public void setStats(MusicPlayerState stats) {
        this.stats = stats;
    }
}
