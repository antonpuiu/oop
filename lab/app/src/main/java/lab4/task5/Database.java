package lab4.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public List<Dealership> getDealershipsByBrand(String brand) {
        List<Dealership> result = new ArrayList<Dealership>();

        for (Dealership dealership : dealerships)
            if (dealership.getCars().keySet().contains(brand))
                result.add(dealership);

        return result;
    }

    public List<Seller> getSellersByBrand(String brand) {
        List<Seller> result = new ArrayList<>();

        for (Seller seller : sellers)
            if (seller.getCarBrands().contains(brand))
                result.add(seller);

        return result;
    }

    public List<Dealership> getDealershipsByAveragePrice() {
        List<Dealership> result = new ArrayList<>(dealerships);

        Collections.sort(result, new Comparator<Dealership>() {
            @Override
            public int compare(Dealership arg0, Dealership arg1) {
                if (arg0.averagePrice() == arg1.averagePrice())
                    return 0;
                else if (arg0.averagePrice() > arg1.averagePrice())
                    return 1;

                return -1;
            }
        });

        return result;
    }

    public List<Dealership> getDealershipsByPriceForBrand(String brand) {
        List<Dealership> result = getDealershipsByBrand(brand);

        Collections.sort(result, new Comparator<Dealership>() {
            @Override
            public int compare(Dealership arg0, Dealership arg1) {
                if (arg0.getPriceForBrand(brand) == arg1.getPriceForBrand(brand))
                    return 0;
                else if (arg0.getPriceForBrand(brand) > arg1.getPriceForBrand(brand))
                    return 1;

                return -1;
            }
        });

        return result;
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
