package lab9.task2;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    private String spacerSymbols = new String(new char[40]).replace("\0", "-");

    @Override
    public void main() {
        House[] houses = {
            new House.HouseBuilder("Dristor", 1, 4).build(),
            new House.HouseBuilder("Piata Romana", 2, 10)
            .pool(true)
            .solarPanels(true)
            .securityCompany("RSR")
            .build(),
            new House.HouseBuilder("Piata Unirii", 3, 10)
            .pool(true)
            .securityCompany("POO_Security")
            .build(),
            new House.HouseBuilder("Primaverii", 3, 15)
            .pool(true)
            .appliances(true)
            .solarPanels(true)
            .securityCompany("BGS")
            .build()
        };

        for (House house : houses) {
            printOutputSpacerFor("testHouse");
            testHouse(house);
            System.out.println(house);
        }
    }

    @Override
    public int getId() {
        return 2;
    }

    private void printOutputSpacerFor(String test) {
        System.out.println(spacerSymbols + test + spacerSymbols);
    }

    private void testHouse(House house) {
        System.out.println(house.getLocation());
        System.out.println(house.getNumFloors());
        System.out.println(house.getNumRooms());
        System.out.println(house.isPool());
        System.out.println(house.getSecurityCompany());
        System.out.println(house.isAppliances());
        System.out.println(house.isSolarPanels());
    }
}
