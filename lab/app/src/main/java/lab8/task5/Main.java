package lab8.task5;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        System.out.println(lab8.Main.numbers);

        LinkedEvenSet linked = new LinkedEvenSet();
        linked.addAll(lab8.Main.numbers);

        EvenSet set = new EvenSet();
        set.addAll(lab8.Main.numbers);

        TreeEvenSet tree = new TreeEvenSet();
        tree.addAll(lab8.Main.numbers);

        System.out.println(linked);
        System.out.println(set);
        System.out.println(tree);
    }

    @Override
    public int getId() {
        return 5;
    }
}
