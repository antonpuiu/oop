package globalwaves.visitor.command;

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
    CommandOutput visit(LoadCommandInput command);

    CommandOutput visit(PlayPauseCommandInput command);

    CommandOutput visit(RepeatCommandInput command);

    CommandOutput visit(ShuffleCommandInput command);

    CommandOutput visit(ForwardCommandInput command);

    CommandOutput visit(BackwardCommandInput command);

    CommandOutput visit(LikeCommandInput command);

    CommandOutput visit(NextCommandInput command);

    CommandOutput visit(PrevCommandInput command);

    CommandOutput visit(AddRemoveInPlaylistCommandInput command);

    CommandOutput visit(StatusCommandInput command);
}
