/**
 * Paul Felix
 * CEN-3024 - Software Development
 * 01/26/2024
 * Library.java
 * This class will create a book array list when a user wants to add a book to the library, and it will also display
 * the objects on the book list if list has been created.
 */

package LibraryManagementSystem;
import java.util.ArrayList;


class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("List of books in the library:\n");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}