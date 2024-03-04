/**
 * Paul Felix
 * CEN-3024 - Software Development
 * 01/26/2024
 * LibraryManagementSystem.java
 * This application serves as the main entry point for the library management system. It features a menu-driven interface
 * that allows users to interact with the system, including adding new books, loading books from files, removing books by ID,
 * displaying all books, checking books in and out, and exiting the program. This class orchestrates the overall
 * functionality of the system, ensuring a smooth user experience.
 */

package LibraryManagementSystem;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        // Display interface for user to select action.
        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Insert File");
            System.out.println("3. Remove Book");
            System.out.println("4. Display Books");
            System.out.println("5. Check Out Book");
            System.out.println("6. Check In Book");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");
            

            int choice = scanner.nextInt();
            
            //User selects action on the interface, switch executes action depending on the case scenario.
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("\nEnter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    library.addBook(newBook);
                    break;
                case 4:
                    library.displayBooks();
                    library.displayCheckedOutBooks();
                    break;
                case 7:
                    System.out.println("\nExiting the program. Goodbye!\n");
                    System.exit(0);
                case 2:
                    BookLoader.loadBooksFromUserInput(library);

                    System.out.println("\nPrinting the current library database...");
                    library.displayBooks();
                    break;
                case 3:
                    System.out.println("\nEnter the barcode of the book to remove:");
                    int barcode = scanner.nextInt();
                    library.removeBookByBarcode(barcode);
                    break;
                case 5: 
                    System.out.print("\nEnter the title of the book to check out: ");
                    scanner.nextLine(); 
                    String checkoutTitle = scanner.nextLine();
                    if (library.checkOutBook(checkoutTitle)) {
                        System.out.println("\n* " + checkoutTitle + " has been checked out. *");
                    } else {
                        System.out.println("\n* Could not find " + checkoutTitle + " or it's already checked out. *");
                    }
                    library.displayBooks();
                    library.displayCheckedOutBooks();
                    break;
                case 6:
                    System.out.print("\nEnter the title of the book to check in: ");
                    scanner.nextLine();
                    String checkinTitle = scanner.nextLine();
                    if (library.checkInBook(checkinTitle)) {
                        System.out.println("\n* " + checkinTitle + " has been successfully checked in. *");
                    } else {
                        System.out.println("\n* Could not check in " + checkinTitle + ". Book might not exist or was not checked out.");
                    }
                    library.displayBooks();
                    library.displayCheckedOutBooks();
                    break;
            }
        }
    }
}