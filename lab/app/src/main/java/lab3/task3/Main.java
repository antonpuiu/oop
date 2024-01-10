package lab3.task3;

import utils.*;

class Form {
    private String color;

    Form() {
        this("white");
    }

    Form(String color) {
        this.color = new String(color);
    }

    float getArea()
    {
        return 0;
    }

    @Override
    public String toString() {
        return "This form has the color " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Form))
            return false;

        Form form = (Form) obj;

        return color.equals(form.color);
    }
}

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

public class Main implements MainTask {
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
