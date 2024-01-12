package lab4.task6;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        Dealership testDealership = Database.getDatabase().getAllDealerships().get(0);

        System.out.println("TESTING DEALERSHIP FUNCTIONALITIES:\n");

        for (Seller seller : testDealership.getAllSellers())
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Seller seller : testDealership.getSellersByBrand("Nissan"))
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Seller seller : testDealership.getSellersByBrand("Kia"))
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : testDealership.getAllDealerships())
            System.out.println(dealership.getName());
    }

    @Override
    public int getId() {
        return 6;
    }
}
