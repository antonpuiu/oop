package globalwaves.fileio.input.command.general;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.CommandVisitor;

public class GetTop5PlaylistsCommandInput extends CommandInput {
    @Override
    public CommandOutput accept(CommandVisitor visitor) {
        return visitor.visit(this);
    }
}
