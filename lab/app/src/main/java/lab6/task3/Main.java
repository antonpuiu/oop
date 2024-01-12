package lab6.task3;

import lab6.task1.Car;
import lab6.task1.Offer;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Car mercedes = new Car(20000, Car.CarType.MERCEDES, 2020);
        Dealership dealership = new Dealership();

        dealership.negotiate(mercedes, new Offer() {
                @Override
                public int getDiscount(Car car) {
                    return (int)(car.getPrice() * 0.05);
                }

                @Override
                public String getOfferType() {
                    return "negotiation";
                }
            });

        System.out.println("Final price for " + mercedes + " " + dealership.getFinalPrice(mercedes));
    }

    @Override
    public int getId() {
        return 3;
    }
}
