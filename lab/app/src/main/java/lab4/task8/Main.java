package lab4.task8;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        Dealership testDealership = Database.getDatabase().getAllDealerships().get(0);

        try {
            // testing immutability for Dealership
            testDealership.getAllDealerships().get(0).setName("New Dealership");

            // it should throw an error if getAllDealerships() from Dealership is completely
            // immutable
            testDealership.getAllDealerships().add(new Dealership(testDealership));
        } catch (Exception e) {
            System.out.println("Dealership immutability test passed!");
        }
    }

    @Override
    public int getId() {
        return 8;
    }
}
