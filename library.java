import java.io.Console;
import java.util.ArrayList;
import java.util.List;

class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(Book book) {
        books.remove(book);
    }

    public void returnBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        Console console = System.console();
        console.writer().println("Books available in the library:");
        for (Book book : books) {
            console.writer().println(book);
        }
    }
}