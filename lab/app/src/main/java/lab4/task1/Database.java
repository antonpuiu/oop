package lab4.task1;

import java.util.ArrayList;
import java.util.List;

class Database {
    private final List<Seller> sellers;
    private final List<Dealership> dealerships;

    private static Database instance = null;

    private Database() {
        sellers = new ArrayList<>();
        dealerships = new ArrayList<>();
    }

    public static Database getDatabase() {
        if (instance == null)
            instance = new Database();

        return instance;
    }

    public List<Seller> getAllSellers() {
        return sellers;
    }

    public List<Dealership> getAllDealerships() {
        return dealerships;
    }

    public void addSellers(List<Seller> sellers) {
        this.sellers.addAll(sellers);
    }

    public void addDealerships(List<Dealership> dealerships) {
        this.dealerships.addAll(dealerships);
    }

    @Override
    public String toString() {
        return "Database{" +
                "sellers=" + sellers +
                ", dealerships=" + dealerships +
                '}';
    }
}
