import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int publicationYear = scanner.nextInt();
                    System.out.print("Enter number of pages: ");
                    int numberOfPages = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    Book newBook = new Book(title, author, publicationYear, numberOfPages);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    library.displayBooks();
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book borrowBook = findBook(library, borrowTitle);
                    if (borrowBook != null) {
                        library.borrowBook(borrowBook);
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;
                case 3:
                    library.displayBooks();
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = findBook(library, returnTitle);
                    if (returnBook != null) {
                        library.returnBook(returnBook);
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Book findBook(Library library, String title) {
        for (Book book : library.books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}