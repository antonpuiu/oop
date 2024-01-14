package lab3.task5;

public class Triangle extends Form {
    private float height, base;

    public Triangle() {
        this("white", 0, 0);
    }

    public Triangle(String color, float height, float base) {
        super(color);

        this.height = height;
        this.base = base;
    }

    public void printTriangleDimmensions() {
        System.out.println("height: " + height + "\tbase: " + base);
    }

    @Override
    public float getArea() {
        return (height + base) / 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangle))
            return false;

        Triangle triangle = (Triangle) obj;

        return super.equals(triangle) &&
            height == triangle.height &&
            base == triangle.base;
    }
}
