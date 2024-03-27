import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Console console = System.console();

        if (console == null) {
            System.err.println("No se puede acceder a la consola.");
            System.exit(1);
        }

        while (true) {
            console.writer().println("Sistema de gestión de biblioteca");
            console.writer().println("1. Añadir un libro");
            console.writer().println("2. Prestar un libro");
            console.writer().println("3. Devolver un libro");
            console.writer().println("4. Mostrar todos los libros");
            console.writer().println("5. Salir");

            console.writer().println("Ingrese su elección: ");
            int choice = Integer.parseInt(console.readLine());

            switch (choice) {
                case 1:
                    console.writer().println("Ingrese el Id: ");
                    int Id = Integer.parseInt(console.readLine());
                    console.writer().println("Ingrese el titulo: ");
                    String title = console.readLine();
                    console.writer().println("Ingrese el autor: ");
                    String author = console.readLine();
                    console.writer().println("Ingrese año de la publicacion: ");
                    int publicationYear = Integer.parseInt(console.readLine());
                    console.writer().println("Ingrese el numero de paginas: ");
                    int numberOfPages = Integer.parseInt(console.readLine());
                    Book newBook = new Book(Id, title, author, publicationYear, numberOfPages);
                    library.addBook(newBook);
                    console.writer().println("El libro se ha añadido exitosamente.");
                    break;
                case 2:
                    library.displayBooks();
                    console.writer().println("Introduce el título del libro a pedir prestado.: ");
                    String borrowTitle = console.readLine();
                    Book borrowBook = findBook(library, borrowTitle);
                    if (borrowBook != null) {
                        library.borrowBook(borrowBook);
                        console.writer().println("Libro prestado con éxito.");
                    } else {
                        console.writer().println("Libro no encontrado en la biblioteca..");
                    }
                    break;
                case 3:
                    library.displayBooks();
                    console.writer().println("Introduce el título del libro a devolver.: ");
                    String returnTitle = console.readLine();
                    Book returnBook = findBook(library, returnTitle);
                    if (returnBook != null) {
                        library.returnBook(returnBook);
                        console.writer().println("Libro devuelto exitosamente.");
                    } else {
                        console.writer().println("Libro no encontrado en la biblioteca..");
                    }
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    console.writer().println("Saliendo del programa.");
                    System.exit(0);
                default:
                    console.writer().println("Elección no válida. Inténtalo de nuevo.");
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