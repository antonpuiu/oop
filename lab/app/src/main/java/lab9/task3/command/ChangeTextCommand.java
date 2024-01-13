package lab9.task3.command;

import lab9.task3.diagram.DiagramCanvas;

public class ChangeTextCommand implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int id;
    private String text;
    private String oldText;

    public ChangeTextCommand(DiagramCanvas diagramCanvas, int id, String text) {
        this.diagramCanvas = diagramCanvas;
        this.id = id;
        this.text = text;

        oldText = diagramCanvas.getComponent(id).getText();
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(id).setText(text);
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(id).setText(oldText);
    }

    @Override
    public String toString() {
        return "ChangeTextCommand [diagramCanvas=" + diagramCanvas + ", id=" + id + ", text=" + text + "]";
    }
}
