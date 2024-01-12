package lab3.task6;

abstract class Form {
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

    public abstract void printDimmensions();

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
