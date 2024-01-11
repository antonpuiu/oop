package lab6.task3;

import java.time.Year;
import java.util.ArrayList;
import java.util.Random;

import lab6.task1.Car;
import lab6.task1.Offer;

public class Dealership {
    public static final Random GENERATOR = new Random(20);

    private void applyOffer(Car car, Offer offer) {
        System.out.printf("Applying %s discount: %d euros\n",
                              offer.getOfferType(),
                              offer.getDiscount(car));

        car.setPrice(car.getPrice() - offer.getDiscount(car));
    }

    public int getFinalPrice(Car car) {
        ArrayList<Offer> offers = new ArrayList<>() {{
                add(new BrandOffer());
                add(new DealerOffer());
                add(new SpecialOffer());
            }};

        for (Offer offer : offers) {
            applyOffer(car, offer);
        }

        return car.getPrice();
    }

    public void negotiate(Car car, Offer offer) {
        applyOffer(car, offer);
    }

    private class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            switch (car.getType()) {
                case FIAT:
                    return (int)(car.getPrice() * 0.1);
                case MERCEDES:
                    return (int)(car.getPrice() * 0.05);
                case SKODA:
                    return (int)(car.getPrice() * 0.15);
            }

            return 0;
        }

        @Override
        public String getOfferType() {
            return "brand";
        }
    }

    private class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            switch (car.getType()) {
                case FIAT:
                    return (Year.now().getValue() - car.getYear()) * 100;
                case MERCEDES:
                    return (Year.now().getValue() - car.getYear()) * 300;
                case SKODA:
                    return (Year.now().getValue() - car.getYear()) * 150;
            }

            return 0;
        }

        @Override
        public String getOfferType() {
            return "dealer";
        }
    }

    private class SpecialOffer implements Offer {
        private int discount;

        SpecialOffer() {
            discount = GENERATOR.nextInt(1000);
        }

        @Override
        public int getDiscount(Car car) {
            return discount;
        }

        @Override
        public String getOfferType() {
            return "special";
        }
    }
}
