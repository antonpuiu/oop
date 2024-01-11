package lab5.task3;

public class Operation implements Plus, Minus, Mult, Div {
    private float number;

    public Operation() {
        this(0);
    }

    public Operation(float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    @Override
    public void plus(float value) {
        number += value;
    }

    @Override
    public void minus(float value) {
        number -= value;
    }

    @Override
    public void mult(float value) {
        number *= value;
    }

    @Override
    public void div(float value) {
        if (value == 0.0) {
            System.out.println("Division by 0 is not possible");
            return;
        }

        number /= value;
    }
}
