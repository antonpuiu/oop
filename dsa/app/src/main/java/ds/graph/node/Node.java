package ds.graph.node;

import ds.graph.node.visitor.NodeVisitor;

public abstract class Node<DataType, IndexType> {
    protected DataType data;
    protected IndexType index;
    protected NodeColor color;

    public Node(DataType data, IndexType index) {
        this.data = data;
        this.index = index;
        color = NodeColor.WHITE;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }

    public IndexType getIndex() {
        return index;
    }

    public abstract void accept(NodeVisitor<DataType, IndexType> visitor);

    public enum NodeColor {
        WHITE,
        GRAY,
        BLACK
    }
}
