package lab9.task3.diagram;

import java.util.ArrayList;
import java.util.List;

public class DiagramCanvas {
    private List<DiagramComponent> components;

    public DiagramCanvas() {
        components = new ArrayList<>();
    }

    public DiagramCanvas(DiagramCanvas diagramCanvas) {
        components = new ArrayList<>();

        for (DiagramComponent diagramComponent : diagramCanvas.components)
            components.add(new DiagramComponent(diagramComponent));
    }

    public void addComponent(DiagramComponent diagramComponent) {
        components.add(diagramComponent);
    }

    public void removeComponent(DiagramComponent diagramComponent) {
        components.remove(diagramComponent);
    }

    public DiagramComponent getComponent(int id) {
        return components.get(id);
    }

    public void show() {
        System.out.println("Diagram:");
        components.forEach(System.out::println);
    }
}
