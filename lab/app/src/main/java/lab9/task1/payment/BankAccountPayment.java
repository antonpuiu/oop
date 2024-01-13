package lab9.task1.payment;

import lab9.task1.entities.Person;
import lab9.task1.interfaces.PaymentStrategy;

public class BankAccountPayment implements PaymentStrategy {
    private final Person person;

    public BankAccountPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        System.out.println("Bank account " + person.getIBAN() + " charged with $" + amount);
        person.chargeWith(amount);
    }
}
