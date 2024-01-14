package lab3.task5;

public class Square extends Form {
    private float side;

    public Square() {
        this("white", 0);
    }

    public Square(String color, float side) {
        super(color);

        this.side = side;
    }

    public void printSquareDimmensions() {
        System.out.println("side: " + side);
    }

    @Override
    public float getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
