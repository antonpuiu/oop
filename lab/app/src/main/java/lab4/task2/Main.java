package lab4.task2;

import utils.*;

import java.util.*;

class Helpers {
    public static final String TOYOTA = "Toyota";
    public static final String HONDA = "Honda";
    public static final String FORD = "Ford";
    public static final String CHEVROLET = "Chevrolet";
    public static final String BMW = "BMW";
    public static final String MERCEDES_BENZ = "Mercedes-Benz";
    public static final String AUDI = "Audi";
    public static final String VOLKSWAGEN = "Volkswagen";
    public static final String NISSAN = "Nissan";
    public static final String HYUNDAI = "Hyundai";
    public static final String KIA = "Kia";
    public static final String MAZDA = "Mazda";
    public static final String SUBARU = "Subaru";
    public static final String JEEP = "Jeep";
    public static final String RAM = "Ram";
    public static final String GMC = "GMC";
    public static final String LEXUS = "Lexus";
    public static final String ACURA = "Acura";
    public static final String INFINITI = "Infiniti";

    public static void addSellers() {
        Database.getDatabase().addSellers(Arrays.asList(
                new Seller("AutoRomânia", Arrays.asList(TOYOTA, HONDA, FORD)),
                new Seller("AutoLux", Arrays.asList(CHEVROLET, BMW, MERCEDES_BENZ)),
                new Seller("Mașini de Vis", Arrays.asList(AUDI, VOLKSWAGEN, NISSAN)),
                new Seller("AutoCity", Arrays.asList(HYUNDAI, KIA, MAZDA)),
                new Seller("Drumuri Off-Road", Arrays.asList(SUBARU, JEEP, RAM)),
                new Seller("Grup AutoElite", Arrays.asList(GMC, LEXUS, ACURA)),
                new Seller("AutoInfinit", Arrays.asList(INFINITI, TOYOTA, HONDA)),
                new Seller("AutoViteză", Arrays.asList(FORD, CHEVROLET, BMW)),
                new Seller("Mașini de Lux", Arrays.asList(MERCEDES_BENZ, AUDI, VOLKSWAGEN)),
                new Seller("Vânzări AutoExpress", Arrays.asList(NISSAN, HYUNDAI, KIA))));
    }

    public static void addDealerships() {
        Database.getDatabase().addDealerships(Arrays.asList(
                new Dealership("Dealer AutoRomânia", Map.of(
                        HONDA, 22000,
                        CHEVROLET, 18000,
                        BMW, 31000,
                        MERCEDES_BENZ, 36000,
                        AUDI, 16000)),
                new Dealership("Dealer AutoLux", Map.of(
                        VOLKSWAGEN, 24000,
                        NISSAN, 19000,
                        HYUNDAI, 33000,
                        KIA, 37000,
                        JEEP, 16500)),
                new Dealership("Dealer AutoVision", Map.of(
                        LEXUS, 23000,
                        ACURA, 19500,
                        INFINITI, 32000,
                        GMC, 37000,
                        RAM, 16000)),
                new Dealership("Dealer AutoElite", Map.of(
                        TOYOTA, 26000,
                        FORD, 20500,
                        NISSAN, 35000,
                        KIA, 38000,
                        SUBARU, 17500)),
                new Dealership("Dealer AutoVitesse", Map.of(
                        VOLKSWAGEN, 27000,
                        HONDA, 21500,
                        AUDI, 36000,
                        MERCEDES_BENZ, 39000,
                        CHEVROLET, 18000)),
                new Dealership("Dealer AutoFast", Map.of(
                        LEXUS, 28000,
                        NISSAN, 22500,
                        ACURA, 37000,
                        BMW, 40000,
                        INFINITI, 18500)),
                new Dealership("Dealer AutoSpeed", Map.of(
                        GMC, 29000,
                        RAM, 23500,
                        JEEP, 38000,
                        CHEVROLET, 41000,
                        TOYOTA, 19000)),
                new Dealership("Dealer AutoPower", Map.of(
                        SUBARU, 30000,
                        FORD, 24500,
                        TOYOTA, 39000,
                        NISSAN, 42000,
                        KIA, 19500)),
                new Dealership("Dealer AutoRapid", Map.of(
                        ACURA, 31000,
                        INFINITI, 25500,
                        LEXUS, 40000,
                        VOLKSWAGEN, 43000,
                        HONDA, 20000))));
    }
}

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

class Seller {
    private String name;
    private List<String> carBrands = new ArrayList<>();

    public Seller(String name, List<String> carBrands) {
        this.name = name;
        this.carBrands = carBrands;
    }

    public String getName() {
        return name;
    }

    public List<String> getCarBrands() {
        return carBrands;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", carBrands=" + carBrands +
                '}';
    }
}

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

public class Main implements MainTask {
    @Override
    public void main() {
        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        // tests
        Dealership testDealership = Database.getDatabase().getAllDealerships().get(0);
        Seller testSeller = Database.getDatabase().getAllSellers().get(0);

        System.out.println(testDealership.averagePrice());
        System.out.println(testDealership.getPriceForBrand("Chevrolet"));
    }

    @Override
    public int getId() {
        return 2;
    }
}
