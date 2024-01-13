package lab9.task1.payment;

import lab9.task1.entities.Person;
import lab9.task1.interfaces.PaymentStrategy;

public class VoucherPayment implements PaymentStrategy {
    private final Person person;

    public VoucherPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        System.out.println("Voucher Payment for " + person.getName() + " " + person.getSurname() + "of $" + amount);
    }
}
