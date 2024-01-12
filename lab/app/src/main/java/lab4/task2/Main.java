package lab4.task2;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        // tests
        Dealership testDealership = Database.getDatabase().getAllDealerships().get(0);

        System.out.println(testDealership.averagePrice());
        System.out.println(testDealership.getPriceForBrand("Chevrolet"));
    }

    @Override
    public int getId() {
        return 2;
    }
}
