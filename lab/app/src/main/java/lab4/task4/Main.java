package lab4.task4;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        for (Dealership dealership : Database.getDatabase().getAllDealerships())
            System.out.println(dealership.getName());

        System.out.println("------------------------------");

        for (Seller seller : Database.getDatabase().getAllSellers())
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : Database.getDatabase().getDealershipsByBrand("Honda"))
            System.out.println(dealership.getName());

        System.out.println("------------------------------");

        for (Seller seller : Database.getDatabase().getSellersByBrand("Toyota"))
            System.out.println(seller.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : Database.getDatabase().getDealershipsByAveragePrice())
            System.out.println(dealership.getName());

        System.out.println("------------------------------");

        for (Dealership dealership : Database.getDatabase().getDealershipsByPriceForBrand("Lexus"))
            System.out.println(dealership.getName());
    }

    @Override
    public int getId() {
        return 4;
    }
}
