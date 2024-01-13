package lab9.task1.interfaces;

import lab9.task1.entities.Person;

public interface TransactionPublisher {
    void createTransaction(Person person);
}
