package lab6.task4;

import lab6.task1.Car;

import utils.MainTask;

import java.util.List;
import java.util.ArrayList;

import java.util.stream.Collectors;

public class Main implements MainTask {
    @Override
    public void main() {
        List<Car> cars = new ArrayList<>() {{
                add(new Car(20000, Car.CarType.MERCEDES, 2011));
                add(new Car(35000, Car.CarType.MERCEDES, 2016));
                add(new Car(3500, Car.CarType.FIAT, 2009));
                add(new Car(7000, Car.CarType.FIAT, 2011));
                add(new Car(12000, Car.CarType.SKODA, 2016));
                add(new Car(25000, Car.CarType.SKODA, 2022));
            }};

        System.out.println("Before filtering");
        for (Car car : cars) {
            System.out.println(car);
        }

        cars = cars.stream()
            .filter((car) -> car.getPrice() < 25000)
            .collect(Collectors.toList());

        System.out.println("After filtering");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public int getId() {
        return 4;
    }
}
