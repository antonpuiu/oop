package lab12.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        OnlineLibrary library = new OnlineLibrary(50.0);
        List<Book> books = new ArrayList<>() {{
                add(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 19.99));
                add(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 14.99));
                add(new Book("1984", "George Orwell", "Dystopian", 24.99));
                add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 12.99));
                add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 29.99));
            }};

        Random generator = new Random();
        int n = generator.nextInt(2, books.size());

        for (int i = 0; i < n; i++) {
            try {
                library.addBook(books.get(i));
                System.out.println("Book " + books.get(i) + " inserted");
            } catch (OnlineLibrary.NoSuchBookException e) {
                System.out.println(e);
            } catch (OnlineLibrary.NotEnoughMoneyException e) {
                System.out.println(e);
            }
        }

        for (int i = 0; i < n; i++) {
            try {
                List<Book> libraryBooks = library.getBooks();

                for (Book book : libraryBooks)
                    for (Book book2 : books)
                        if (!book.equals(book2))
                            library.getBook(book);

            } catch (OnlineLibrary.NoSuchBookException e) {
                System.out.println(e);
            } catch (OnlineLibrary.NotEnoughMoneyException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public int getId() {
        return 2;
    }
}
