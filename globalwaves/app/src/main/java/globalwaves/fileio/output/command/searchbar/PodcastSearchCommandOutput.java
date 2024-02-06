package globalwaves.fileio.output.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class PodcastSearchCommandOutput extends CommandOutput {
    public PodcastSearchCommandOutput(CommandInput inputCommand) {
        super(inputCommand);
    }

    public enum Result implements CommandResult {
        DEFAULT {
            @Override
            public String getResult(String arg) {
                return null;
            }
        }
    }
}
