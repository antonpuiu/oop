package lab3.task3;

import utils.*;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Triangle triangle1 = new Triangle("red", 4, 3);
        Triangle triangle3 = new Triangle("yellow", 4, 3);
        Triangle triangle4 = new Triangle("red", 4, 3);

        Square square1 = new Square("yellow", 4);

        System.out.println(triangle1.equals(triangle3));
        System.out.println(triangle1.equals(triangle4));
        System.out.println(triangle1.equals(square1));
    }

    @Override
    public int getId() {
        return 3;
    }
}
