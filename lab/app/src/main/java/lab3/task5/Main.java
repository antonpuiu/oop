package lab3.task5;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Form[] forms = {
            new Square("yellow", 4),
            new Circle("green",10),
            new Triangle("red", 4, 3)
        };

        for (Form form : forms) {
            if (form instanceof Square)
                ((Square)form).printSquareDimmensions();
            else if (form instanceof Circle)
                ((Circle)form).printCircleDimmensions();
            else if (form instanceof Triangle)
                ((Triangle)form).printTriangleDimmensions();
        }
    }

    @Override
    public int getId() {
        return 5;
    }
}
