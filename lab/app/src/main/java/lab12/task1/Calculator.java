package lab12.task1;

import java.util.Collection;

public interface Calculator {
    class NullParameterException extends RuntimeException {
        public NullParameterException() {
            super("Null parameter");
        }
    }

    class UnderflowException extends RuntimeException {
        public UnderflowException() {
            super("Underflow");
        }
    }

    class OverflowException extends RuntimeException {
        public OverflowException() {
            super("Overflow");
        }
    }

    Double add(Double nr1, Double nr2);

    Double divide(Double nr1, Double nr2);

    Double average(Collection<Double> numbers);
}
