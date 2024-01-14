package lab12.task1;

import java.util.Arrays;
import java.util.List;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Calculator calculator = new SimpleCalculator();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(List.of(1d, 2d, 3d, 4d)));

        // TODO: Test edge cases that would throw exceptions
        try {
            System.out.println(calculator.add(Double.MAX_VALUE, Double.MAX_VALUE - 500d));
            System.out.println(calculator.add(Double.MIN_VALUE, 0d));            System.out.println(calculator.average(Arrays.asList(10d, 15d, null, 0d)));
            System.out.println(calculator.divide(10d, 5d));
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    @Override
    public int getId() {
        return 1;
    }
}
