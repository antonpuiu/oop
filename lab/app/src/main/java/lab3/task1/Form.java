package lab3.task1;

public class Form {
    private String color;

    Form() {
        this("white");
    }

    Form(String color) {
        this.color = new String(color);
    }

    float getArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "This form has the color " + color;
    }
}
