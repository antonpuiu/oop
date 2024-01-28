package globalwaves.fileio.input.command.searchbar;

import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.CommandVisitor;

public class PodcastSearchCommandInput extends SearchCommandInput {
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public CommandOutput accept(CommandVisitor visitor) {
        return visitor.visit(this);
    }
}
