package lab2.task1;

import utils.MainTask;

public class Complex implements MainTask {
    private int real;
    private int imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex complex) {
        real = complex.real;
        imaginary = complex.imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void addWithComplex(Complex complex) {
        real = complex.real;
        imaginary = complex.imaginary;
    }

    public void showNumber() {
        if (imaginary == 0)
            System.out.println(real);
        else if (imaginary > 0)
            System.out.printf("%d + i*%d\n", real, imaginary);
        else
            System.out.printf("%d - i*%d\n", real, -imaginary);
    }

    @Override
    public void main() {
        // TODO Auto-generated method stub
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
