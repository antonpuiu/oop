package lab4.task1;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        // tests
        Dealership testDealership = Database.getDatabase().getAllDealerships().get(0);
        Seller testSeller = Database.getDatabase().getAllSellers().get(0);

        System.out.println(testDealership.getName());
        System.out.println(testSeller.getName());

    }

    @Override
    public int getId() {
        return 1;
    }
}
