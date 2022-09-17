package Week_4;

import java.util.List;

public class Library {
    // Reference to refer to list of books.
    private final List<Book> books;

    // Constructor of this class
    Library(List<Book> books) {
    // This keyword refers to current instance itself
        this.books = books;
    }

    // Getting the list of books
    public List<Book> getListOfBooksInLibrary() {
        return books;
    }
}
