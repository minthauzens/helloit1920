import models.Book;
import models.Library;

import java.util.ArrayList;

public class LibraryController {
    public static void main(String[] args) throws Exception {

//        Library library = null;
        Book book1 = null;
        Book book2 = null;
        Book book3 = null;
        try {
//            library = new Library(3);
            book1 = new Book("Shining", "Stephen King", "123131235123");
            book2 = new Book("Foundation", "Isac Asimov", "55623413123");
            book3 = new Book("The Bible", "unknown", "000000001");
        } catch (Exception e) {
            System.err.println("Error happened!");
            System.err.println(e.getMessage());
        }

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        Library library = new Library(books);
        Book shining = library.getBook("Shining");

    }
}
