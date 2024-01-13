package lab9.task3.diagram;

import java.util.ArrayList;
import java.util.List;

public class DiagramComponent {
    private List<String> connectedComponents = new ArrayList<>();
    private String text = "text";
    private String color = "WHITE";
    private int height = 40;
    private int width = 100;

    public DiagramComponent() {
        connectedComponents = new ArrayList<>();
        text = "text";
        color = "WHITE";
        height = 40;
        width = 100;
    }

    public DiagramComponent(DiagramComponent diagramComponent) {
        connectedComponents = new ArrayList<>(diagramComponent.connectedComponents);
        text = diagramComponent.text;
        color = diagramComponent.color;
        height = diagramComponent.height;
        width = diagramComponent.width;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void connectTo(String componentId) {
        connectedComponents.add(componentId);
    }

    public void removeConnection(String componentId) {
        connectedComponents.remove(componentId);
    }

    @Override
    public String toString() {
        return "DiagramComponent [text=" + text + ", color=" + color + ", height=" + height + ", width=" + width
            + ", connectedComponents=" + connectedComponents + "]";
    }
}
