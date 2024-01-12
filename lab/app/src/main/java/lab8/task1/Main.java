package lab8.task1;

import java.util.Collections;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Collections.sort(lab8.Main.students);

        System.out.println(lab8.Main.students);
    }

    @Override
    public int getId() {
        return 1;
    }
}
