package lab4.task7;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        System.out.println(Database.getNumberOfInstances());
    }

    @Override
    public int getId() {
        return 7;
    }
}
