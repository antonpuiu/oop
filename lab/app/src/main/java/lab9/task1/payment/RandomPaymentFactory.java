package lab9.task1.payment;

import java.util.Random;

import lab9.task1.entities.Person;
import lab9.task1.interfaces.PaymentStrategy;

public class RandomPaymentFactory {
    private enum PaymentType { CARD, IBAN, VOUCHER }
    private static final Random random = new Random(1234565);

    public PaymentStrategy getPaymentMethod(Person person) {
        return switch (PaymentType.values()[random.nextInt(3)]) {
            case CARD -> new CardPayment(person);
            case IBAN -> new BankAccountPayment(person);
            case VOUCHER  -> new VoucherPayment(person);
        };
    }
}
