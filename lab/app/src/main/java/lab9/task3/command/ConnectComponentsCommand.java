package lab9.task3.command;

import lab9.task3.diagram.DiagramCanvas;

public class ConnectComponentsCommand implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private String component1, component2;

    public ConnectComponentsCommand(DiagramCanvas diagramCanvas, String component1, String component2) {
        this.diagramCanvas = diagramCanvas;
        this.component1 = component1;
        this.component2 = component2;
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(Integer.parseInt(component1)).connectTo(component2);
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(Integer.parseInt(component1)).removeConnection(component2);
    }

    @Override
    public String toString() {
        return "ConnectComponentsCommand [diagramCanvas=" + diagramCanvas + ", component1=" + component1
                + ", component2=" + component2 + "]";
    }
}
