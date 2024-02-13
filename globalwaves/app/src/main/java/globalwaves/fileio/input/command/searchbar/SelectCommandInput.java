package globalwaves.fileio.input.command.searchbar;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.visitor.command.CommandVisitor;

public final class SelectCommandInput extends CommandInput {
    private int itemNumber;

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(final int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public CommandOutput accept(final CommandVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return super.toString() + " SelectCommandInput [itemNumber=" + itemNumber + "]";
    }
}
