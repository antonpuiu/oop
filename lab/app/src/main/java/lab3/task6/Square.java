package lab3.task6;

class Square extends Form {
    private float side;

    Square() {
        this("white", 0);
    }

    Square(String color, float side) {
        super(color);

        this.side = side;
    }

    public void printSquareDimmensions() {
        System.out.println("side: " + side);
    }

    @Override
    public void printDimmensions() {
        printSquareDimmensions();
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
