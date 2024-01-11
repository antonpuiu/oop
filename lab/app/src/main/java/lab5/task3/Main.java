package lab5.task3;

import utils.MainTask;

public class Main implements MainTask {
    @Override
    public void main() {
        Operation op = new Operation(13.5f);

        op.div(0.f);
        op.div(1.f);

        System.out.println(op.getNumber());  // 13.5

        op.mult(2.f);

        System.out.println(op.getNumber());  // 27

        op.minus(3.f);

        System.out.println(op.getNumber());  // 24

        op.plus(7.f);

        System.out.println(op.getNumber());  // 31
    }

    @Override
    public int getId() {
        return 3;
    }
}
