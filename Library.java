/**
 * Paul Felix
 * CEN-3024 - Software Development
 * 01/26/2024
 * Library.java
 * This class manages a collection of books in the library. It supports adding books to the library, removing books by ID,
 * checking books in and out, and displaying the current inventory of books. The class plays a crucial role in the
 * library management system, ensuring that operations related to book handling are executed efficiently.
 */

package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.Iterator;

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    /**
     * addBook
     * Adds a book to the library's collection.
     * Method receive an object type book.
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("\n* Book added successfully! *");
    }

    /**
     * removeBookByBarcode
     * Removes a book from the library based on its barcode (ID).
     * Receive the unique barcode (ID) of the book to remove.
     * Return true if the book was successfully removed; false otherwise.
     */
    public boolean removeBookByBarcode(Integer barcode) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            // Correctly call the instance method and compare it with the barcode
            if (book.getBook_Id() == (barcode)) { // Make sure this matches the method name exactly
                iterator.remove(); // Use iterator's remove method to avoid ConcurrentModificationException
                System.out.println("\n* Book removed successfully! *");
                return true;
            }
        }
        return false; // Return false if no book with the specified barcode is found
    }

    /**
     * checkOutBook
     * Checks out a book from the library based on the title. If the book is available, it is marked as checked out.
     * Receive the title of the book to check out.
     * return true if the book was successfully checked out; false otherwise.
     */
    public boolean checkOutBook(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()) {
                book.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }

    /**
     * checkInBook
     * Checks in a book to the library based on the title. If the book is currently checked out, it is marked as available.
     * Receive the title of the book to check in.
     * return true if the book was successfully checked in; false otherwise.
     */
    public boolean checkInBook(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()) {
                book.setCheckedOut(false);
                return true;
            }
        }
        return false;
    }

    /**
     * displayBooks
     * Displays a list of all books in the library, indicating whether they are checked out or available.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("\nNo books available in the library.");
        } else {
            System.out.println("\nList of books in the library:\n");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     * displayCheckedOutBooks
     * Displays a list of all books that are currently checked out from the library.
     */
    public void displayCheckedOutBooks() {
        System.out.println("\nChecked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(book);
            }
        }
    }
}