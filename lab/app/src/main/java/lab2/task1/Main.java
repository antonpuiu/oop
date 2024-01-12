package lab2.task1;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Complex[] numbers = {
            new Complex(0, 0),
            new Complex(1, 1),
            new Complex(1, -1)
        };

        for (Complex number : numbers)
            number.showNumber();

        numbers[0].addWithComplex(numbers[1]);
    }

    @Override
    public int getId() {
        return 1;
    }
}
