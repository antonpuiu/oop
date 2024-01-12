package lab3.task3;

class Square extends Form {
    private float side;

    Square() {
        this("white", 0);
    }

    Square(String color, float side) {
        super(color);

        this.side = side;
    }

    @Override
    float getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
