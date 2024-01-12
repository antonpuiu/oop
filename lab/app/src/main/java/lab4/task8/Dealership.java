package lab4.task8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Dealership {
    private String name;
    private Map<String, Integer> cars;

    public Dealership(Dealership dealership) {
        name = new String(dealership.name);
        cars = new HashMap<>();

        dealership.cars.forEach((k, v) -> cars.put(k, v));
    }

    public Dealership(String name, Map<String, Integer> cars) {
        this.name = name;
        this.cars = cars;
    }

    public double averagePrice() {
        int n = 0;
        int price = 0;

        for (Integer carPrice : cars.values()) {
            n++;
            price += carPrice;
        }

        return price / n;
    }

    public int getPriceForBrand(String brand) {
        if (!cars.containsKey(brand))
            return 0;

        return cars.get(brand);
    }

    public List<Seller> getAllSellers() {
        return Collections.unmodifiableList(Database.getDatabase().getAllSellers());
    }

    public List<Dealership> getAllDealerships() {
        return Collections.unmodifiableList(Database.getDatabase().getAllDealerships());
    }

    public List<Dealership> getDealershipsByBrand(String brand) {
        return Collections.unmodifiableList(Database.getDatabase().getDealershipsByBrand(brand));
    }

    public List<Seller> getSellersByBrand(String brand) {
        return Collections.unmodifiableList(Database.getDatabase().getSellersByBrand(brand));
    }

    public List<Dealership> getDealershipsByAveragePrice() {
        return Collections.unmodifiableList(Database.getDatabase().getDealershipsByAveragePrice());
    }

    public List<Dealership> getDealershipsByPriceForBrand(String brand) {
        return Collections.unmodifiableList(Database.getDatabase().getDealershipsByPriceForBrand(brand));
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getCars() {
        return cars;
    }

    public void setName(String name) {
        this.name = name;
    }
}
