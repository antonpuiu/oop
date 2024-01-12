package lab3.task5;

import java.util.ArrayList;

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

    public void printTriangleDimmensions() {
        System.out.println("height: " + height + "\tbase: " + base);
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

    public void printSquareDimmensions() {
        System.out.println("side: " + side);
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
    float getArea() {
        return (float)Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Form[] forms = {
            new Square("yellow", 4),
            new Circle("green",10),
            new Triangle("red", 4, 3)
        };

        for (Form form : forms) {
            if (form instanceof Square)
                ((Square)form).printSquareDimmensions();
            else if (form instanceof Circle)
                ((Circle)form).printCircleDimmensions();
            else if (form instanceof Triangle)
                ((Triangle)form).printTriangleDimmensions();
        }
    }

    @Override
    public int getId() {
        return 5;
    }
}
