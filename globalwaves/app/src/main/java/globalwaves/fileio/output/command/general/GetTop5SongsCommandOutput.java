package globalwaves.fileio.output.command.general;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.fileio.output.command.CommandResult;

public class GetTop5SongsCommandOutput extends CommandOutput {
    public GetTop5SongsCommandOutput(CommandInput inputCommand) {
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
