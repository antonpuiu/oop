package lab4.task3;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        // tests
        Seller testSeller = Database.getDatabase().getAllSellers().get(0);

        Seller testSellerCopy = new Seller(testSeller);
        System.out.println(testSeller);
        System.out.println(testSellerCopy);
    }

    @Override
    public int getId() {
        return 3;
    }
}
