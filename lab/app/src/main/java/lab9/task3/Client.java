package lab9.task3;

import lab9.task3.command.ChangeColorCommand;
import lab9.task3.command.ChangeTextCommand;
import lab9.task3.command.CommandType;
import lab9.task3.command.ConnectComponentsCommand;
import lab9.task3.command.DrawCommand;
import lab9.task3.command.DrawRectangleCommand;

import lab9.task3.command.ResizeCommand;
import lab9.task3.diagram.DiagramCanvas;

public class Client {
    private Invoker invoker;
    private DiagramCanvas diagramCanvas;

    Client() {
        invoker = new Invoker();
        diagramCanvas = new DiagramCanvas();
    }

    public void showDiagram() {
        diagramCanvas.show();
    }

    public void newDiagram() {
        diagramCanvas = new DiagramCanvas();
        invoker.restart();
    }

    public void executeAction(String commandName, String ...args) {
        DrawCommand command;

        try {
            CommandType commandType = CommandType.fromString(commandName);

            if (commandType == null)
                throw new IllegalArgumentException();

            command = getCommand(commandType, args);
        } catch(IllegalArgumentException ex) {
            System.out.println("Invalid command: " + commandName);
            System.out.println("Available commands:");
            for (CommandType type : CommandType.values()) {
                System.out.println("\t- " + type.text);
            }
            return;
        }

        invoker.execute(command);
    }

    private DrawCommand getCommand(CommandType type, String ...args) throws IllegalArgumentException {
        try {
            return switch (type) {
                case DRAW_RECTANGLE -> new DrawRectangleCommand(diagramCanvas);
                case RESIZE -> new ResizeCommand(diagramCanvas, Integer.parseInt(args[0]), Double.parseDouble(args[1]));
                case CONNECT -> new ConnectComponentsCommand(diagramCanvas, args[0], args[1]);
                case CHANGE_TEXT -> new ChangeTextCommand(diagramCanvas, Integer.parseInt(args[0]), args[1]);
                case CHANGE_COLOR -> new ChangeColorCommand(diagramCanvas, Integer.parseInt(args[0]), args[1]);
            };
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public void undo(){
        invoker.undo();
    }

    public void redo() {
        invoker.redo();
    }
}
