package lab9.task1.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lab9.task1.interfaces.TransactionPublisher;
import lab9.task1.payment.RandomPaymentFactory;

public class Shop implements TransactionPublisher {
    private final Random priceGenerator = new Random(56);
    private final RandomPaymentFactory paymentFactory = new RandomPaymentFactory();
    private final ArrayList<Person> customers = new ArrayList<>();

    public void addCustomers(List<Person> customers) {
        this.customers.addAll(customers);
    }

    public ArrayList<Person> getCustomers() {
        return customers;
    }

    @Override
    public void createTransaction(Person person) {
        person.payBy(paymentFactory.getPaymentMethod(person), priceGenerator.nextInt(100));

        if (person.getBalance() <= person.getLimit())
            person.update();
    }
}
