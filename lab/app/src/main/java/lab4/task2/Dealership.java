package lab4.task2;

import java.util.HashMap;
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
