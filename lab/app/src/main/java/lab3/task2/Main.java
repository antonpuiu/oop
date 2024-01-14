package lab3.task2;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
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
