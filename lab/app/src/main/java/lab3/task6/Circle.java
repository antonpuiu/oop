package lab3.task6;

class Circle extends Form {
    private float radius;

    Circle() {
        this("white", 0);
    }

    Circle(String color, float radius) {
        super(color);

        this.radius = radius;
    }

    public void printCircleDimmensions() {
        System.out.println("radius: " + radius);
    }

    @Override
    public void printDimmensions() {
        printCircleDimmensions();
    }

    @Override
    float getArea() {
        return (float)Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
