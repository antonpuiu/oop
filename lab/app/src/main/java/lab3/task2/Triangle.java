package lab3.task2;

class Triangle extends Form {
    private float height, base;

    Triangle() {
        this("white", 0, 0);
    }

    Triangle(String color, float height, float base) {
        super(color);

        this.height = height;
        this.base = base;
    }

    @Override
    float getArea() {
        return (height + base) / 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
