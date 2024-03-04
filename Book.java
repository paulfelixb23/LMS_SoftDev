/**
 * Paul Felix
 * CEN-3024 - Software Development
 * 01/26/2024
 * Book.java
 * This class represents a book in the library management system. It includes properties for the book's ID, title, and author.
 * The book ID is auto-generated to ensure uniqueness. This class is fundamental in managing books within the library,
 * allowing for operations such as checking out and returning books.
 */

package LibraryManagementSystem;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Constructor for the Book class.
 * Initializes a new Book instance with a unique ID, title, and author.
 */
class Book {
    private static final AtomicInteger idGenerator = new AtomicInteger(1000000);
    public final int book_Id; // Final to ensure immutability once set
    public String title;
    public String author;

    public Book(String title, String author) {
        this.book_Id = idGenerator.getAndIncrement(); // Correctly increment the ID for each instance
        this.title = title;
        this.author = author;
    }

    public int getBook_Id() {
        return book_Id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    /**
     * Checks if the book is currently checked out.
     * return True if the book is checked out, false otherwise.
     */
    private boolean isCheckedOut;

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }

    /**
     * Provides a string representation of the book.
     * Includes the book ID, title, and author in the string.
     * return a string representation of the book.
     */
    @Override
    public String toString() {
        return "Book ID: " + book_Id + ", Title: " + title + ", Author: " + author;
    }

}
