package globalwaves.fileio.input.command.player;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public final class LoadCommandInput extends CommandInput {
    public LoadCommandInput() {
        super("load");
    }

    @Override
    public CommandOutput accept(final CommandVisitor visitor) {
        return visitor.visit(this);
    }
}
