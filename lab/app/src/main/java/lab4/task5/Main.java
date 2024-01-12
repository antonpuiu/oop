package lab4.task5;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        Seller testSeller = Database.getDatabase().getAllSellers().get(0);

        System.out.println("TESTING SELLER FUNCTIONALITIES:\n");

        for (Seller seller : testSeller.getAllSellers())
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Seller seller : testSeller.getSellersByBrand("Toyota"))
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Seller seller : testSeller.getSellersByBrand("Mercedes-Benz"))
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : testSeller.getAllDealerships())
            System.out.println(dealership.getName());

        System.out.println("\nTESTING MUTABILITY FOR SELLERS:\n");
        testSeller.getAllDealerships().get(0).setName("New Dealership");

        for (Dealership dealership : testSeller.getAllDealerships())
            System.out.println(dealership.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : testSeller.getDealershipsByBrand("Nissan"))
            System.out.println(dealership.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : testSeller.getDealershipsByAveragePrice())
            System.out.println(dealership.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : testSeller.getDealershipsByPriceForBrand("Kia"))
            System.out.println(dealership.getName());
    }

    @Override
    public int getId() {
        return 5;
    }
}
