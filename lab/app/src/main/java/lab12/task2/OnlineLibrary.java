package lab12.task2;

import java.util.ArrayList;
import java.util.List;

public class OnlineLibrary {
    private List<Book> books;
    private double budget;

    public OnlineLibrary(double budget) {
        books = new ArrayList<>();
        this.budget = budget;
    }

    public void addBook(Book book) {
        if (budget < book.getPrice())
            throw new NotEnoughMoneyException();

        budget -= book.getPrice();
        books.add(book);
    }

    public void getBook(Book book) {
        if (!books.contains(book))
            throw new NoSuchBookException(book);

        budget += book.getPrice();
        books.remove(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public class NotEnoughMoneyException extends RuntimeException {
        public NotEnoughMoneyException() {
            super("Insufficient founds");
        }
    }

    public class NoSuchBookException extends RuntimeException {
        public NoSuchBookException(Book book) {
            super(book + " not found in library");
        }
    }
}
