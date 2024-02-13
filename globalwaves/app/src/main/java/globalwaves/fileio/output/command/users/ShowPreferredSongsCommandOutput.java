package globalwaves.fileio.output.command.users;

import java.util.List;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public class ShowPreferredSongsCommandOutput extends CommandOutput {
    public List<String> result;

    public ShowPreferredSongsCommandOutput(CommandInput inputCommand, List<String> result) {
        super(inputCommand);

        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }
}
