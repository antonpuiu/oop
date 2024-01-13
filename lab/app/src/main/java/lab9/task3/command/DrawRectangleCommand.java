package lab9.task3.command;

import lab9.task3.diagram.DiagramCanvas;
import lab9.task3.diagram.DiagramComponent;

public class DrawRectangleCommand implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private DiagramComponent diagramComponent;

    public DrawRectangleCommand(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
        diagramComponent = new DiagramComponent();
    }

    @Override
    public void execute() {
        diagramCanvas.addComponent(diagramComponent);
    }

    @Override
    public void undo() {
        diagramCanvas.removeComponent(diagramComponent);
    }

    @Override
    public String toString() {
        return "DrawRectangleCommand [diagramCanvas=" + diagramCanvas + "]";
    }
}
