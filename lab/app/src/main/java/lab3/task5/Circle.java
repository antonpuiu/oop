package lab3.task5;

public class Circle extends Form {
    private float radius;

    public Circle() {
        this("white", 0);
    }

    public Circle(String color, float radius) {
        super(color);

        this.radius = radius;
    }

    public void printCircleDimmensions() {
        System.out.println("radius: " + radius);
    }

    @Override
    public float getArea() {
        return (float)Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
