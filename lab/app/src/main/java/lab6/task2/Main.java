package lab6.task2;

import lab6.task1.Car;

import utils.MainTask;

import java.util.List;
import java.util.ArrayList;

public class Main implements MainTask {
    @Override
    public void main() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(20000, Car.CarType.MERCEDES, 2011));
        cars.add(new Car(35000, Car.CarType.MERCEDES, 2016));
        cars.add(new Car(3500, Car.CarType.FIAT, 2009));
        cars.add(new Car(7000, Car.CarType.FIAT, 2011));
        cars.add(new Car(12000, Car.CarType.SKODA, 2016));
        cars.add(new Car(25000, Car.CarType.SKODA, 2022));

        Dealership dealership = new Dealership();

        for (Car car : cars) {
            String carString = car.toString();

            System.out.print("The price for " + carString + " after applying discounts: " + dealership.getFinalPrice(car) + "\n");
        }
    }

    @Override
    public int getId() {
        return 2;
    }
}
