package lab9.task1.entities;

import lab9.task1.interfaces.BalanceObserver;
import lab9.task1.interfaces.PaymentStrategy;

public class Person implements BalanceObserver {
    private String IBAN;
    private String cardNumber;
    private String name;
    private String surname;
    private Integer balance;
    private Integer limit;

    public Person(String IBAN, String cardNumber, String name, String surname, Integer balance, Integer limit) {
        this.IBAN = IBAN;
        this.cardNumber = cardNumber;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.limit = limit;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getLimit() {
        return limit;
    }

    public void chargeWith(Integer amount) {
        balance -= amount;
    }

    @Override
    public void update() {
        if (balance < limit)
            System.out.println(name + " " + surname + " has exceeded the limit $" + limit);
    }

    public boolean payBy(PaymentStrategy strategy, Integer amount) {
        if (balance < amount) {
            System.out.println("Insufficient founds");

            return false;
        }

        strategy.pay(amount);

        return true;
    }
}
