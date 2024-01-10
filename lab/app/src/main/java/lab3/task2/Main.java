package lab3.task2;

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

public class Main implements MainTask {
    @Override
    public void main() {
        Form form1 = new Form();
        Form form2 = new Form("blue");

        Triangle triangle1 = new Triangle("red", 4, 3);
        Triangle triangle2 = new Triangle();
        Square square1 = new Square("yellow", 4);
        Square square2 = new Square();
        Circle circle1 = new Circle("green",10);
        Circle circle2 = new Circle();


        System.out.println(form1);
        System.out.println(form2);

        System.out.println(triangle1);
        System.out.println("The Area is: " + triangle1.getArea());
        System.out.println(triangle2);
        System.out.println("The Area is: " + triangle2.getArea());
        System.out.println(square1);
        System.out.println("The Area is: " + square1.getArea());
        System.out.println(square2);
        System.out.println("The Area is: " + square2.getArea());
        System.out.println(circle1);
        System.out.println("The Area is: " + circle1.getArea());
        System.out.println(circle2);
        System.out.println("The Area is: " + circle2.getArea());
    }

    @Override
    public int getId() {
        return 2;
    }
}
