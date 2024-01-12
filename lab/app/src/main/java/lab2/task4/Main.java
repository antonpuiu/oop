package lab2.task4;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Book b1 = new Book("Morometii", "Marin Preda", 1955);
        System.out.println(b1);

        Book b2 = new Book("Levantul", "Mircea Cărtărescu", 1990);
        System.out.println(b2);
    }

    @Override
    public int getId() {
        return 4;
    }
}
