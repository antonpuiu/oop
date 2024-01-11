package lab6.task1;

public class Car {
    private int price;
    private CarType type;
    private int year;

    public Car(int price, CarType type, int year) {
        this.price = price;
        this.type = type;
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public CarType getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car [price=" + price + ", type=" + type + ", year=" + year + "]";
    }

    public enum CarType {
        MERCEDES,
        FIAT,
        SKODA
    }
}
