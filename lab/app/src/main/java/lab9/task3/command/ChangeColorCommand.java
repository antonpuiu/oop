package lab9.task3.command;

import lab9.task3.diagram.DiagramCanvas;

public class ChangeColorCommand implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int id;
    private String color;
    private String oldColor;

    public ChangeColorCommand(DiagramCanvas diagramCanvas, int id, String color) {
        this.diagramCanvas = diagramCanvas;
        this.id = id;
        this.color = color;

        oldColor = diagramCanvas.getComponent(id).getColor();
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(id).setColor(color);
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(id).setColor(oldColor);
    }

    @Override
    public String toString() {
        return "ChangeColorCommand [diagramCanvas=" + diagramCanvas + ", id=" + id + ", color=" + color + "]";
    }
}
