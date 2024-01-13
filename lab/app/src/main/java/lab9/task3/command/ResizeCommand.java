package lab9.task3.command;

import lab9.task3.diagram.DiagramCanvas;
import lab9.task3.diagram.DiagramComponent;

public class ResizeCommand implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int id;
    private double percentage;
    private int oldHeight;
    private int oldWidth;

    public ResizeCommand(DiagramCanvas diagramCanvas, int id, double percentage) {
        this.diagramCanvas = diagramCanvas;
        this.id = id;
        this.percentage = percentage;

        oldHeight = diagramCanvas.getComponent(id).getHeight();
        oldWidth = diagramCanvas.getComponent(id).getWidth();
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);

        diagramComponent.setHeight((int)(diagramComponent.getHeight() * percentage / 100));
        diagramComponent.setWidth((int)(diagramComponent.getWidth() * percentage / 100));
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(id);

        diagramComponent.setHeight(oldHeight);
        diagramComponent.setWidth(oldWidth);
    }

    @Override
    public String toString() {
        return "ResizeCommand [diagramCanvas=" + diagramCanvas + ", id=" + id + ", percentage=" + percentage + "]";
    }
}
