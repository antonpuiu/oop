package lab3.task5;

public class Form {
    private String color;

    public Form() {
        this("white");
    }

    public Form(String color) {
        this.color = new String(color);
    }

    public float getArea()
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
