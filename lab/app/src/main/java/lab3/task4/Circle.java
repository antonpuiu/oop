package lab3.task4;

class Circle extends Form {
    private float radius;

    Circle() {
        this("white", 0);
    }

    Circle(String color, float radius) {
        super(color);

        this.radius = radius;
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
