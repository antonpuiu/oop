package lab6.task1;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Car mercedes = new Car(20000, Car.CarType.MERCEDES, 2019);
        System.out.println(mercedes);

        Car fiat = new Car(7000, Car.CarType.FIAT, 2020);
        System.out.println(fiat);

        Car skoda = new Car(12000, Car.CarType.SKODA, 2022);
        System.out.println(skoda);

        Dealership dealership = new Dealership();
        System.out.println(dealership);
    }

    @Override
    public int getId() {
        return 1;
    }
}
