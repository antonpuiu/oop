package globalwaves.fileio.input.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.CommandVisitor;

public class LikeCommandInput extends CommandInput {
    @Override
    public CommandOutput accept(CommandVisitor visitor) {
        return visitor.visit(this);
    }
}
