package globalwaves.visitor;

import globalwaves.fileio.input.command.player.AddRemoveInPlaylistCommandInput;
import globalwaves.fileio.input.command.player.BackwardCommandInput;
import globalwaves.fileio.input.command.player.ForwardCommandInput;
import globalwaves.fileio.input.command.player.LikeCommandInput;
import globalwaves.fileio.input.command.player.LoadCommandInput;
import globalwaves.fileio.input.command.player.NextCommandInput;
import globalwaves.fileio.input.command.player.PlayPauseCommandInput;
import globalwaves.fileio.input.command.player.PrevCommandInput;
import globalwaves.fileio.input.command.player.RepeatCommandInput;
import globalwaves.fileio.input.command.player.ShuffleCommandInput;
import globalwaves.fileio.input.command.player.StatusCommandInput;
import globalwaves.fileio.output.command.CommandOutput;

public interface PlayerCommandVisitor {
    public CommandOutput visit(LoadCommandInput command);

    public CommandOutput visit(PlayPauseCommandInput command);

    public CommandOutput visit(RepeatCommandInput command);

    public CommandOutput visit(ShuffleCommandInput command);

    public CommandOutput visit(ForwardCommandInput command);

    public CommandOutput visit(BackwardCommandInput command);

    public CommandOutput visit(LikeCommandInput command);

    public CommandOutput visit(NextCommandInput command);

    public CommandOutput visit(PrevCommandInput command);

    public CommandOutput visit(AddRemoveInPlaylistCommandInput command);

    public CommandOutput visit(StatusCommandInput command);
}
