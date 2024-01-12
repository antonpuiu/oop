package lab3.task6;

import utils.*;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Form[] forms = {
            new Square("yellow", 4),
            new Circle("green",10),
            new Triangle("red", 4, 3)
        };

        for (Form form : forms)
            form.printDimmensions();
    }

    @Override
    public int getId() {
        return 6;
    }
}
