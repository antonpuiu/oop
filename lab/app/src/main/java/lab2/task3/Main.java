package lab2.task3;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        float[] numbers = {
            0, 1,
            3, 4,
            5, 6,
            1, 2
        };

        Polygon poly = new Polygon(numbers);

        System.out.println("Polygon: " + poly.toString());
    }

    @Override
    public int getId() {
        return 2;
    }
}
