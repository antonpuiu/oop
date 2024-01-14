package lab12.task1;

import java.util.Collection;

public class SimpleCalculator implements Calculator {
    @Override
    public Double add(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null)
            throw new Calculator.NullParameterException();

        double result = (double)nr1 + (double)nr2;

        if ((result < nr1 && nr1 > 0) && (result < nr2 && nr2 > 0))
            throw new Calculator.OverflowException();
        if ((result > nr1 && nr1 < 0) && (result > nr2 && nr2 < 0))
            throw new Calculator.UnderflowException();

        return result;
    }

    @Override
    public Double average(Collection<Double> numbers) {
        if (numbers == null)
            throw new Calculator.NullParameterException();

        numbers.forEach((number) -> {
                if (number == null)
                    throw new Calculator.NullParameterException();
            });

        return numbers.stream().reduce(0d, (a, b) -> a + b) / numbers.size();
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null)
            throw new Calculator.NullParameterException();

        return nr1 / nr2;
    }
}
