package lab9.task3;

import java.util.LinkedList;

import lab9.task3.command.DrawCommand;

public class Invoker {
    private LinkedList<DrawCommand> undoCommands = new LinkedList<>();
    private LinkedList<DrawCommand> redoCommands = new LinkedList<>();

    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
        undoCommands.clear();
        redoCommands.clear();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        undoCommands.push(command);
        command.execute();
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        DrawCommand command = undoCommands.pop();

        redoCommands.push(command);
        command.undo();
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        DrawCommand command = redoCommands.pop();

        undoCommands.push(command);
        command.execute();
    }
}
