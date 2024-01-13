package lab9.task1.payment;

import lab9.task1.entities.Person;
import lab9.task1.interfaces.PaymentStrategy;

class CardPayment implements PaymentStrategy {
    private final Person person;

    public CardPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        System.out.println("Card " + person.getCardNumber() + " charged with $" + amount);
        person.chargeWith(amount);
    }
}
